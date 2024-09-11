package com.example.associationmapping.section01.manytoone;

import org.springframework.transaction.annotation.Transactional;

public class MenuToOneService {

    private ManyToOneRepository manyToOneRepository;

    public MenuToOneService(ManyToOneRepository manyToOneRepository) {
        this.manyToOneRepository = manyToOneRepository;
    }

    public Menu findMenu(int menuCode){
        return manyToOneRepository.find(menuCode);
    }

    public String findCategoryNameByJpql(int menuCode){
        return manyToOneRepository.findCategoryName(menuCode);
    }

    @Transactional
    public void registMenu(MenuDTO newMenu){

        Menu menu = new Menu(
                newMenu.getMenuCode(),
                newMenu.getMenuName(),
                newMenu.getMenuPrice()
        );
    }
}
