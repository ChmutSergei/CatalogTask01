package by.chmut.catalog.controller.command;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.controller.Command;

import java.util.HashSet;
import java.util.Set;

public class ErrorCommand implements Command {

    @Override

    public Set<News> execute(String request) {

        String error = "Incorrect command or no data in the command! Try again!";

        News news = new News(error,"","","","","");

        Set<News> result = new HashSet<>();

        result.add(news);

        return result;
    }
}
