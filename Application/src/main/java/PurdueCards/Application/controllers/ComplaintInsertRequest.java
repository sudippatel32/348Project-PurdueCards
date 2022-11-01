package PurdueCards.Application.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComplaintInsertRequest {
    int customer_id;
    int sale_id;
    String body;
}
