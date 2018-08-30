package by.chmut.catalog.dao;

import by.chmut.catalog.bean.Catalog;
import by.chmut.catalog.bean.Categories;
import by.chmut.catalog.bean.News;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ResourceBundle;

class JAXBparser {

    private final String bundleName = "JAXB";

    private final String URL;

    {
        ResourceBundle rb = ResourceBundle.getBundle(bundleName);
        if (rb == null) {
            URL = "UNDEFINED";
            new DAOException ("Settings for JAXB is undefined - not load URL");
        } else {
            URL = rb.getString("url");
        }
    }




    Catalog load() throws DAOException{
        Catalog catalog = new Catalog();
        try {
            JAXBContext jc = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(new File(URL));
            setCategoryNameForAllNews(catalog);
        } catch (JAXBException e) {
            throw new DAOException("Error with read file catalog", e);
        }
        return catalog;
    }


    void save(Catalog catalog) throws DAOException {
        try {
            JAXBContext jc = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(catalog, new File(URL));
        } catch (JAXBException e) {
            throw new DAOException("Error with save file catalog", e);
        }
    }

    private void setCategoryNameForAllNews(Catalog catalog) {
        for (Categories categories:catalog.getCategories()) {
            for (News news:categories.getNews()) {
                news.setCategoryName(categories.getCategoryName());
            }
        }
    }
}
