package by.chmut.catalog.dao;


public class DAOException extends Exception {

    private static final long serialVersionUID = 6597631899994266436L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}

