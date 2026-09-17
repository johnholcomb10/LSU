import sqlite3
import tkinter as tk
from tkinter import ttk, messagebox

########################################
# DATABASE
########################################

conn = sqlite3.connect("lab11.db")
cursor = conn.cursor()

cursor.execute("PRAGMA foreign_keys = ON")

cursor.execute("""
CREATE TABLE IF NOT EXISTS Courses(
CourseNumber INTEGER PRIMARY KEY,
CourseName TEXT,
CatalogDescription TEXT,
Required INTEGER,
LastOffered TEXT,
CreditHours INTEGER,
LabCourse INTEGER
)
""")

cursor.execute("""
CREATE TABLE IF NOT EXISTS Offerings(
OfferingID INTEGER PRIMARY KEY AUTOINCREMENT,
CourseNumber INTEGER,
Semester TEXT,
FourteenDayEnrollment INTEGER,
FOREIGN KEY(CourseNumber) REFERENCES Courses(CourseNumber)
)
""")

cursor.execute("""
CREATE TABLE IF NOT EXISTS Students(
StudentID INTEGER PRIMARY KEY,
LastName TEXT,
FirstName TEXT,
DOB TEXT,
Rank TEXT,
GPA REAL,
CourseNumber INTEGER,
FOREIGN KEY(CourseNumber) REFERENCES Courses(CourseNumber)
)
""")

conn.commit()

########################################
# HELPER
########################################

def get_courses():

    cursor.execute("SELECT CourseNumber FROM Courses")

    return [r[0] for r in cursor.fetchall()]

########################################
# COURSE EDIT WINDOW
########################################

class CourseEditor:

    def __init__(self,refresh,data=None):

        self.refresh = refresh
        self.data = data

        self.win = tk.Toplevel()
        self.win.title("Course Entry")

        labels=[
        "CourseNumber","CourseName","Description",
        "Required","LastOffered","CreditHours","LabCourse"
        ]

        self.entries=[]

        for i,l in enumerate(labels):

            tk.Label(self.win,text=l).grid(row=i,column=0)

            e=tk.Entry(self.win)
            e.grid(row=i,column=1)

            self.entries.append(e)

        if data:
            for i,v in enumerate(data):
                self.entries[i].insert(0,v)

        tk.Button(self.win,text="Save",command=self.save).grid(row=8,column=0)

    def save(self):

        values=[e.get() for e in self.entries]

        try:

            if self.data:

                cursor.execute("""
                UPDATE Courses
                SET CourseName=?,CatalogDescription=?,
                Required=?,LastOffered=?,CreditHours=?,LabCourse=?
                WHERE CourseNumber=?
                """,(
                values[1],values[2],values[3],
                values[4],values[5],values[6],values[0]
                ))

            else:

                cursor.execute("""
                INSERT INTO Courses
                VALUES(?,?,?,?,?,?,?)
                """,values)

            conn.commit()

            self.refresh()

            self.win.destroy()

        except Exception as e:
            messagebox.showerror("Error",str(e))

########################################
# COURSES TAB
########################################

class CoursesTab:

    def __init__(self,frame):

        cols=("CourseNumber","CourseName","CatalogDescription",
        "Required","LastOffered","CreditHours","LabCourse")

        self.tree=ttk.Treeview(frame,columns=cols,show="headings")

        for c in cols:
            self.tree.heading(c,text=c)
            self.tree.column(c,width=120)

        self.tree.pack(fill="both",expand=True)

        btn=tk.Frame(frame)
        btn.pack()

        tk.Button(btn,text="Add",command=self.add).grid(row=0,column=0,padx=5)
        tk.Button(btn,text="Edit",command=self.edit).grid(row=0,column=1,padx=5)
        tk.Button(btn,text="Delete",command=self.delete).grid(row=0,column=2,padx=5)
        tk.Button(btn,text="Refresh",command=self.load).grid(row=0,column=3,padx=5)

        self.load()

    def load(self):

        for r in self.tree.get_children():
            self.tree.delete(r)

        cursor.execute("SELECT * FROM Courses")

        for r in cursor.fetchall():
            self.tree.insert("",tk.END,values=r)

    def add(self):

        CourseEditor(self.load)

    def edit(self):

        sel=self.tree.selection()

        if not sel:
            return

        data=self.tree.item(sel[0])["values"]

        CourseEditor(self.load,data)

    def delete(self):

        sel=self.tree.selection()

        if not sel:
            return

        data=self.tree.item(sel[0])["values"]

        cursor.execute("DELETE FROM Courses WHERE CourseNumber=?",(data[0],))

        conn.commit()

        self.load()

########################################
# OFFERINGS TAB
########################################

class OfferingsTab:

    def __init__(self,frame):

        cols=("OfferingID","CourseNumber","Semester","FourteenDayEnrollment")

        self.tree=ttk.Treeview(frame,columns=cols,show="headings")

        for c in cols:
            self.tree.heading(c,text=c)
            self.tree.column(c,width=140)

        self.tree.pack(fill="both",expand=True)

        btn=tk.Frame(frame)
        btn.pack()

        tk.Button(btn,text="Add",command=self.add).grid(row=0,column=0)
        tk.Button(btn,text="Delete",command=self.delete).grid(row=0,column=1)
        tk.Button(btn,text="Refresh",command=self.load).grid(row=0,column=2)

        self.load()

    def load(self):

        for r in self.tree.get_children():
            self.tree.delete(r)

        cursor.execute("SELECT * FROM Offerings")

        for r in cursor.fetchall():
            self.tree.insert("",tk.END,values=r)

    def add(self):

        win=tk.Toplevel()

        tk.Label(win,text="CourseNumber").grid(row=0,column=0)

        c=ttk.Combobox(win,values=get_courses())
        c.grid(row=0,column=1)

        tk.Label(win,text="Semester").grid(row=1,column=0)

        s=tk.Entry(win)
        s.grid(row=1,column=1)

        tk.Label(win,text="Enrollment").grid(row=2,column=0)

        e=tk.Entry(win)
        e.grid(row=2,column=1)

        def save():

            cursor.execute("""
            INSERT INTO Offerings
            (CourseNumber,Semester,FourteenDayEnrollment)
            VALUES(?,?,?)
            """,(c.get(),s.get(),e.get()))

            conn.commit()

            self.load()

            win.destroy()

        tk.Button(win,text="Save",command=save).grid(row=3,column=0)

    def delete(self):

        sel=self.tree.selection()

        if not sel:
            return

        data=self.tree.item(sel[0])["values"]

        cursor.execute("DELETE FROM Offerings WHERE OfferingID=?",(data[0],))

        conn.commit()

        self.load()

########################################
# STUDENTS TAB
########################################

class StudentsTab:

    def __init__(self,frame):

        cols=("StudentID","LastName","FirstName","DOB","Rank","GPA","CourseNumber")

        self.tree=ttk.Treeview(frame,columns=cols,show="headings")

        for c in cols:
            self.tree.heading(c,text=c)
            self.tree.column(c,width=120)

        self.tree.pack(fill="both",expand=True)

        btn=tk.Frame(frame)
        btn.pack()

        tk.Button(btn,text="Add",command=self.add).grid(row=0,column=0)
        tk.Button(btn,text="Delete",command=self.delete).grid(row=0,column=1)
        tk.Button(btn,text="Refresh",command=self.load).grid(row=0,column=2)

        self.load()

    def load(self):

        for r in self.tree.get_children():
            self.tree.delete(r)

        cursor.execute("SELECT * FROM Students")

        for r in cursor.fetchall():
            self.tree.insert("",tk.END,values=r)

    def add(self):

        win=tk.Toplevel()

        labels=["StudentID","LastName","FirstName","DOB","Rank","GPA"]

        entries=[]

        for i,l in enumerate(labels):

            tk.Label(win,text=l).grid(row=i,column=0)

            e=tk.Entry(win)
            e.grid(row=i,column=1)

            entries.append(e)

        tk.Label(win,text="CourseNumber").grid(row=6,column=0)

        c=ttk.Combobox(win,values=get_courses())
        c.grid(row=6,column=1)

        def save():

            vals=[e.get() for e in entries]

            cursor.execute("""
            INSERT INTO Students VALUES(?,?,?,?,?,?,?)
            """,(*vals,c.get()))

            conn.commit()

            self.load()

            win.destroy()

        tk.Button(win,text="Save",command=save).grid(row=7,column=0)

    def delete(self):

        sel=self.tree.selection()

        if not sel:
            return

        data=self.tree.item(sel[0])["values"]

        cursor.execute("DELETE FROM Students WHERE StudentID=?",(data[0],))

        conn.commit()

        self.load()

########################################
# SAMPLE QUERIES
########################################

def run_queries():

    win=tk.Toplevel()
    win.title("Sample Queries")

    text=tk.Text(win,width=80,height=20)
    text.pack()

    queries=[

    ("Highest GPA Student",
     "SELECT LastName FROM Students ORDER BY GPA DESC LIMIT 1"),

    ("Average GPA Seniors",
     "SELECT AVG(GPA) FROM Students WHERE Rank='Senior'"),

    ("Students With Courses",
     """SELECT Students.FirstName,Students.LastName,Courses.CourseName
        FROM Students
        JOIN Courses
        ON Students.CourseNumber = Courses.CourseNumber"""),

    ("Courses With Offerings",
     """SELECT Courses.CourseName,Offerings.Semester
        FROM Courses
        JOIN Offerings
        ON Courses.CourseNumber = Offerings.CourseNumber""")
    ]

    for name,q in queries:

        cursor.execute(q)

        result=cursor.fetchall()

        text.insert(tk.END,"\n"+name+"\n")

        for r in result:
            text.insert(tk.END,str(r)+"\n")

########################################
# MAIN WINDOW
########################################

root=tk.Tk()

root.title("IE2060 Lab 11 Database")

top=tk.Frame(root)
top.pack()

tk.Button(top,text="Run Sample Queries",command=run_queries).pack()

tabs=ttk.Notebook(root)

courses_frame=tk.Frame(tabs)
offerings_frame=tk.Frame(tabs)
students_frame=tk.Frame(tabs)

tabs.add(courses_frame,text="Courses")
tabs.add(offerings_frame,text="Offerings")
tabs.add(students_frame,text="Students")

tabs.pack(fill="both",expand=True)

CoursesTab(courses_frame)
OfferingsTab(offerings_frame)
StudentsTab(students_frame)

root.mainloop()

conn.close()
