package PurdueCards.Application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "complaints", indexes = {@Index(columnList = "sale_ID")})
public class Complaints implements Serializable {
    @EmbeddedId
    private complaintID ID;

    @Column(name = "body")
    String body;
}
