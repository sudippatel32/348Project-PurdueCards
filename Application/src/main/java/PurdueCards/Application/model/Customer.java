package PurdueCards.Application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="customer", indexes = {@Index(columnList = "name")})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer customerID;

    @Column(name="name")
    private String name;

    @Column(name="times_purchased")
    private Integer purchaseCount;

    @Column(name="times_sold")
    private Integer sellCount;

    public Customer(String name, Integer purchaseCount, Integer sellCount) {
        this.name = name;
        this.purchaseCount = purchaseCount;
        this.sellCount = sellCount;
    }


}
