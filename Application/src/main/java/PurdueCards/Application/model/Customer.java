package PurdueCards.Application.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name="customer")
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
    /*@OneToMany(mappedBy = "seller_id")
    private Set<Purchases> purchases;
*/
    public Customer(String name, Integer purchaseCount, Integer sellCount) {
        this.name = name;
        this.purchaseCount = purchaseCount;
        this.sellCount = sellCount;
    }


}
