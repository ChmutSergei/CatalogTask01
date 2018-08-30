package by.chmut.catalog.dao;


import by.chmut.catalog.bean.Catalog;
import by.chmut.catalog.bean.News;
import by.chmut.catalog.bean.criteria.Criteria;

import java.util.Set;

public interface CatalogDAO {

    <E> Set<News> find(Criteria<E> criteria);

    Catalog load() throws DAOException;

    void save () throws DAOException;

    void add (News news);

}
