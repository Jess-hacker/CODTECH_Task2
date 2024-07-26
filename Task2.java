import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        String input;
        
        System.out.println("Welcome to the Student Grade Tracker");

        // Collect grades from the user
        while (true) {
            System.out.println("Enter a grade (or type 'done' to finish):");
            input = scanner.next();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                double grade = Double.parseDouble(input);
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                } else {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
            }
        }
        
        // Calculate the average grade
        double average = calculateAverage(grades);
        
        // Determine the letter grade
        String letterGrade = determineLetterGrade(average);

        // Display results
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + average);
        System.out.println("Letter Grade: " + letterGrade);
    }

    // Method to calculate the average grade
    public static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0.0;
    }

    // Method to determine the letter grade
    public static String determineLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
