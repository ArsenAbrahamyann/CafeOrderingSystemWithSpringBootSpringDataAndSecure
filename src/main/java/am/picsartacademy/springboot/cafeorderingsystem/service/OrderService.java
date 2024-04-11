package am.picsartacademy.springboot.cafeorderingsystem.service;


import am.picsartacademy.springboot.cafeorderingsystem.dto.OrderDTO;
import am.picsartacademy.springboot.cafeorderingsystem.dto.OrderDetailsDTO;
import am.picsartacademy.springboot.cafeorderingsystem.entities.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(OrderDTO order);

    OrderDTO viewOrder(Long id);

    void cancelOrder(Long id);

    OrderDTO modifyOrder(Long id, List<OrderDetailsDTO> items);

    List<OrderDTO> viewPastOrders(String startDate, String endDate);
}
