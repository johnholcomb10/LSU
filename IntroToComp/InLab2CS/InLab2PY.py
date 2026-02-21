from datetime import datetime, timedelta

# Prompt user for input
print("Enter the date and time of the meeting (MM/DD/YY HH:MM tt):")
inputDateTime = input()

print("Enter the duration of the meeting in hours:")
inputMeetingDuration = float(input())

# Parse inputDateTime
meetingDateTime = datetime.strptime(inputDateTime, "%m/%d/%y %I:%M %p")

# Calculate end of meeting
endOfMeeting = meetingDateTime + timedelta(hours = inputMeetingDuration)
print(f"End of meeting: {endOfMeeting}")

# Calculate end of meeting in minutes
minutesUntilEnd = (endOfMeeting - meetingDateTime).total_seconds()/60
print(f"Length of meeting in minutes: {minutesUntilEnd} minutes")

# Calculate the date 2 days before meeting
reminderDate = meetingDateTime - timedelta(days = 2)
print(f"Reminder date: {reminderDate.strftime("%m/%d/%y")}")

# Calculate the number of days between the current date and meeting date
daysUntilMeeting = (meetingDateTime - datetime.now()).days
print(f"Days until event: {daysUntilMeeting} days")