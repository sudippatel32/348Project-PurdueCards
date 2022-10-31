package PurdueCards.Application.model;

import javax.persistence.*;

@Entity
@Table(name="purchases")
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name = "purchaser_ID")
    private int purchaser_ID;

    @Column(name = "card_ID")
    private int card_ID;

    @Column(name = "cost")
    private int cost;

    @Column(name = "quantity")
    private int quantity;


}
