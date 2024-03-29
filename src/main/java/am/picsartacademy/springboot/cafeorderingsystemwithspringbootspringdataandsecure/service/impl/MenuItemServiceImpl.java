package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.impl;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.MenuItemDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.MenuItem;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.repository.MenuItemRepository;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItemDTO> getAllMenuItem() {
        List<MenuItem> all = menuItemRepository.findAll();
        List<MenuItemDTO> menuItemDTOS = new ArrayList<>();
        for (MenuItem menuItem: all) {
            menuItemDTOS.add(
                    MenuItemDTO.builder()
                            .id(menuItem.getId())
                            .price(menuItem.getPrice())
                            .category(menuItem.getCategory())
                            .description(menuItem.getDescription())
                            .name(menuItem.getName())
                            .build()
            );
        }
        return menuItemDTOS;
    }

    @Override
    public void updateMenuItem(Long id, MenuItemDTO menuItem) {
        MenuItem menu = null;
        Optional<MenuItem> optional = menuItemRepository.findById(id);
        if (optional.isPresent()){
            menu = optional.get();
        }
        menu.setCategory(menuItem.getCategory());
        menu.setDescription(menuItem.getDescription());
        menu.setName(menuItem.getName());
        menu.setPrice(menuItem.getPrice());

        menuItemRepository.save(menu);
    }

    @Override
    public void addMenuItem(MenuItemDTO menuItem) {
        MenuItem menu = null;
        Optional<MenuItem> optional = menuItemRepository.findById(menuItem.getId());
        if (optional.isPresent()){
            menu = optional.get();
        }
        menuItemRepository.save(menu);
    }


    @Override
    public void removeMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}
