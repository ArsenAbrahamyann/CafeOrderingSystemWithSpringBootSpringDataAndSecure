package am.picsartacademy.springboot.cafeorderingsystem.dto;


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
    private Long tableNumber;
    private List<OrderDetailsDTO> items;
}
