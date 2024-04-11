package am.picsartacademy.springboot.cafeorderingsystem.service;


import am.picsartacademy.springboot.cafeorderingsystem.dto.MenuItemDTO;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDTO> getAllMenuItem();

    void updateMenuItem(Long id, MenuItemDTO menuItemDTO);

    void addMenuItem(MenuItemDTO menuItemDTO);

    void removeMenuItem(Long id);
}
