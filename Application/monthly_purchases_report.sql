SET TRANSACTION ISLOATION LEVEL SERIALIZABLE;

DELIMITER //

CREATE PROCEDURE IF NOT EXISTS monthlyPurchasesReport AS
BEGIN
  BEGIN TRANSACTION;
    SELECT Purchases.ID, Customer.name, Card.name, Purchases.cost,
     Purchases.quantity, Purchases.date
    FROM Purchases
      JOIN Customer ON Purchases.seller_ID = Customer.ID
      JOIN Card ON Purchases.card_ID = Card.ID
    WHERE DATEDIFF(month, Purchases.date, CURRENT_DATE) <= 1
    ORDER BY date DESC;
  COMMIT;
END
//
DELIMITER ;
