package PurdueCards.Application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@IdClass(cardID.class)
@Table(name="cards")
@NoArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    private String name;
    @Id
    private String set;
    @Id
    private Boolean foil;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "color")
    private String color;

    @Column(name = "rarity")
    private char rarity;

    @Column(name = "price")
    private int price;
}
