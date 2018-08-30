package by.chmut.catalog.controller.command;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.service.ServiceFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCommand implements by.chmut.catalog.controller.Command {

    private String[] value = new String[6];

    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override

    public void execute(String request) {

        Matcher reqMatcher = Pattern.compile("(cat|sub|name|prov|date|info) ?= ?([\\w.]+)").matcher(request);

        while (reqMatcher.find()) {

            setParametrFromRequest(reqMatcher.group());

        }

        News news = makeNewsFromData(value);

        serviceFactory.getService().addNews(news);
    }

    private void setParametrFromRequest(String parameters) {

        String[] params = parameters.split("=", 2);

        String fieldName = params[0].trim();

        String fieldValue = params[1].trim();

        switch (fieldName) {
            case "cat":
                value[0] = fieldValue;
                break;
            case "sub":
                value[1] = fieldValue;
                break;
            case "name":
                value[2] = fieldValue;
                break;
            case "prov":
                value[3] = fieldValue;
                break;
            case "date":
                value[4] = fieldValue;
                break;
            case "info":
                value[5] = fieldValue;
                break;
        }
    }

    private News makeNewsFromData(String[] data) {

        News news = new News(data[0],data[1],data[2],data[3],data[4],data[5]);

        return news;
    }
}
