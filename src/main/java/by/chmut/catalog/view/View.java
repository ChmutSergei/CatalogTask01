package by.chmut.catalog.view;

import java.util.Scanner;


public class View {

    public static String getRequest() {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        return request;
    }

    public static void showResult(String[] response) {
        for (String row : response) {
            System.out.println(row);
        }
    }
}
