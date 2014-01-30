CREATE VIEW BookInstancesView AS 
	SELECT Book.id,title, COUNT(*) 
	FROM Book, BookInstance 
	WHERE Book.id = BookInstance.book_id 
	GROUP BY book_id 
	ORDER BY COUNT(*) DESC;
