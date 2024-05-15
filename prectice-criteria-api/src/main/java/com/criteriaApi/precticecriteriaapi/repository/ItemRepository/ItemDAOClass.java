package com.criteriaApi.precticecriteriaapi.repository.ItemRepository;

import com.criteriaApi.precticecriteriaapi.model.CustomerClass;
import com.criteriaApi.precticecriteriaapi.model.ItemClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class ItemDAOClass implements ICusItemRepo{

    @Autowired
    EntityManager entityManager;

    @Override
    public Integer expenseItem() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<ItemClass> root = criteriaQuery.from(ItemClass.class);
        criteriaQuery.select(criteriaBuilder.max(root.get("itemPrice")));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

//    @Override
//    public List<ItemClass> greaterPriceItem(int price) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ItemClass> criteriaQuery = criteriaBuilder.createQuery(ItemClass.class);
//        Root<ItemClass> root = criteriaQuery.from(ItemClass.class);
//        Predicate priceGraterThan = criteriaBuilder.greaterThan(root.get("itemPrice"), price);
//        criteriaQuery.where(priceGraterThan);
//        TypedQuery<ItemClass> typedQuery = entityManager.createQuery(criteriaQuery);
//        List<ItemClass> itemList = typedQuery.getResultList();
//        return itemList;
//    }
}
