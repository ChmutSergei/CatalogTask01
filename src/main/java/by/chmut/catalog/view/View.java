package by.chmut.catalog.view;

import by.chmut.catalog.bean.News;

import java.util.Scanner;
import java.util.Set;

public class View {

    public static String getRequest() {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        return request;
    }

    public static void showResult(Set<News> result) {
        if (result != null) {
            for (News news : result) {
                System.out.println(news);
            }
        }
    }
}
