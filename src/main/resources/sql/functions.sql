-- Trigger function
CREATE OR replace function update_book_quantity_actual()
returns trigger as $$
BEGIN
UPDATE books
SET quantity_actual = COALESCE(
	(
		SELECT SUM(CASE
				   WHEN UPPER(type) = 'DELIVERY' THEN quantity
				   WHEN UPPER(type) = 'SALE' THEN -quantity
				   ELSE 0 END)
		FROM books_movement
		WHERE book_id = NEW.book_id
	), 0)
WHERE id = NEW.book_id;
return new;
END;
$$ LANGUAGE plpgsql;

-- Trigger
CREATE OR replace trigger books_movement_trigger
after INSERT OR UPDATE OR DELETE ON books_movement
FOR each row
EXECUTE function update_book_quantity_actual();

SELECT * FROM books;

INSERT INTO books_movement (date, book_id, type, quantity)
VALUES ('2023-11-22T12:24:10', 1, 'Delivery', 1);