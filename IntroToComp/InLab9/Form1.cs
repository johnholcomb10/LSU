namespace InLab9
{
    public partial class Form1 : Form
    {
        // Initialize data structures
        List<string> A = new List<string>();
        Queue<string> Q = new Queue<string>();
        Stack<string> S = new Stack<string>();

        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            // Optional: handle text changed event for textBox1
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // Optional: handle selected index changed event for listBox1
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Add button click event handler
            A.Add(textBox1.Text);
            Q.Enqueue(textBox1.Text);
            S.Push(textBox1.Text);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            // LIFO button click event handler
            listBox1.Items.Clear();
            while (S.Count > 0)
                listBox1.Items.Add(S.Pop());
        }

        private void button3_Click(object sender, EventArgs e)
        {
            // FIFO button click event handler
            listBox1.Items.Clear();
            while (Q.Count > 0)
                listBox1.Items.Add(Q.Dequeue());
        }

        private void button4_Click(object sender, EventArgs e)
        {
            // Sorted button click event handler
            listBox1.Items.Clear();
            A.Sort();
            foreach (string item in A)
                listBox1.Items.Add(item);
        }
    }
}