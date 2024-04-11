package am.picsartacademy.springboot.cafeorderingsystem.service.impl;

import am.picsartacademy.springboot.cafeorderingsystem.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BillServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private BillServiceImpl billService;

    @Test
    void generateBill() {
    }
}