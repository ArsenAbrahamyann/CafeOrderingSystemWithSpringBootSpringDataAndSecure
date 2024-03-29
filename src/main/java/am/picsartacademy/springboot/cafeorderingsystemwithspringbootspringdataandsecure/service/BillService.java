package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto.BillDTO;

public interface BillService {
    BillDTO generateBill(Long orderId);
}
