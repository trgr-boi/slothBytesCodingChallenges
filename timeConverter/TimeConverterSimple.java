package cui;

import java.util.Scanner;

public class TimeConverterSimple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time (e.g., 02:30 PM or 14:30): ");
        String inputTime = scanner.nextLine();

        String convertedTime;
        if (inputTime.toUpperCase().contains("AM") || inputTime.toUpperCase().contains("PM")) {
            // convert 12 to 24
            convertedTime = convertTo24Hour(inputTime);
        } else {
            // convert 24 to 12
            convertedTime = convertTo12Hour(inputTime);
        }
        
        System.out.println("Converted Time: " + convertedTime);
        scanner.close();
    }
    
    // converts 12 to 24
    private static String convertTo24Hour(String time12Hour) {
        try {
            java.text.SimpleDateFormat displayFormat = new java.text.SimpleDateFormat("HH:mm");
            java.text.SimpleDateFormat parseFormat = new java.text.SimpleDateFormat("hh:mm a");
            java.util.Date date = parseFormat.parse(time12Hour);
            return displayFormat.format(date);
        } catch (Exception e) {
            return "Invalid time format!";
        }
    }
    
    // converts 24 to 12
    private static String convertTo12Hour(String time24Hour) {
        try {
            java.text.SimpleDateFormat displayFormat = new java.text.SimpleDateFormat("hh:mm a");
            java.text.SimpleDateFormat parseFormat = new java.text.SimpleDateFormat("HH:mm");
            java.util.Date date = parseFormat.parse(time24Hour);
            return displayFormat.format(date);
        } catch (Exception e) {
            return "Invalid time format!";
        }
    }
}

