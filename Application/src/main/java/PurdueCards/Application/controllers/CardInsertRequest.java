package PurdueCards.Application.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CardInsertRequest {
    private String name;
    private String set;
    private boolean foil;
    private String color;
    private char rarity;
    private int price;
    private int quantity;
}
