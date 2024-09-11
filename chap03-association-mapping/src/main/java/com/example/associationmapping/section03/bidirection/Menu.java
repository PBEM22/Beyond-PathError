package com.example.associationmapping.section03.bidirection;

import com.example.associationmapping.section01.manytoone.Category;
import jakarta.persistence.*;

@Entity(name = "section03Menu")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;

    private String menuName;

    private int menuPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoryCode")
    private com.example.associationmapping.section01.manytoone.Category category;

    private String orderableStatus;

    protected Menu() {}

    public int getMenuCode() {








        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }
}