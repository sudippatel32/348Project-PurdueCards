package PurdueCards.Application.model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer customerID;

    @Column(name="name")
    private String name;

    @Column(name="purchaseCount")
    private Integer purchaseCount;

    @Column(name="sellCount")
    private Integer sellCount;

    public Customer(String name, Integer purchaseCount, Integer sellCount) {
        this.name = name;
        this.purchaseCount = purchaseCount;
        this.sellCount = sellCount;
    }
}
