using System;

namespace Problem1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int boxHeight = Convert.ToInt32(textBox1.Text);
            int boxWidth = Convert.ToInt32(textBox2.Text);
            int boxDepth = Convert.ToInt32(textBox3.Text);

            int containerHeight = Convert.ToInt32(textBox4.Text);
            int containerWidth = Convert.ToInt32(textBox5.Text);
            int containerDepth = Convert.ToInt32(textBox6.Text);

            int boxesInHeight = (containerHeight - 3) / boxHeight;
            int boxesInWidth = (containerWidth - 3) / boxWidth;
            int boxesInDepth = containerDepth / boxDepth;

            label6.Text = $"Number of boxes that can fit: {boxesInHeight * boxesInWidth * boxesInDepth}";
        }
    }
}
