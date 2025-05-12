/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Y2S1Practical1;

/**
 *
 * @author Ng Shen Zhi
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {

    private ArrayList<Integer> scores;

    public Q1() {
        scores = new ArrayList<>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public void displayScores() {
        System.out.println("Test Scores: " + scores);
    }

    public int findLowestScore() {
        int lowest = scores.get(0);
        for (int score : scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        return lowest;
    }

    public int findHighestScore() {
        int highest = scores.get(0);
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    public double computeAverageScore() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    public static void main(String[] args) {
        Q1 manager = new Q1();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add test score");
            System.out.println("2. Display all test scores");
            System.out.println("3. Display lowest score");
            System.out.println("4. Display highest score");
            System.out.println("5. Display average score");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the test score: ");
                    int score = scanner.nextInt();
                    manager.addScore(score);
                    break;
                case 2:
                    manager.displayScores();
                    break;
                case 3:
                    if (!manager.scores.isEmpty()) {
                        System.out.println("Lowest score: " + manager.findLowestScore());
                    } else {
                        System.out.println("No scores available.");
                    }
                    break;
                case 4:
                    if (!manager.scores.isEmpty()) {
                        System.out.println("Highest score: " + manager.findHighestScore());
                    } else {
                        System.out.println("No scores available.");
                    }
                    break;
                case 5:
                    if (!manager.scores.isEmpty()) {
                        System.out.println("Average score: " + manager.computeAverageScore());
                    } else {
                        System.out.println("No scores available.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
