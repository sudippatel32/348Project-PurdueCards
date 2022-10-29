package PurdueCards.Application.model;

import java.io.Serializable;

public class cardID implements Serializable {
    private String name;
    private String set;
    private Boolean foil;

    public cardID(String name, String set, Boolean foil) {
        this.name = name;
        this.set = set;
        this.foil = foil;
    }
}
