package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.OrderDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.OrderItemDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(OrderDTO order);

    OrderDTO viewOrder(Long id);

    void cancelOrder(Long id);

    OrderDTO modifyOrder(Long id, List<OrderItemDTO> items);

    List<OrderDTO> viewPastOrders(String startDate, String endDate);
}
