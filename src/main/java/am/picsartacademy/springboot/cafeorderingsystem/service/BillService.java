package am.picsartacademy.springboot.cafeorderingsystem.service;


import am.picsartacademy.springboot.cafeorderingsystem.dto.BillDTO;

public interface BillService {
    BillDTO generateBill(Long orderId);
}
