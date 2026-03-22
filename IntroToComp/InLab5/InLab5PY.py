# student object class
# 
class student :
    # initialize highest GPA
    #
    high_gpa = 0.0

    # student object constructor
    def __init__(self, name, gpa, ch_completed):
        # set student name equal to name parameter
        self.name = name

        # set student gpa equal to gpa parameter
        self.gpa = gpa

        # set student course hours equal to course hours parameter
        self.ch_completed = ch_completed

        # if student's GPA is higher, set highest GPA to student's GPA
        student.high_gpa = max(gpa, student.high_gpa)

@property
    def classification(self):
        # freshman
        if self.ch_completed < 30:
            return 1
        # sophomore
        elif self.ch_completed < 60:
            return 2
        # junior
        elif self.ch_completed < 90:
            return 3
        # senior
        else:
            return 4

    # method used when a student completes a new course
    def update(self, course_ch, course_grade):
        # determine new GPA
        self.gpa = ((self.gpa * self.ch_completed) + course_grade * course_ch) / (self.ch_completed + course_ch)

        # add new cours hours to total
        self.ch_completed += course_ch

        # if student's GPA is highest GPA, then set highest GPA to student's GPA
        student.high_gpa = max(self.gpa, student.high_gpa)

class main: 
    def main():
        # create student object s
        s = student("Bob", 3.2, 45)

        # change name of student s to Jane
        s.name = "Jane"

        # display GPA, course hours, and classification of student s
        print(f"GPA: {s.gpa}, CH: {s.ch_completed}, Rank: {s.classification}")

        # add course hours and grade to student s
        s.update(3, 4.1)

        # create student object s2
        s2 = student("John", 4.1, 60)

        # display GPA and highest GPA among all students
        print(f"Bob GPA: {s.gpa}, High GPA: {student.high_gpa}")
              
    if __name__ == "__main__":
        student.main()