-- Splits string
-- '1;2;3;4' => {'1', '2', '3', '4'}
DROP FUNCTION IF EXISTS SPLIT_STR;
CREATE FUNCTION SPLIT_STR(
  X VARCHAR(255),
  pos INT
)
RETURNS VARCHAR(255)
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(X, ';', pos),
       LENGTH(SUBSTRING_INDEX(X, ';', pos -1)) + 1),
       ';', '');



-- Adds new book instance to library
DROP PROCEDURE IF EXISTS ADD_BOOK;
DELIMITER // ;
CREATE PROCEDURE ADD_BOOK (	IN bookTitle VARCHAR(100), 
				IN authorList VARCHAR(100),
				IN publisherList VARCHAR(100), 
				IN yearList VARCHAR(100),
				IN isbnList VARCHAR(100))
 BEGIN
	DECLARE bookId INT;
	DECLARE authorId INT;
	DECLARE authorListId INT;
	DECLARE i INT;
	DECLARE author VARCHAR(100);
	DECLARE publisher VARCHAR(100);
	DECLARE publisherId INT;	

	DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;	 
		 
	START TRANSACTION;

	INSERT INTO Book (title) VALUES (bookTitle);
	SET bookId = LAST_INSERT_ID();
	
	SET i = 1;
	REPEAT		
		SET author = SPLIT_STR(authorList, i);
		
		IF (LENGTH(author) > 0) THEN			
			INSERT INTO Author (`name`) VALUES (author);
			SET authorId = LAST_INSERT_ID();					 
			INSERT INTO BookAuthor (book_id, author_id) VALUES (bookId, authorId);		
			SET i = i + 1;		
		END IF;		
	UNTIL LENGTH(author) = 0	
	END REPEAT; 
	
	
	SET i = 1;
	REPEAT		
		SET publisher = SPLIT_STR(publisherList, i);
		
		IF (LENGTH(publisher) > 0) THEN	
					
			SET publisherId = (SELECT id FROM Publisher WHERE `name` = publisher);
			IF (publisherId IS NULL) THEN
				INSERT INTO Publisher (`name`) VALUES (publisher);
				SET publisherId = LAST_INSERT_ID();
			END IF;					 
			
			INSERT INTO BookInstance (book_id, publisher_id, `year`, isbn) VALUES (bookId, publisherId, SPLIT_STR(yearList, i), SPLIT_STR(isbnList, i));		
			SET i = i + 1;		
		END IF;		
	UNTIL LENGTH(publisher) = 0	
	END REPEAT; 	
	
	COMMIT;
END//
DELIMITER ; //




CALL ADD_BOOK('The C Programming Language', 'Dennis Ritchie;Brian Kernighan', 'Osborne;Prentice Hall;Addison-Wesley Professional', '1999;2000;2001','1;2;3');


SELECT Book.id, Book.title, Author.name, Publisher.name, BookInstance.year, BookInstance.isbn  FROM Book 
	INNER JOIN Publisher
	INNER JOIN BookInstance
	INNER JOIN BookAuthor
	INNER JOIN Author
	ON BookInstance.book_id = BookAuthor.book_id AND BookInstance.book_id = Book.id AND BookAuthor.author_id = Author.id AND BookInstance.publisher_id = Publisher.id ;
 
 
 
