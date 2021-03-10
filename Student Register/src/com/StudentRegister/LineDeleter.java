package com.StudentRegister;

import java.io.*;
import java.util.Scanner;

public class LineDeleter {
    public static void LineDeleter1() {
        try {
            File oldFile = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ABR_List.txt");
            Scanner deleter = new Scanner(oldFile);
            String nonBlankData = "";
            while (deleter.hasNextLine()) {
                String currentLine = deleter.nextLine();
                if (!currentLine.isEmpty()) {
                    nonBlankData += currentLine + System.lineSeparator();
                }
            }
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ABR_List.txt"));
            writer.print(nonBlankData);
            writer.close();
        } catch (IOException exc1_1) {
            exc1_1.printStackTrace();
        }

    }

    public static void LineDeleter2() {
        try {
            File oldFile = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
            Scanner deleter = new Scanner(oldFile);
            String nonBlankData = "";
            while (deleter.hasNextLine()) {
                String currentLine = deleter.nextLine();
                if (!currentLine.isEmpty()) {
                    nonBlankData += currentLine + System.lineSeparator();
                }
            }
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt"));
            writer.print(nonBlankData);
            writer.close();
        } catch (IOException exc1_1) {
            exc1_1.printStackTrace();
        }

    }
}