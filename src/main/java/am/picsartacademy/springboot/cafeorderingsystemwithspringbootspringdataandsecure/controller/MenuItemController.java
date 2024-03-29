package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.controller;

import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.MenuItemDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/menu")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;


    @GetMapping
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItems() {
        List<MenuItemDTO> allMenuItems = menuItemService.getAllMenuItem();
        return new ResponseEntity<>(allMenuItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addMenuItem(@Valid @RequestBody MenuItemDTO menuItem) {
        menuItemService.addMenuItem(menuItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Void> updateMenuItem(@PathVariable("itemId") Long itemId, @Valid @RequestBody MenuItemDTO menuItem) {
        menuItemService.updateMenuItem(itemId,menuItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable("itemId") Long itemId) {
        menuItemService.removeMenuItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
