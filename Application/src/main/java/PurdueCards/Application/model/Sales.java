package PurdueCards.Application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "buyer_ID",nullable = false)
    private Customer buyer;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "card_ID",nullable = false)
    private Card card;

    @Column(name = "profit")
    private int profit;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;



    public Sales(Customer buyer, Card card, int profit, int quantity, Date date){
        this.buyer = buyer;
        this.card = card;
        this.profit = profit;
        this.quantity = quantity;
        this.date = date;
    }
}
