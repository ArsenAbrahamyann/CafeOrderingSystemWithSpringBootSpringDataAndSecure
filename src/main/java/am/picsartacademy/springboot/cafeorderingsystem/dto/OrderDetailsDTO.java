package am.picsartacademy.springboot.cafeorderingsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsDTO {
    private Long id;
    private Long orderId;
    private Long menuItemId;
    private Long quantity;
    private Double priceAtTime;
}
