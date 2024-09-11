package com.example.associationmapping.section03.bidirection;

import org.springframework.stereotype.Service;

@Service
public class BiDirectionService {

    private BiDirectionRepository biDirectionRepository;

    private BiDirectionService(BiDirectionRepository biDirectionRepository){
        this.biDirectionRepository = biDirectionRepository;
    }

    public Menu findMenu(int menuCode){
        return biDirectionRepository.findMenu(menuCode);
    }

    public Category findCategory(int categoryCode){
        Category category = biDirectionRepository.findCategory(categoryCode);
        System.out.println(category.getMenuList());
        System.out.println(category.getMenuList().get(0).getCategory());
        return category;
    }
}
