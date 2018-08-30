package by.chmut.catalog.controller.command;

import by.chmut.catalog.controller.Command;
import by.chmut.catalog.dao.DAOException;
import by.chmut.catalog.dao.DAOFactory;

public class SaveCommand implements Command {

    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public void execute(String request) {
        try {
            daoFactory.getCatalogDAO().save();
        } catch (DAOException e) {
            System.out.println("Error with save news");
        }
    }
}
