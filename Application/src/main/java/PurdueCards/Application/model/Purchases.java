package PurdueCards.Application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="purchases", indexes = {@Index(columnList = "seller_id"),@Index(columnList = "date")})
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id",nullable = false)
    private Customer purchaser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_ID", nullable = false)
    private Card card;

    @Column(name = "cost")
    private int cost;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Purchases(Customer seller, Card card, int cost, int quantity, Date date){
        this.purchaser = seller;
        this.card = card;
        this.cost = cost;
        this.quantity = quantity;
        this.date = date;
    }


}
