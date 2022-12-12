package PurdueCards.Application.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComplaintInsertRequest {
    int customerId;
    int saleId;
    String body;
}
