package com.example.associationmapping.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BiDirectionRepository {

    @PersistenceContext
    private EntityManager em;

    public Menu findMenu(int menuCode){
        return em.find(Menu.class, menuCode);
    }

    public Category findCategory(int categoryCode) {

        return em.find(Category.class, categoryCode);
    }
}
