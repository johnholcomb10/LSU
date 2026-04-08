using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace OutOfLab7
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            double X, Y;
            if (Double.TryParse(textBox1.Text, out X) && double.TryParse(textBox2.Text, out Y))
            {
                textBox1.Enabled = false;
                textBox2.Enabled = false;
                label1.Text = String.Format("result is {0:#,##0.00}", X + Y);
            }
            else
                label1.Text = "No good!";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            double X, Y;
            if (Double.TryParse(textBox1.Text, out X) && double.TryParse(textBox2.Text, out Y))
            {
                textBox1.Enabled = false;
                textBox2.Enabled = false;
                label2.Text = String.Format("result is {0:#,##0.00}", X - Y);
            }
            else
                label2.Text = "No good!";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            double X, Y;
            if (Double.TryParse(textBox1.Text, out X) && double.TryParse(textBox2.Text, out Y))
            {
                textBox1.Enabled = false;
                textBox2.Enabled = false;
                label3.Text = String.Format("result is {0:#,##0.00}", X * Y);
            }
            else
                label3.Text = "No good!";
        }

        private void button4_Click(object sender, EventArgs e)
        {
            double X, Y;
            if (Double.TryParse(textBox1.Text, out X) && double.TryParse(textBox2.Text, out Y))
            {
                textBox1.Enabled = false;
                textBox2.Enabled = false;
                label4.Text = String.Format("result is {0:#,##0.00}", X / Y);
            }
            else
                label4.Text = "No good!";
        }
    }
}
