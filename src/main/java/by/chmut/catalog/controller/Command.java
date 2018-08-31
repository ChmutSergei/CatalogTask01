package by.chmut.catalog.controller;

import by.chmut.catalog.bean.News;

import java.util.Set;

public interface Command {

    Set<News> execute(String request);

}