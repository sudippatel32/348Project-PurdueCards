package PurdueCards.Application.model;

import javax.persistence.*;

@Entity
@Table(name="sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "seller_ID")
    private int seller_ID;

    @Column(name = "card_ID")
    private int card_ID;

    @Column(name = "profit")
    private int profit;

    @Column(name = "quantity")
    private int quantity;

}
