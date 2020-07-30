package com.daonguyen;

import java.util.Scanner;

/**
 * Calculate average score
 * Author: Dao Nguyen
 * Date: 21/07/2020
 * Version: 1.0
 */
public class StudentManager {

    public static void main(String[] args) {
        // --- Input ---
        // Step 1: Declare variables
        String fullName = "", result = "";
        float math = 0, physic = 0, chemistry = 0, average = 0;
        final String EXCELLENT = "Excellent", GOOD = "Good",
                AVERAGE = "Average", WEAK = "Weak";
        final float excellentScope = 8.5f,
                goodScope = 6.5f, averageScope = 5f;
        Scanner scanner = new Scanner(System.in);

        // Step 2: Input
        System.out.print("Enter your full name: ");
        fullName = scanner.nextLine();

        System.out.print("Enter your math score: ");
        math = scanner.nextFloat();

        System.out.print("Enter your physic score: ");
        physic = scanner.nextFloat();

        System.out.print("Enter your chemistry score: ");
        chemistry = scanner.nextFloat();

        // --- Handle ---
        // Step 3: Calculate average score
        average = (math + physic + chemistry) / 3;

        // Step 4: Rating
        if (average >= excellentScope) {
            result = EXCELLENT;
        } else if (average >= goodScope) {
            result = GOOD;
        } else if (average >= averageScope) {
            result = AVERAGE;
        } else {
            result = WEAK;
        }

        // --- Output ---
        System.out.println("Rating of " + fullName
                + " is: " + result);
    }
}
