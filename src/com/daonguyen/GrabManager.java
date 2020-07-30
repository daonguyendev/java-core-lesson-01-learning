package com.daonguyen;

import java.util.Scanner;

/**
 * Calculate average score
 * Author: Dao Nguyen
 * Date: 21/07/2020
 * Version: 1.0
 */
public class GrabManager {
    public static void main(String[] args) {
        // --- Input ---
        // type of car
        // number of KM
        // idle time of driver
        final String GRAB_CAR = "Grab Car", GRAB_SUV = "Grab Suv",
                GRAB_BLACK = "Grab Black";
        final float GRAB_CAR_FIRST_KM = 8000,
                GRAB_SUV_FIRST_KM = 9000,
                GRAB_BLACK_FIRST_KM = 10000;
        final float GRAB_CAR_PER_1_TO_19 = 7500,
                GRAB_SUV_PER_1_TO_19 = 8500,
                GRAB_BLACK_PER_1_TO_19 = 9500;
        final float GRAB_CAR_LARGER_THAN_19 = 7000,
                GRAB_SUV_LARGER_THAN_19 = 8000,
                GRAB_BLACK_LARGER_THAN_19 = 9000;
        String carType = "";
        float distance = 0, idleTime = 0, total = 0,
                firstKM = 0, perOneToNineteen = 0, largerThanNineteen = 0;
        Scanner scanner = new Scanner(System.in);

        // Step 2: Input
        System.out.print("Enter type of car: ");
        carType = scanner.nextLine();

        System.out.print("Enter your distance: ");
        distance = scanner.nextFloat();

        System.out.print("Enter your idle time: ");
        idleTime = scanner.nextFloat();

        // --- Handle ---

        // Step 3: Calculate total per km
        switch (carType) {
            case GRAB_CAR:
                firstKM = GRAB_CAR_FIRST_KM;
                perOneToNineteen = GRAB_CAR_PER_1_TO_19;
                largerThanNineteen = GRAB_CAR_LARGER_THAN_19;
                total = totalNeedToPay(distance, idleTime, firstKM, perOneToNineteen, largerThanNineteen);
                break;
            case GRAB_SUV:
                firstKM = GRAB_SUV_FIRST_KM;
                perOneToNineteen = GRAB_SUV_PER_1_TO_19;
                largerThanNineteen = GRAB_BLACK_PER_1_TO_19;
                total = totalNeedToPay(distance, idleTime, firstKM, perOneToNineteen, largerThanNineteen);
                break;
            case GRAB_BLACK:
                firstKM = GRAB_BLACK_FIRST_KM;
                perOneToNineteen = GRAB_SUV_LARGER_THAN_19;
                largerThanNineteen = GRAB_BLACK_LARGER_THAN_19;
                total = totalNeedToPay(distance, idleTime, firstKM, perOneToNineteen, largerThanNineteen);
                break;
        }

        // --- Output ---
        System.out.println("Total need to pay of " + carType
                + " are: " + total);
    }

    public static float totalNeedToPay(float distance,
                                       float idleTime,
                                       float firstKM,
                                       float perOneToNineteen,
                                       float largerThanNineteen) {
        float total = 0;
        if (distance == 1) {
            total = 1 * firstKM;
        } else if (distance > 1 && distance <= 19) {
            total = 1 * firstKM + perOneToNineteen * (distance - 1);
        } else {
            total = 1 * firstKM + perOneToNineteen * (19 - 1) + largerThanNineteen * (distance - 19);
        }

        if (idleTime >= 3) {
            total += idleTime * 2000;
        }

        return total;
    }
}
