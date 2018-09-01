package by.chmut.catalog.service;

import by.chmut.catalog.bean.*;
import by.chmut.catalog.bean.criteria.Criteria;
import by.chmut.catalog.dao.DAOFactory;
import by.chmut.catalog.service.validation.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ServiceImpl implements Service {

    private static final DAOFactory factory = DAOFactory.getInstance();

    @Override
    public <E> Set<News> find(List<Criteria> allCriteriaToSearch) {

        Set<News> result = new HashSet<>();

        for (Criteria criteria: allCriteriaToSearch) {

            if (Validator.isNotEmpty(criteria)) {

                result.addAll(factory.getCatalogDAO().find(criteria));

            }
        }

        return result;
    }

    @Override
    public void addNews(News news) {

        factory.getCatalogDAO().add(news);

    }
}
