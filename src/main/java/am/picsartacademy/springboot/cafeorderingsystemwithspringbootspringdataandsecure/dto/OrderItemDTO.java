package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.dto;


import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.MenuItem;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDTO {
    private Long id;
    private Order order;
    private MenuItem menuItem;
    private Long quantity;
    private Double priceAtTime;
}
