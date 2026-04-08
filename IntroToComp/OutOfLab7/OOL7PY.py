import tkinter as tk

#### Create and configure the form object ####
form1 = tk.Tk()
form1.title("4-Function Calculator") # What shows in title bar
form1.geometry("720x240") # Width x Height + XPOS + YPOS (of upper left corner), all in pixels
form1.configure(bg="light blue")

#### Define & configure controls (widgets) for the form ####

# textBox1
textBox1 = tk.Entry(form1, background='light green', font=("Sans Serif", 9))
textBox1.grid(row=0, column=0, padx=10, pady=10)

# textBox2
textBox2 = tk.Entry(form1, background='light green', font=("Sans Serif", 9))
textBox2.grid(row=1, column=0, padx=10, pady=10)

# button1
button1 = tk.Button(form1, text="+", font=("Sans Serif", 9))
button1.grid(row=2, column=0, padx=10, pady=10)

# label1
label1 = tk.Label(form1, text="label1:", fg='red', font=("Sans Serif", 14))
label1.grid(row=3, column=0, padx=10, pady=10)

# button2
button2 = tk.Button(form1, text="-", font=("Sans Serif", 9))
button2.grid(row=2, column=1, padx=10, pady=10)

# label2
label2 = tk.Label(form1, text="label2:", fg='red', font=("Sans Serif", 14))
label2.grid(row=3, column=1, padx=10, pady=10)

# button3
button3 = tk.Button(form1, text="*", font=("Sans Serif", 9))
button3.grid(row=2, column=2, padx=10, pady=10)

# label3
label3 = tk.Label(form1, text="label3:", fg='red', font=("Sans Serif", 14))
label3.grid(row=3, column=2, padx=10, pady=10)

# button4
button4 = tk.Button(form1, text="/", font=("Sans Serif", 9))
button4.grid(row=2, column=3, padx=10, pady=10)

# label4
label4 = tk.Label(form1, text="label4:", fg='red', font=("Sans Serif", 14))
label4.grid(row=3, column=3, padx=10, pady=10)

#### Register Widget Event Handlers ####

# button1 click event
def button1Click(event):
    try:
        X = float(textBox1.get())
        Y = float(textBox2.get())
        label1.configure(text="Result is {0:,.2f}".format(X + Y))
        textBox1.configure(state="disabled")
        textBox2.configure(state="disabled")
    except ValueError:
        label1.configure(text="No good!")

button1.bind("<Button-1>", button1Click)

# button2 click event
def button2Click(event):
    try:
        X = float(textBox1.get())
        Y = float(textBox2.get())
        label2.configure(text="Result is {0:,.2f}".format(X - Y))
        textBox1.configure(state="disabled")
        textBox2.configure(state="disabled")
    except ValueError:
        label2.configure(text="No good!")

button2.bind("<Button-1>", button2Click)

# button3 click event
def button3Click(event):
    try:
        X = float(textBox1.get())
        Y = float(textBox2.get())
        label3.configure(text="Result is {0:,.2f}".format(X * Y))
        textBox1.configure(state="disabled")
        textBox2.configure(state="disabled")
    except ValueError:
        label3.configure(text="No good!")

button3.bind("<Button-1>", button3Click)

# button4 click event
def button4Click(event):
    try:
        X = float(textBox1.get())
        Y = float(textBox2.get())
        label4.configure(text="Result is {0:,.2f}".format(X / Y))
        textBox1.configure(state="disabled")
        textBox2.configure(state="disabled")
    except ValueError:
        label4.configure(text="No good!")

button4.bind("<Button-1>", button4Click)

# Start main form (Form1) up
form1.mainloop()
