package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty()) {
                groceryList.remove(trimmedItem);
            }
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        sortList();
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    private static void sortList() {
        Collections.sort(groceryList);
    }

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0: Uygulamayı durdur");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman çıkar");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                addItems(input);
            } else if (choice == 2) {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                removeItems(input);
            }
        }
        scanner.close();
    }
}
