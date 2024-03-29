package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @NotNull
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "totalAmount")
    private double totalAmount;

}
