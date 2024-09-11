package com.example.jpql.section07.subquary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class SubQuaryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Menu> selectWithSubQuary(String categoryName){
        String jpal = "SELECT m FROM Section07Menu m WHERE m.categoryCode = (" +
                "SELECT c.categoryCode FROM"
    }
}
