package am.picsartacademy.springboot.cafeorderingsystem.entities;

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
    @OneToOne(cascade = CascadeType.ALL)
    private Order order;

    @Column(name = "totalAmount")
    private double totalAmount;

}
