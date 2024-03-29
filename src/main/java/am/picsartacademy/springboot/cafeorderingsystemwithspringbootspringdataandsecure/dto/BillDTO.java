package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDTO {
    private Long orderId;
    private double totalAmount;
}
