using System;
namespace Problem2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            if (DateTime.Now.Hour < 12)
            {
                this.Text = "Good Morning!";
            }
            else if (DateTime.Now.Hour < 18)
            {
                this.Text = "Good Afternoon!";
            }
            else
            {
                this.Text = "Good Evening!";
            }


        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            MessageBox.Show("Goodbye!");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (button3.Visible)
            {
                button3.Visible = false;
            }
            else
            {
                button3.Visible = true;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            button3.Enabled = !button3.Enabled;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int box1;
            int box2;

            try
            {
                box1 = int.Parse(textBox1.Text);
                box2 = int.Parse(textBox2.Text);
                label1.Text = (box1 * box2).ToString();

            }
            catch (FormatException)
            {
                label1.Text = "Please enter valid integers\nin both text boxes.";
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            comboBox1.Items.Clear();
            for (int i = 0; i < 51; i++)
            {
                comboBox1.Items.Add(i);
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (textBox1.Text.StartsWith("T"))
            {
                textBox1.BackColor = Color.Green;
            }
            else
            {
                textBox1.BackColor = SystemColors.Window;
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            MessageBox.Show("Well done!");
        }
    }
}
