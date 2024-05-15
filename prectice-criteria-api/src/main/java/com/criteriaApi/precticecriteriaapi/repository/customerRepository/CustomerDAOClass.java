package com.criteriaApi.precticecriteriaapi.repository.customerRepository;

import com.criteriaApi.precticecriteriaapi.model.CustomerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAOClass {
    @Autowired
    EntityManager entityManager;

    public List<CustomerDTOClass> searchCustomer(CustomerSearchProperties searchProperties) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);
            Root<CustomerClass> customerClassRoot = criteriaQuery.from(CustomerClass.class);

            Predicate predicate = criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            if (searchProperties.getCustomerName() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(customerClassRoot.get("customerName"), searchProperties.getCustomerName()+"%"));
            }
            if (searchProperties.getCustomerLowerTotalPurchase() != null && searchProperties.getCustomerUpperTotalPurchase() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.between(customerClassRoot.get("customerTotalPurchase"), searchProperties.getCustomerLowerTotalPurchase(), searchProperties.getCustomerUpperTotalPurchase()));
            }
            if (searchProperties.getCustomerEmployeeType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(customerClassRoot.get("customerEmployeeStatus"), searchProperties.getCustomerEmployeeType()));
            }
            criteriaQuery.where(predicate);
            return dtoConverter(entityManager.createQuery(criteriaQuery).getResultList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //        List<CustomerClass> customerClassList = new ArrayList<>();
//        if(searchProperties.getCustomerName()!=null && ((searchProperties.getCustomerLowerTotalPurchase()!=null&&searchProperties.getCustomerUpperTotalPurchase()!=null)&searchProperties.getCustomerEmployeeType()!=null)){
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);
//            Root<CustomerClass> customerRoot = criteriaQuery.from(CustomerClass.class);
//
//            Predicate customerName = criteriaBuilder.equal(customerRoot.get("customerName"), searchProperties.getCustomerName());
//            Predicate betweenTotalPurchase = criteriaBuilder.between(customerRoot.get("customerTotalPurchase"), searchProperties.getCustomerLowerTotalPurchase(), searchProperties.getCustomerUpperTotalPurchase());
//            Predicate customerEmployeeType = criteriaBuilder.equal(customerRoot.get("customerEmployeeStatus"), searchProperties.getCustomerEmployeeType());
//            Predicate finalQuery = criteriaBuilder.and(customerName, betweenTotalPurchase, customerEmployeeType);
//
//            criteriaQuery.where(finalQuery);
//
//             customerClassList = entityManager.createQuery(criteriaQuery).getResultList();
//        } else if (searchProperties.getCustomerName()!=null && (searchProperties.getCustomerLowerTotalPurchase()!=null && searchProperties.getCustomerUpperTotalPurchase()!=null) && searchProperties.getCustomerEmployeeType()==null) {
//            customerClassList = findByCustomerNameAndBetweenCustomerTotalPurchase(searchProperties.getCustomerName(), searchProperties.getCustomerLowerTotalPurchase(), searchProperties.getCustomerUpperTotalPurchase());
//        } else if (searchProperties.getCustomerName()!=null && searchProperties.getCustomerEmployeeType()!=null && (searchProperties.getCustomerLowerTotalPurchase()==null && searchProperties.getCustomerUpperTotalPurchase()==null)) {
//            customerClassList = findByCustomerNameAndCustomerEmployeeType(searchProperties.getCustomerName(), searchProperties.getCustomerEmployeeType());
//        } else if (searchProperties.getCustomerName()==null && (searchProperties.getCustomerLowerTotalPurchase()!=null && searchProperties.getCustomerUpperTotalPurchase()!=null) && searchProperties.getCustomerEmployeeType()!=null) {
//            customerClassList = findBetweenStartTotalPurchaseAndEndTotalPurchaseAndCustomerEmployeeType(searchProperties.getCustomerLowerTotalPurchase(), searchProperties.getCustomerUpperTotalPurchase(), searchProperties.getCustomerEmployeeType());
//        } else if (searchProperties.getCustomerName()!=null && ((searchProperties.getCustomerLowerTotalPurchase()==null && searchProperties.getCustomerUpperTotalPurchase()==null) && searchProperties.getCustomerEmployeeType()==null)) {
//            customerClassList = findCustomerByName(searchProperties.getCustomerName());
//        } else if(searchProperties.getCustomerName()==null && ((searchProperties.getCustomerLowerTotalPurchase()!=null && searchProperties.getCustomerUpperTotalPurchase()!=null) && searchProperties.getCustomerEmployeeType()==null)) {
//            customerClassList = findCustomerByTotalPurchaseRange(searchProperties.getCustomerLowerTotalPurchase(), searchProperties.getCustomerUpperTotalPurchase());
//        } else if (searchProperties.getCustomerName()==null && ((searchProperties.getCustomerLowerTotalPurchase()==null && searchProperties.getCustomerUpperTotalPurchase()==null) && searchProperties.getCustomerEmployeeType()!=null)) {
//            customerClassList = findCustomerByEmployeeType(searchProperties.getCustomerEmployeeType());
//        }
    }

    private List<CustomerClass> findCustomerByName(String name) {
        return searchCustomerName(name);
    }

    private List<CustomerClass> findCustomerByEmployeeType(String employeeType) {

        return searchByCustomerEmployeeType(employeeType);
    }

    private List<CustomerClass> findCustomerByTotalPurchaseRange(int startValue, int endValue) {
        return searchBetweenCustomerTotalPurchase(startValue, endValue);
    }

    private List<CustomerClass> findByCustomerNameAndBetweenCustomerTotalPurchase(String name, int startTotalPurchase, int endTotalPurchase) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);
        Root<CustomerClass> customerClassRoot = criteriaQuery.from(CustomerClass.class);

        Predicate customerNamePredicate = criteriaBuilder.equal(customerClassRoot.get("customerName"), name);
        Predicate customerBetweenPredicate = criteriaBuilder.between(customerClassRoot.get("customerTotalPurchase"), startTotalPurchase, endTotalPurchase);
        Predicate finalQuery = criteriaBuilder.and(customerNamePredicate, customerBetweenPredicate);

        criteriaQuery.where(finalQuery);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private List<CustomerClass> findByCustomerNameAndCustomerEmployeeType(String customerName, String customerEmployeeType) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);
        Root<CustomerClass> rootCustomer = criteriaQuery.from(CustomerClass.class);

        Predicate customerNamePredicate = criteriaBuilder.equal(rootCustomer.get("customerName"), customerName);
        Predicate customerEmployeeTypePredicate = criteriaBuilder.equal(rootCustomer.get("customerEmployeeStatus"), customerEmployeeType);
        Predicate finalQuery = criteriaBuilder.and(customerNamePredicate, customerEmployeeTypePredicate);

        criteriaQuery.where(finalQuery);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private List<CustomerClass> findBetweenStartTotalPurchaseAndEndTotalPurchaseAndCustomerEmployeeType(int startTotalPurchase, int endTotalPurchase, String employeeType) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);
        Root<CustomerClass> rootCustomer = criteriaQuery.from(CustomerClass.class);

        Predicate customerBetweenPredicate = criteriaBuilder.between(rootCustomer.get("customerTotalPurchase"), startTotalPurchase, endTotalPurchase);
        Predicate customerEmployeeType = criteriaBuilder.equal(rootCustomer.get("customerEmployeeStatus"), employeeType);
        Predicate finalQuery = criteriaBuilder.and(customerBetweenPredicate, customerEmployeeType);

        criteriaQuery.where(finalQuery);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private List<CustomerClass> searchCustomerName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);

        Root<CustomerClass> customerClassRoot = criteriaQuery.from(CustomerClass.class);
        criteriaQuery.select(customerClassRoot);
        Predicate namePredicate = criteriaBuilder.equal(customerClassRoot.get("customerName"), name);

        criteriaQuery.where(namePredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private List<CustomerClass> searchByCustomerEmployeeType(String type) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);

        Root<CustomerClass> customerClassRoot = criteriaQuery.from(CustomerClass.class);
        criteriaQuery.select(customerClassRoot);
        Predicate namePredicate = criteriaBuilder.equal(customerClassRoot.get("customerEmployeeStatus"), type);

        criteriaQuery.where(namePredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private List<CustomerClass> searchBetweenCustomerTotalPurchase(int starPurchase, int endPurchase) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerClass> criteriaQuery = criteriaBuilder.createQuery(CustomerClass.class);
        Root<CustomerClass> rootCustomer = criteriaQuery.from(CustomerClass.class);
        criteriaQuery.select(rootCustomer);
        Predicate betweenTotalPurchase = criteriaBuilder.between(rootCustomer.get("customerTotalPurchase"), starPurchase, endPurchase);
        criteriaQuery.where(betweenTotalPurchase);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }


    private List<CustomerDTOClass> dtoConverter(List<CustomerClass> customers) {
        List<CustomerDTOClass> customerDTOClassList = new ArrayList<>();
        for (CustomerClass c : customers) {
            CustomerDTOClass customerDTO = new CustomerDTOClass();
            customerDTO.setCustomerId(c.getCustomerId());
            customerDTO.setCustomerName(c.getCustomerName());
            customerDTO.setEmployeeType(c.getCustomerEmployeeStatus());
            customerDTOClassList.add(customerDTO);
        }
        return customerDTOClassList;
    }
}
