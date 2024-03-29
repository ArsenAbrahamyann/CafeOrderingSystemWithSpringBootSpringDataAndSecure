package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.controller;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.OrderDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.OrderItemDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.Order;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String, Long>> placeOrder(@Valid @RequestBody OrderDTO order) {
        Order order1 = orderService.placeOrder(order);
        return new ResponseEntity<>(Map.of("id", order1.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> viewOrder(@PathVariable("orderId") Long orderId) {
        OrderDTO order = orderService.viewOrder(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> modifyOrder(@PathVariable("orderId") Long orderId, @Valid @RequestBody List<OrderItemDTO> items) {
        try {
            OrderDTO modifiedOrder = orderService.modifyOrder(orderId, items);
            if (modifiedOrder != null) {
                return new ResponseEntity<>(modifiedOrder, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Order with ID " + orderId + " not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing the request: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/view")
    public ResponseEntity<List<OrderDTO>> viewPastOrders(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<OrderDTO> orderHistory = orderService.viewPastOrders(startDate, endDate);
        return new ResponseEntity<>(orderHistory, HttpStatus.OK);
    }
}
