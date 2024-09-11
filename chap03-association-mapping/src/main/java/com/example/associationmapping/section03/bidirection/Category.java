package com.example.associationmapping.section03.bidirection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "Section03Category")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;

    private String categoryName;

    private Integer refCategoryCode;

    protected Category() {}

    /* 양방향 연관 관계를 맺을 경우 FK를 가진 엔터티를 진짜,
    * FK를 가지지 않은 엔터티를 가짜 연관 관계라고 본다.
    * 진짜 연관 관계는 똑같이 처리하지만 가짜 연관 관계는
    * mappedBy 송성에 진짜 연관 관계 필드명을 넣어서 설정한다.*/
    @OneToMany(mappedBy = "category")
    private List<Menu> menuList;

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}