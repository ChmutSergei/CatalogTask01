package by.chmut.catalog.controller.command;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.bean.criteria.Criteria;
import by.chmut.catalog.bean.criteria.SearchCriteria;
import by.chmut.catalog.controller.Command;
import by.chmut.catalog.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.chmut.catalog.bean.criteria.SearchCriteria.Category.CATEGORYNAME;
import static by.chmut.catalog.bean.criteria.SearchCriteria.News.*;
import static by.chmut.catalog.bean.criteria.SearchCriteria.Subcategory.SUBCATEGORYNAME;


public class SearchCommand implements Command {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private Criteria<SearchCriteria.Category> categoryCriteria = new Criteria<>(SearchCriteria.Category.class);
    private Criteria<SearchCriteria.Subcategory> subcategoryCriteria = new Criteria<>(SearchCriteria.Subcategory.class);
    private Criteria<SearchCriteria.News> newsCriteria = new Criteria<>(SearchCriteria.News.class);

    @Override
    public Set<News> execute(String request) {

        List<Criteria> allCriteria = getParamsCriteria(request);

        Set<News> result = serviceFactory.getService().find(allCriteria);

        return result;
    }


    private List<Criteria> getParamsCriteria(String request) {

        List<Criteria> listOfCriteriaToSearch = new ArrayList<>();

        Matcher reqMatcher = Pattern.compile("(cat|sub|name|prov|date|info) ?= ?(\\w+)").matcher(request);

        while (reqMatcher.find()) {

            addCriteria(reqMatcher.group());

        }
        listOfCriteriaToSearch.add(categoryCriteria);

        listOfCriteriaToSearch.add(subcategoryCriteria);

        listOfCriteriaToSearch.add(newsCriteria);

        return listOfCriteriaToSearch;
    }


    private void addCriteria(String parameters) {
        String[] params = parameters.split("=", 2);

        String paramOnSearch = params[0].trim();

        String value = params[1].trim();

        switch (paramOnSearch) {
            case "cat":
                categoryCriteria.add(CATEGORYNAME, value);
                break;
            case "sub":
                subcategoryCriteria.add(SUBCATEGORYNAME, value);
                break;
            case "name":
                newsCriteria.add(NEWSNAME, value);
                break;
            case "prov":
                newsCriteria.add(PROVIDER, value);
                break;
            case "date":
                newsCriteria.add(DATE, value);
                break;
            case "info":
                newsCriteria.add(NEWS, value);
                break;
        }
    }


}
