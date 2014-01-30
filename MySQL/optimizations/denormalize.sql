ALTER TABLE Publisher ADD COLUMN book_count INTEGER DEFAULT 0 NOT NULL;

DROP PROCEDURE IF EXISTS UPGRADE_DB;
DELIMITER // ;
CREATE PROCEDURE UPGRADE_DB()
BEGIN
	DECLARE done INT DEFAULT 0;
	DECLARE publisherId INT;
	DECLARE books INT;
	DECLARE publisherCursor CURSOR FOR SELECT id FROM Publisher;

	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;

	OPEN publisherCursor;
   

	REPEAT
		FETCH publisherCursor INTO publisherId;
 
		SET books = (SELECT COUNT(*) FROM BookInstance WHERE publisher_id = publisherId);
		UPDATE Publisher SET book_count = books WHERE id = publisherId;
		
	UNTIL done END REPEAT;
	CLOSE publisherCursor;

END//
DELIMITER ; //

CALL UPGRADE_DB();

DROP PROCEDURE IF EXISTS UPGRADE_DB;




DROP TRIGGER IF EXISTS PUBLISHER_TRIGGER_INSERT;
DELIMITER // ;
CREATE TRIGGER PUBLISHER_TRIGGER_INSERT BEFORE INSERT ON BookInstance
FOR EACH ROW
BEGIN
	DECLARE books INT;
	SET books = (SELECT book_count FROM Publisher WHERE id = NEW.publisher_id);
	UPDATE Publisher SET book_count = books + 1 WHERE id = NEW.publisher_id;
END//

DELIMITER ; //


DROP TRIGGER IF EXISTS PUBLISHER_TRIGGER_DELETE;
DELIMITER // ;
CREATE TRIGGER PUBLISHER_TRIGGER_UPDATE BEFORE DELETE ON BookInstance
FOR EACH ROW
BEGIN
	DECLARE books INT;
	SET books = (SELECT book_count FROM Publisher WHERE id = OLD.publisher_id);
	UPDATE Publisher SET book_count = books - 1 WHERE id = OLD.publisher_id;
END//
DELIMITER ; //



-- SELECT `name`, book_count FROM Publisher ORDER BY book_count DESC;

