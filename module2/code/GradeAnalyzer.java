package module2.code;

import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    public static void main(String[] args) {
        int[] skipped = { 0 };
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(args[0], skipped);
        // Step 2: calculate statistics
        if (scores.size() > 0) {
            for (int score : scores) {
                if (score > max) {
                    max = score;
                }
                if (score < min) {
                    min = score;
                }
                if (score >= 90) {
                    countA++;
                } else if (score >= 80) {
                    countB++;
                } else if (score >= 70) {
                    countC++;
                } else if (score >= 60) {
                    countD++;
                } else {
                    countF++;
                }
            }
            // Step 3: write and print report
            writeReport(scores, calculateAverage(scores), max, min,
                    "output.txt", skipped, countA, countB, countC, countD, countF);
        } else {
            System.out.println("Scores list is empty. Skipping report.");
        }
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename, int[] skipped) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                try {
                    int n = Integer.parseInt(line.trim());
                    list.add(n);
                    // System.out.println(n);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid score: " + line);
                    skipped[0]++;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return list;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        double sum = 0.0;
        if (scores.size() == 0) {
            return 0.0;
        }
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
            double avg, int high, int low,
            String outputFile, int[] skipped, int countA, int countB, int countC, int countD, int countF) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Grade Analysis Report ===");
            writer.newLine();
            writer.write(String.format("Total scores processed: %d%n",
                    scores.size()));
            writer.write(String.format("Invalid lines skipped: %d%n",
                    skipped[0]));
            writer.newLine();
            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));
            writer.newLine();
            writer.write("Grade Distribution:");
            writer.newLine();
            writer.write(String.format("A (90-100): %d%n", countA));
            writer.write(String.format("B (80-89): %d%n", countB));
            writer.write(String.format("C (70-79): %d%n", countC));
            writer.write(String.format("D (60-69): %d%n", countD));
            writer.write(String.format("F (below 60): %d%n", countF));
            System.out.println("Report has been written to output.txt");
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }

    public static String getLetterGrade(int score) { 
        if (score < 60) {
            return "F";
        }
        else if (score <= 62) {
            return "D-";
        }
        else if (score < 68) {
            return "D";
        }
        else if (score < 70) {
            return "D+";
        }
        else if (score <= 72) {
            return "C-";
        }
        else if (score < 78) {
            return "C";
        }
        else if (score < 80) {
            return "C+";
        }
        else if (score <= 82) {
            return "B-";
        }
        else if (score < 88) {
            return "B";
        }
        else if (score < 90) {
            return "B+";
        }
        else if (score <= 92) {
            return "A-";
        }
        else if (score < 98) {
            return "A";
        }
        else {
            return "A+";
        }
    }
}