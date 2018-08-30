package by.chmut.catalog.view;

import by.chmut.catalog.bean.News;

import java.util.Scanner;
import java.util.Set;

public class View {

    private static Set<News> result;

    public Set<News> getResult() {
        return result;
    }

    public void setResult(Set<News> result) {
        this.result = result;
    }

    public static String getRequest() {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        return request;
    }

    public static void showResult() {
        if (result != null) {
            for (News news : result) {
                System.out.println(news);
            }
        }
    }
}
