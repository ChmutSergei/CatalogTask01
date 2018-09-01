package by.chmut.catalog.controller.command;

import by.chmut.catalog.controller.Command;
import by.chmut.catalog.dao.DAOException;
import by.chmut.catalog.dao.DAOFactory;

public class ReadCommand implements Command {

    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public String[] execute(String request) {
        try {
            daoFactory.getCatalogDAO().load();
        } catch (DAOException e) {
            System.out.println("Error with read news");
        }
        String[] response = {"Catalog was load"};

        return response;
    }
}
