package com.study.datajpa.repository;

import com.study.datajpa.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Order order){
        em.persist(order);
        return order.getId();
    }
}
