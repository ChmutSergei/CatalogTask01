package by.chmut.catalog.dao;

import by.chmut.catalog.Main;
import by.chmut.catalog.bean.Catalog;
import by.chmut.catalog.bean.Categories;
import by.chmut.catalog.bean.News;
import by.chmut.catalog.bean.criteria.Criteria;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;

import java.util.*;



public class CatalogDAOImpl implements CatalogDAO {


    private Catalog catalog;;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public <E> Set<News> find(Criteria<E> criteria) {

        Set<News> resultSearch = new HashSet<>();

        for (Map.Entry<E, Object> parameterOfCriteria : criteria.getCriteria().entrySet()) {

            if (parameterOfCriteria.getValue() != "") {

                resultSearch = findNewsOnParameterCriteria(parameterOfCriteria.getKey(), parameterOfCriteria.getValue());

            }
        }
        return resultSearch;
    }

    private <E> Set<News> findNewsOnParameterCriteria(E nameParameterForSearch, Object valueOfParameter) {

        Set<News> result = new HashSet<>();

        String fieldValue = "";

        for (News news : catalog.getAllNews()) {

            try {
                Field field = News.class.getDeclaredField(nameParameterForSearch.toString()); // Get private field from News class

                field.setAccessible(true); // Set Access for this field

                fieldValue = (String) field.get(news); // And take value from current Object ! news !

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (isFieldContainsValue(fieldValue, (String) valueOfParameter)) {

                result.add(news);

            }
        }
        return result;
    }


    private boolean isFieldContainsValue(String field, String value) {

        if (value.isEmpty()) {
            return false;
        }

        boolean isFieldContainValueLowerCase = field.contains(value.toLowerCase());

        boolean isFieldContainValueWithFirstCharUpperCase = field.contains(firstCharToUpperCase(value));

        boolean isFieldContainValueUpperCase = field.contains(value.toUpperCase());

        if (isFieldContainValueLowerCase || isFieldContainValueUpperCase || isFieldContainValueWithFirstCharUpperCase) {

            return true;
        }

        return false;
    }


    private String firstCharToUpperCase(String value) {

        value = value.toLowerCase();

        if (value.isEmpty()) {
            return "";
        }

        value = value.substring(0, 1).toUpperCase() + value.substring(1);

        return value;
    }

    @Override
    public Catalog load() throws DAOException {

        JAXBparser jaxbParser = new JAXBparser();

        catalog = jaxbParser.load();

        return catalog;
    }

    @Override
    public void save() throws DAOException {

        JAXBparser jaxbParser = new JAXBparser();

        jaxbParser.save(catalog);

    }

    @Override
    public void add(News news) {
        for (Categories category: catalog.getCategories()) {

            if (category.getCategoryName().equals(news.getCategoryName())) {

                category.add(news);

                return;
            }
        }
        Categories newCategory = new Categories();

        newCategory.setCategoryName(news.getCategoryName());

        newCategory.add(news);

        catalog.getCategories().add(newCategory);
    }


}


