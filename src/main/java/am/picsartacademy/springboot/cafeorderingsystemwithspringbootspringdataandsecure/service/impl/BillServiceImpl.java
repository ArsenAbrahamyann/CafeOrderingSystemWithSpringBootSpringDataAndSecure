package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.impl;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.BillDTO;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.MenuItem;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.Order;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.OrderItem;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.repository.OrderRepository;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final OrderRepository orderRepository;


    @Override
    public BillDTO generateBill(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        double totalAmount = 0.0;
        for (OrderItem orderItem : order.get().getItems()) {
            MenuItem menuItem = orderItem.getMenuItem();
            totalAmount += menuItem.getPrice() * orderItem.getQuantity();
        }
        BillDTO bill = new BillDTO();
        bill.setTotalAmount(totalAmount);
        return bill;
    }
}
