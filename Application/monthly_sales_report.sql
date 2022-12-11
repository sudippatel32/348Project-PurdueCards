SET TRANSACTION ISLOATION LEVEL SERIALIZABLE;

DELIMITER //

CREATE PROCEDURE IF NOT EXISTS monthlySalesReport AS
BEGIN
  BEGIN TRANSACTION;
    SELECT Sales.ID, Customer.name, Card.name, Sales.profit, Sales.quantity,
     Sales.date
    FROM Sales
      JOIN Customer ON Sales.buyer_ID = Customer.ID
      JOIN Card ON Sales.card_ID = Card.ID
    WHERE DATEDIFF(month, Sales.date, CURRENT_DATE) <= 1
    ORDER BY date DESC;
  COMMIT;
END
//
DELIMITER ;
