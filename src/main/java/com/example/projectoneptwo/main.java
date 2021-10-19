package com.example.projectoneptwo;

import java.io.InputStream;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Which article would you like to see the last editors of? : ");
        String input = reader.nextLine();

        if (input.isEmpty()) {
            System.err.println("There is no search input: error code 1");
            System.exit(0);
        }

        try {
            InputStream jsonData = wikipediaCollect.buildConnection(input);
            wikipediaParser.parse(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}