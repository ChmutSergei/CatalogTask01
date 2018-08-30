package by.chmut.catalog.service.validation;

import by.chmut.catalog.bean.criteria.Criteria;

import java.util.Map;

public class Validator {

    public static <E> boolean isNotEmpty(Criteria<E> criteria) {

        for (Map.Entry entry: criteria.getCriteria().entrySet()) {

            if (entry.getValue() != "") {

                return true;
            }
        }
        return false;
    }
}
