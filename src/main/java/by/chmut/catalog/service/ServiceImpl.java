package by.chmut.catalog.service;


import by.chmut.catalog.Main;
import by.chmut.catalog.bean.*;
import by.chmut.catalog.bean.criteria.Criteria;
import by.chmut.catalog.dao.CatalogDAO;
import by.chmut.catalog.dao.DAOException;
import by.chmut.catalog.service.validation.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ServiceImpl implements Service {

    private CatalogDAO catalogDAO;

    ServiceImpl() {
    }

    ServiceImpl(CatalogDAO catalogDAO) {
        this.catalogDAO = catalogDAO;
    }

    @Override
    public <E> Set<News> find(List<Criteria> allCriteriaToSearch) {


        Set<News> result = new HashSet<>();

        for (Criteria criteria : allCriteriaToSearch) {

            if (Validator.isNotEmpty(criteria)) {

                result.addAll(catalogDAO.find(criteria));

            }
        }

        return result;
    }

    @Override
    public void addNews(News news) {

        catalogDAO.add(news);

    }

    @Override
    public void load() {
        try {
            catalogDAO.load();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            catalogDAO.save();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
