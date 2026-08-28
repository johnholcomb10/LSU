import tkinter as tk
from queue import LifoQueue, Queue

# Create/initialize data structures
AL = []
Q = Queue()
S = LifoQueue()

# Create form
Q1 = tk.Tk()
Q1.title("Q1")
Q1.geometry("500x500")

# Define event handlers
def addClick():
    AL.append(value.get())
    Q.put(value.get())
    S.put(value.get())

def lifoClick():
    listBox1.delete(0, "end")
    while not S.empty():
        listBox1.insert("end", S.get())

def fifoClick():
    listBox1.delete(0, "end")
    while not Q.empty():
        listBox1.insert("end", Q.get())

def sortClick():
    listBox1.delete(0, "end")
    AL.sort()
    for S1 in AL:
        listBox1.insert("end", S1)

# Define form elements

# textbox:
value = tk.StringVar()
tk.Entry(Q1, textvariable=value).grid(row=0, column=0, padx=6, pady=6)

# "add" button:
tk.Button(Q1, text="ADD", command=addClick).grid(row=0, column=1, padx=6, pady=6, sticky="W")

# listbox:
listBox1 = tk.Listbox(Q1, height=15)
listBox1.grid(row=0, column=2, rowspan=5, padx=6, pady=6)

# lifo, fifo, and sort list buttons:
tk.Button(Q1, text="Show values in LIFO order", command=lifoClick).grid(row=1, column=0, columnspan=2, padx=6, pady=6, sticky="W")
tk.Button(Q1, text="Show values in FIFO order", command=fifoClick).grid(row=2, column=0, columnspan=2, padx=6, pady=6, sticky="W")
tk.Button(Q1, text="Show sorted list values", command=sortClick).grid(row=3, column=0, columnspan=2, padx=6, pady=6, sticky="W")

# Start Main form (Q1) loop
Q1.mainloop()
