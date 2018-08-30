package by.chmut.catalog.service;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final Service service = new ServiceImpl();

    public Service getService() {
        return service;
    }

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
