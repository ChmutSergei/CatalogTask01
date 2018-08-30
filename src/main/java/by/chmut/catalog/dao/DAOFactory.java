package by.chmut.catalog.dao;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final CatalogDAO CatalogDAO = new CatalogDAOImpl();

    public CatalogDAO getCatalogDAO() {
        return CatalogDAO;
    }


    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
