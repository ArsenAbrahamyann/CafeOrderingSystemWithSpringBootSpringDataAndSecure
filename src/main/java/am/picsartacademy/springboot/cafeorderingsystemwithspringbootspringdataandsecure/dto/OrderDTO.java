package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private Long waiterId;
    private Long tableNumber;
    private List<OrderItem> items;
}
