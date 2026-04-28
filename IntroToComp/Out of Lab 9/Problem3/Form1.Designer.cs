namespace Problem3
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            listBox1 = new ListBox();
            listBox2 = new ListBox();
            button1 = new Button();
            button2 = new Button();
            button3 = new Button();
            button4 = new Button();
            button5 = new Button();
            button6 = new Button();
            button7 = new Button();
            checkBox1 = new CheckBox();
            textBox1 = new TextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(30, 29);
            label1.Name = "label1";
            label1.Size = new Size(65, 20);
            label1.TabIndex = 0;
            label1.Text = "Group 1:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(233, 29);
            label2.Name = "label2";
            label2.Size = new Size(65, 20);
            label2.TabIndex = 1;
            label2.Text = "Group 2:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(30, 296);
            label3.Name = "label3";
            label3.Size = new Size(156, 20);
            label3.TabIndex = 2;
            label3.Text = "Add name to Group 1:";
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.Location = new Point(30, 52);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(150, 224);
            listBox1.TabIndex = 3;
            // 
            // listBox2
            // 
            listBox2.FormattingEnabled = true;
            listBox2.Location = new Point(233, 52);
            listBox2.Name = "listBox2";
            listBox2.Size = new Size(150, 224);
            listBox2.TabIndex = 4;
            // 
            // button1
            // 
            button1.BackColor = SystemColors.Control;
            button1.Location = new Point(186, 79);
            button1.Name = "button1";
            button1.Size = new Size(41, 29);
            button1.TabIndex = 6;
            button1.Text = ">";
            button1.UseVisualStyleBackColor = false;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(186, 114);
            button2.Name = "button2";
            button2.Size = new Size(41, 29);
            button2.TabIndex = 7;
            button2.Text = "<";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // button3
            // 
            button3.Location = new Point(186, 149);
            button3.Name = "button3";
            button3.Size = new Size(41, 29);
            button3.TabIndex = 8;
            button3.Text = ">>";
            button3.UseVisualStyleBackColor = true;
            button3.Click += button3_Click;
            // 
            // button4
            // 
            button4.Location = new Point(186, 184);
            button4.Name = "button4";
            button4.Size = new Size(41, 29);
            button4.TabIndex = 9;
            button4.Text = "<<";
            button4.UseVisualStyleBackColor = true;
            button4.Click += button4_Click;
            // 
            // button5
            // 
            button5.Location = new Point(161, 319);
            button5.Name = "button5";
            button5.Size = new Size(41, 29);
            button5.TabIndex = 10;
            button5.Text = "+";
            button5.UseVisualStyleBackColor = true;
            button5.Click += button5_Click;
            // 
            // button6
            // 
            button6.Location = new Point(272, 282);
            button6.Name = "button6";
            button6.Size = new Size(74, 29);
            button6.TabIndex = 11;
            button6.Text = "remove";
            button6.UseVisualStyleBackColor = true;
            button6.Click += button6_Click;
            // 
            // button7
            // 
            button7.Location = new Point(364, 356);
            button7.Name = "button7";
            button7.Size = new Size(74, 29);
            button7.TabIndex = 12;
            button7.Text = "Close";
            button7.UseVisualStyleBackColor = true;
            button7.Click += button7_Click;
            // 
            // checkBox1
            // 
            checkBox1.AutoSize = true;
            checkBox1.Location = new Point(30, 370);
            checkBox1.Name = "checkBox1";
            checkBox1.Size = new Size(311, 24);
            checkBox1.TabIndex = 13;
            checkBox1.Text = "Remove names containg \"b\" from group 1";
            checkBox1.UseVisualStyleBackColor = true;
            checkBox1.CheckedChanged += checkBox1_CheckedChanged;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(30, 321);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(125, 27);
            textBox1.TabIndex = 14;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(450, 400);
            Controls.Add(textBox1);
            Controls.Add(checkBox1);
            Controls.Add(button7);
            Controls.Add(button6);
            Controls.Add(button5);
            Controls.Add(button4);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(listBox2);
            Controls.Add(listBox1);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private ListBox listBox1;
        private ListBox listBox2;
        private Button button1;
        private Button button2;
        private Button button3;
        private Button button4;
        private Button button5;
        private Button button6;
        private Button button7;
        private CheckBox checkBox1;
        private TextBox textBox1;
    }
}
