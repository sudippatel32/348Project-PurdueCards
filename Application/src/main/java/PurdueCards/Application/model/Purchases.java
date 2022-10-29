package PurdueCards.Application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchases")
public class Purchases {
    @Id
    private int id;

    @Column(name = "")
    private int purchaser_ID;

    private String card_name;

    private String card_set;

    private boolean card_foiling;
}
