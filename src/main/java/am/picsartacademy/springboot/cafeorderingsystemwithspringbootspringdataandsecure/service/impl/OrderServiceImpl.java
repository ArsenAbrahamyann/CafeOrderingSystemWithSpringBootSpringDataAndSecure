package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.impl;

import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.OrderDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.OrderItemDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.Order;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.OrderItem;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.repository.OrderRepository;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(OrderDTO order) {
        Order order1 = null;
        Optional<Order> optional = orderRepository.findById(order.getId());
        if (optional.isPresent()) {
            order1 = optional.get();
        }
        return orderRepository.save(order1);

    }

    @Override
    public OrderDTO viewOrder(Long id) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            order = optional.get();
        }
       return OrderDTO.builder()
                .id(order.getId())
                .items(order.getItems())
                .tableNumber(order.getTableNumber())
                .waiterId(order.getWaiterId())
                .build();

    }

    @Override
    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDTO modifyOrder(Long id, List<OrderItemDTO> items) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            order = optional.get();
        }else {
            return null;
        }
        for (OrderItemDTO itemDTO : items) {
            for (OrderItem orderItem : order.getItems()) {
                if (orderItem.getId().equals(itemDTO.getId())) {
                    orderItem.setQuantity(itemDTO.getQuantity());
                    break;
                }
            }
        }
        orderRepository.save(order);
        return viewOrder(id);
    }

    @Override
    public List<OrderDTO> viewPastOrders(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            throw new IllegalArgumentException("Both startDate and endDate parameters are required.");
        }

        try {
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);

            List<Order> orders = orderRepository.findByOrderDateBetween(start, end);
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for (Order order : orders) {
                orderDTOList.add(viewOrder(order.getId()));
            }
            return orderDTOList;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Date format must be yyyy-MM-dd.");
        }
    }

}
