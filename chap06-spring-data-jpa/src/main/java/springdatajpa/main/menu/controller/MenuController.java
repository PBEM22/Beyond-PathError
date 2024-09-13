package springdatajpa.main.menu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springdatajpa.main.menu.dto.CategoryDTO;
import springdatajpa.main.menu.dto.MenuDTO;
import springdatajpa.main.menu.service.MenuService;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
        MenuDTO resultMenu = menuService.findMenuByMenuCode(menuCode);
        model.addAttribute("menu", resultMenu);
        return "menu/detail";
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pargeable){

//        List<MenuDTO> menuList = menuService.findMenuList();
//        model.addAttribute("menuList", menuList);

        /* 페이징 처리 포함 */
        log.info("pageable : {}", pargeable);
        Page<MenuDTO> menuList = menuService.findMenuList(pargeable);

        return "menu/list";
    }

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer menuPrice, Model model){

        List<MenuDTO> byMenuPrice = menuService.findByMenuPrice(menuPrice);
        model.addAttribute("menuList", byMenuPrice);

        return "menu/searchResult";
    }

    @GetMapping("/regist")
    public void regisPage(){}

    @GetMapping("/category")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){

        return menuService.findAllCategory();
    }

    @PostMapping("/regist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO) {

        menuService.registMenu(menuDTO);
        return "redirect:/menu/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.modifyMenu(menuDTO);
        return "redirect:/menu/" + menuDTO.getMenuCode();
    }
}