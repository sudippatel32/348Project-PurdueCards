package PurdueCards.Application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="card")
@NoArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;

    @Column(name="name")
    private String name;

    @Column(name="set_name")
    private String set;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "color")
    private String color;

    @Column(name = "rarity")
    private char rarity;

    @Column(name = "foil")
    private Boolean foil;

    @Column(name = "price")
    private int price;

    public Card(String name, String set, String color, Character rarity, Boolean foil, int price, int quantity) {
        this.name = name;
        this.set = set;
        this.color = color;
        this.rarity = rarity;
        this.foil = foil;
        this.price = price;
        this.quantity = quantity;
    }
}
