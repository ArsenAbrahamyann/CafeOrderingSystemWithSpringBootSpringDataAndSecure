package am.picsartacademy.springboot.cafeorderingsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Column(name = "table_number")
    private Long tableNumber;
    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDate orderDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "order")
    private List<OrderDetails> items;

}
