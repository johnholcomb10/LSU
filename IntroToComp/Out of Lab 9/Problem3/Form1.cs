namespace Problem3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String[] L = new String[listBox1.SelectedItems.Count];
            listBox1.SelectedItems.CopyTo(L, 0);
            foreach (String S in L)
            {
                listBox2.Items.Add(S);
                listBox1.Items.Remove(S);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            String[] L = new String[listBox2.SelectedItems.Count];
            listBox2.SelectedItems.CopyTo(L, 0);
            foreach (String S in L)
            {
                listBox1.Items.Add(S);
                listBox2.Items.Remove(S);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            listBox2.Items.AddRange(listBox1.Items);
            listBox1.Items.Clear();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            listBox1.Items.AddRange(listBox2.Items);
            listBox2.Items.Clear();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            listBox1.Items.Add(textBox1.Text);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            String[] L = new String[listBox2.SelectedItems.Count];
            listBox2.SelectedItems.CopyTo(L, 0);
            foreach (String S in L)
                listBox2.Items.Remove(S);
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            for (int i = 0; i < listBox1.Items.Count; i++)
            {
                if (Convert.ToString(listBox1.Items[i]).ToLower().Contains("b"))
                {
                    listBox1.Items.RemoveAt(i);
                    i--;
                }
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
