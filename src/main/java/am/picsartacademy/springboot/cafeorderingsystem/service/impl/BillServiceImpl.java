package am.picsartacademy.springboot.cafeorderingsystem.service.impl;


import am.picsartacademy.springboot.cafeorderingsystem.dto.BillDTO;
import am.picsartacademy.springboot.cafeorderingsystem.entities.Bill;
import am.picsartacademy.springboot.cafeorderingsystem.repository.BillRepository;
import am.picsartacademy.springboot.cafeorderingsystem.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;


    @Override
    public BillDTO generateBill(Long orderId) {
        Bill bill = billRepository.getByOrderById(orderId).orElseThrow(
                () -> new IllegalArgumentException()
        );
      return   BillDTO.builder()
              .orderId(bill.getOrder().getId())
              .totalAmount(bill.getTotalAmount())
              .build();
    }
}
