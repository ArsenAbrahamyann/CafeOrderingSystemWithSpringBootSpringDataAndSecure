package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.MenuItemDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDTO> getAllMenuItem();

    void updateMenuItem(Long id, MenuItemDTO menuItemDTO);

    void addMenuItem(MenuItemDTO menuItemDTO);

    void removeMenuItem(Long id);
}
