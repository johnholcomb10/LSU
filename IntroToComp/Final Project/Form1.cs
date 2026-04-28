using System;
using System.IO;
using System.Text;
using System.Xml.Linq;
using System.Text.Json;
using System.Text.RegularExpressions;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Final_Project
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            // Initialize form components
            InitializeComponent();

            // Set initial visibility and text
            label3.Text = "";
            button2.Visible = false;
            label4.Visible = false;
            label9.Visible = false;
            label10.Visible = false;
            label11.Visible = false;
            label12.Visible = false;
            textBox3.Visible = false;
            textBox4.Visible = false;
            textBox5.Visible = false;
            textBox6.Visible = false;
            textBox7.Visible = false;
        }

        // Checks for non-empty name
        private bool IsValidName(string name)
        {
            return !string.IsNullOrWhiteSpace(name);
        }

        // Checks for valid email format
        private bool IsValidEmail(string email)
        {
            return Regex.IsMatch(email, @"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$");
        }

        // Checks for 16-digit card number
        private bool IsValidCardNumber(string card)
        {
            return card.Length == 16 && card.All(char.IsDigit);
        }

        // Checks for MM/YY format
        private bool IsValidExpiration(string exp)
        {
            return System.Text.RegularExpressions.Regex.IsMatch(exp, @"^(0[1-9]|1[0-2])\/\d{2}$");
        }

        // Checks for 3-digit CVV
        private bool IsValidCVV(string cvv)
        {
            return cvv.Length == 3 && cvv.All(char.IsDigit);
        }

        // Checks for non-empty Viewing ID
        private bool IsValidViewingID(string id)
        {
            return !string.IsNullOrWhiteSpace(id);
        }

        // Checks if the Viewing ID exists in movies.json
        private bool ViewingIDExists(string viewingID)
        {
            try
            {
                // Path to movies.json
                string path = Path.Combine(Application.StartupPath, "movies.json");

                // movies.json must exist to check Viewing ID
                if (!File.Exists(path))
                    return false;

                // Load movies from JSON file
                string json = File.ReadAllText(path);
                List<Movie> movies = JsonSerializer.Deserialize<List<Movie>>(json);

                // No movies found means Viewing ID cannot exist
                if (movies == null)
                    return false;

                // Check if any movie has the given Viewing ID (case-insensitive)
                return movies.Any(m =>
                    m.ViewingID.Equals(viewingID, StringComparison.OrdinalIgnoreCase));
            }
            catch
            {
                // If there's an error reading the file or deserializing, treat as if Viewing ID does not exist
                return false;
            }
        }

        // Retrieves a Movie object by its Viewing ID
        private Movie GetMovieByViewingID(string viewingID)
        {
            try
            {
                // Path to movies.json
                string path = Path.Combine(Application.StartupPath, "movies.json");

                // movies.json must exist to retrieve movie details
                if (!File.Exists(path))
                    return null;

                // Load movies from JSON file
                string json = File.ReadAllText(path);
                List<Movie> movies = JsonSerializer.Deserialize<List<Movie>>(json);

                // Find the movie with the matching Viewing ID (case-insensitive)
                return movies?.FirstOrDefault(m =>
                    m.ViewingID.Equals(viewingID, StringComparison.OrdinalIgnoreCase));
            }
            catch
            {
                // If there's an error reading the file or deserializing, return null
                return null;
            }
        }

        // Updates the TicketsSold count for a movie showing after a purchase
        private void UpdateTicketsSold(string viewingID)
        {
            // Path to movies.json
            string path = Path.Combine(Application.StartupPath, "movies.json");

            // Load movies from JSON file
            string json = File.ReadAllText(path);
            List<Movie> movies = JsonSerializer.Deserialize<List<Movie>>(json);

            // Find the movie with the matching Viewing ID (case-insensitive)
            var movie = movies.FirstOrDefault(m =>
                m.ViewingID.Equals(viewingID, StringComparison.OrdinalIgnoreCase));

            // If movie is found, increment TicketsSold and save back to file
            if (movie != null)
            {
                movie.TicketsSold++;

                string updatedJson = JsonSerializer.Serialize(
                    movies,
                    new JsonSerializerOptions { WriteIndented = true });

                File.WriteAllText(path, updatedJson);
            }
        }

        private string PromptForPassword()
        {
            System.Windows.Forms.Form prompt = new System.Windows.Forms.Form()
            {
                Width = 300,
                Height = 200,
                Text = "Enter Password",
                StartPosition = FormStartPosition.CenterScreen
            };

            Label textLabel = new Label() { Left = 20, Top = 20, Text = "Password:" };
            System.Windows.Forms.TextBox textBox = new System.Windows.Forms.TextBox() { Left = 20, Top = 50, Width = 240, UseSystemPasswordChar = true };
            System.Windows.Forms.Button confirmation = new System.Windows.Forms.Button() { Text = "OK", Left = 180, Width = 80, Top = 80, Height = 30 };

            string result = null;

            confirmation.Click += (sender, e) =>
            {
                result = textBox.Text;
                prompt.Close();
            };

            prompt.Controls.Add(textLabel);
            prompt.Controls.Add(textBox);
            prompt.Controls.Add(confirmation);

            prompt.ShowDialog();
            return result;
        }

        // Handles the click event for the first button to determine ticket price and type based on age
        private void button1_Click(object sender, EventArgs e)
        {
            // Initialize variables
            int age = 0;
            int price = 0;
            string type = "";

            // Validate age input
            if (!int.TryParse(textBox2.Text, out age))
            {
                label3.Text = "Please enter a valid age.";
                return;
            }
            // Determine ticket price and type based on age
            else if (age >= 1 && age <= 17)
            {
                price = 0;
                type = "Child";
            }
            else if (age >= 18 && age <= 54)
            {
                price = 15;
                type = "Adult";
            }
            else
            {
                price = 10;
                type = "Senior";
            }

        // Display the ticket type and price
        label3.Text = String.Format("Type: {0} | Price: ${1}", type, price);

            // Make the purchase form elements visible
            button2.Visible = true;
            label4.Visible = true;
            label9.Visible = true;
            label10.Visible = true;
            label11.Visible = true;
            label12.Visible = true;
            textBox3.Visible = true;
            textBox4.Visible = true;
            textBox5.Visible = true;
            textBox6.Visible = true;
            textBox7.Visible = true;
        }

        // Handles the click event for the second button to validate purchase information and save it to purchases.json
        private void button2_Click(object sender, EventArgs e)
        {
            // Gather input values, eliminate leading/trailing whitespace
            string name = textBox1.Text.Trim();
            string email = textBox3.Text.Trim();
            string card = textBox4.Text.Trim();
            string exp = textBox6.Text.Trim();
            string cvv = textBox5.Text.Trim();
            string viewingID = textBox7.Text.Trim();

            // Validate name is not empty
            if (!IsValidName(name))
            {
                MessageBox.Show("Enter a valid name.");
                return;
            }

            // Validate email format
            if (!IsValidEmail(email))
            {
                MessageBox.Show("Enter a valid email address.");
                return;
            }

            // Validate credit card number format
            if (!IsValidCardNumber(card))
            {
                MessageBox.Show("Card must be 16 digits.");
                return;
            }

            // Validate expiration date format
            if (!IsValidExpiration(exp))
            {
                MessageBox.Show("Expiration must be MM/YY.");
                return;
            }

            // Validate CVV format
            if (!IsValidCVV(cvv))
            {
                MessageBox.Show("CVV must be 3 digits.");
                return;
            }

            // Validate Viewing ID is not empty
            if (!IsValidViewingID(viewingID))
            {
                MessageBox.Show("Enter a valid Viewing ID.");
                return;
            }

            // Validate that the Viewing ID exists in movies.json
            if (!ViewingIDExists(viewingID))
            {
                MessageBox.Show("Viewing ID does not exist. Please select a valid movie showing.");
                return;
            }

            // Retrieve the movie details for the given Viewing ID
            Movie selectedMovie = GetMovieByViewingID(viewingID);

            // If the movie is not found (which shouldn't happen if ViewingIDExists returned true), show an error
            if (selectedMovie == null)
            {
                MessageBox.Show("Viewing not found.");
                return;
            }

            // Check if the showing is sold out based on TicketsSold and Capacity
            if (selectedMovie.TicketsSold >= selectedMovie.Capacity)
            {
                MessageBox.Show("This showing is sold out.");
                return;
            }

            // If all validations pass, save the purchase information to purchases.json
            try
            {
                // Path to purchases.json
                string path = Path.Combine(Application.StartupPath, "purchases.json");

                // List to hold purchase data
                List<Purchase> purchases;

                // Load existing or create new list
                if (File.Exists(path))
                {
                    string existingJson = File.ReadAllText(path);
                    purchases = JsonSerializer.Deserialize<List<Purchase>>(existingJson) ?? new List<Purchase>();
                }
                else
                {
                    purchases = new List<Purchase>();
                }

                // Create purchase
                Purchase newPurchase = new Purchase
                {
                    // Store user details
                    Name = name,
                    Email = email,
                    CreditCardNumber = card,
                    Expiration = exp,
                    CVV = cvv,
                    ViewingID = viewingID
                };

                // Add new purchase to list
                purchases.Add(newPurchase);

                // Save back to file
                string updatedJson = JsonSerializer.Serialize(purchases, new JsonSerializerOptions { WriteIndented = true });
                File.WriteAllText(path, updatedJson);

                // Update the TicketsSold count for the movie showing
                UpdateTicketsSold(viewingID);

                // Inform the user of successful purchase
                MessageBox.Show("Purchase saved successfully!");
            }
            // Handle any exceptions that occur during the file operations
            catch (Exception ex)
            {
                MessageBox.Show("Error saving purchase: " + ex.Message);
            }
        }

        // Handles the click event for the third button to load and display movie showings from movies.json
        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                // Path to movies.json
                string path = Path.Combine(Application.StartupPath, "movies.json");

                // Check if movies.json exists before attempting to read
                if (!File.Exists(path))
                {
                    MessageBox.Show("movies.json not found.");
                    return;
                }

                // Load movies from JSON file
                string json = File.ReadAllText(path);
                List<Movie> movies = JsonSerializer.Deserialize<List<Movie>>(json);

                // Check if any movies were loaded
                if (movies == null || movies.Count == 0)
                {
                    MessageBox.Show("No movie showings available.");
                    return;
                }

                // Build display text
                StringBuilder sb = new StringBuilder();

                // Header for the showings list
                sb.AppendLine("NOW SHOWING");
                sb.AppendLine(new string('-', 30));
                sb.AppendLine();

                // Loop through each movie and append its details to the display text
                foreach (var movie in movies)
                {
                    sb.AppendLine(movie.ViewingID);
                    sb.AppendLine(movie.Title);
                    sb.AppendLine($"Time: {movie.Time}");
                    sb.AppendLine($"Auditorium: {movie.Auditorium}");
                    sb.AppendLine($"Capacity: {movie.Capacity}");
                    sb.AppendLine($"Tickets Sold: {movie.TicketsSold}");
                    sb.AppendLine(new string('-', 30));
                }

                // Show the movie showings in a message box
                MessageBox.Show(sb.ToString(), "Cinema Showings");
            }
            // Handle any exceptions that occur during the file operations or JSON deserialization
            catch (Exception ex)
            {
                MessageBox.Show("Error loading movies: " + ex.Message);
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            string password = PromptForPassword();

            // 🔐 Change this to whatever you want
            if (password != "admin123")
            {
                MessageBox.Show("Incorrect password.");
                return;
            }

            try
            {
                string jsonPath = Path.Combine(Application.StartupPath, "purchases.json");

                if (!File.Exists(jsonPath))
                {
                    MessageBox.Show("No purchases found.");
                    return;
                }

                string json = File.ReadAllText(jsonPath);
                List<Purchase> purchases = JsonSerializer.Deserialize<List<Purchase>>(json);

                if (purchases == null || purchases.Count == 0)
                {
                    MessageBox.Show("No purchases to export.");
                    return;
                }

                StringBuilder sb = new StringBuilder();

                sb.AppendLine("PURCHASE REPORT");
                sb.AppendLine(new string('=', 40));
                sb.AppendLine();

                foreach (var p in purchases)
                {
                    sb.AppendLine($"Name: {p.Name}");
                    sb.AppendLine($"Viewing ID: {p.ViewingID}");
                    sb.AppendLine($"Card: **** **** **** {p.CreditCardNumber.Substring(p.CreditCardNumber.Length - 4)}");
                    sb.AppendLine($"Exp: {p.Expiration}");
                    sb.AppendLine(new string('-', 40));
                }

                string outputPath = Path.Combine(Application.StartupPath, "PurchaseReport.txt");
                File.WriteAllText(outputPath, sb.ToString());

                MessageBox.Show("Purchases exported successfully!\n\nSaved to:\n" + outputPath);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error exporting purchases: " + ex.Message);
            }
        }
    }
}