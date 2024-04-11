package am.picsartacademy.springboot.cafeorderingsystem.controller;

import am.picsartacademy.springboot.cafeorderingsystem.dto.BillDTO;
import am.picsartacademy.springboot.cafeorderingsystem.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/{billId}")
    public ResponseEntity<BillDTO> generateBill(@PathVariable("billId") Long billId) {
        BillDTO bill = billService.generateBill(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
}
