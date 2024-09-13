package springdatajpa.main.menu.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import springdatajpa.main.menu.entity.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    /* 파라미터로 전달 받은 가격을 초과하는 메뉴 목록 조회 */
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    /* 파라미터로 전달 받은 가격을 초과하는 메뉴 목록 조회 + 가격순 조회 */
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);

    /* 파라미터로 전달 받은 가격을 초과하는 메뉴 목록 조회 + 전달 받은 정렬 기준 */
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);

}
