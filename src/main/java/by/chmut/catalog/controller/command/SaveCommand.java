package by.chmut.catalog.controller.command;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.controller.Command;
import by.chmut.catalog.service.Service;

import java.util.Set;

public class SaveCommand implements Command {

    Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public Set<News> execute(String request) {

        service.save();

        return null;
    }
}
