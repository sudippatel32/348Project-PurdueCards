package PurdueCards.Application.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class complaintID implements Serializable {
    @ManyToOne
    @JoinColumn(name = "customer_ID")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "sale_ID")
    Sales sale;
}
