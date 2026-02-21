using System;

class Program {
    static void Main(string[] args) {
        // Prompt user to enter the date and time for meeting
        Console.WriteLine("Enter the date and time based on this format: MM/DD/YY HH:MM tt");
        string inputDateTime = Console.ReadLine();

        // Prompt the user to input the duration of the meeting in hours
        Console.WriteLine("Enter the duration of the meeting in hours:");
        double inputMeetingDuration = double.Parse(Console.ReadLine());

        // Parse inputDateTime into dateTime object
        DateTime meetingDateTime = DateTime.Parse(inputDateTime);

        // Calculate the end time of the meeting
        DateTime endOfMeeting = meetingDateTime.AddHours(inputMeetingDuration);
        Console.WriteLine($"End of the meeting: {endOfMeeting}");

        // Calculate the duration of the meeting in minutes
        double minutesUntilEnd = (endOfMeeting - meetingDateTime).TotalMinutes;
        Console.WriteLine($"Duration of meeting in minutes: {minutesUntilEnd} minutes");

        // Calculate the date 2 days befor the event for setting up reminder
        DateTime reminderDate = meetingDateTime.AddDays(-2);
        Console.WriteLine($"Reminder date: {reminderDate}");

        // Calculate the number of days between the current date and meeting date
        TimeSpan daysUntilMeeeting = meetingDateTime - DateTime.Now;
        Console.WriteLine($"Days until meeting: {daysUntilMeeeting} days");
    }
}