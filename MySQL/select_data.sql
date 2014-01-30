SELECT book_id, Book.title, Publisher.name
FROM BookInstance, Book, Publisher
WHERE (book_id = Book.id) AND (publisher_id = Publisher.id)
  AND book_id IN (
	SELECT book_id
	FROM BookAuthor
	WHERE author_id IN (
		SELECT id
		FROM Author
		WHERE (name = 'Alexander Pushkin')
    )
  );



SELECT bi.id, b.title  FROM Book b
INNER JOIN BookInstance bi
INNER JOIN BookAuthor ba
INNER JOIN Author a
ON bi.book_id = ba.book_id
  AND bi.book_id = b.id
  AND ba.author_id = a.id
  AND a.name = 'Alexander Pushkin';




SELECT Book.id,title, count(*)
FROM Book, BookInstance
WHERE Book.id = BookInstance.book_id
GROUP BY book_id
ORDER BY count(*) DESC;



SELECT title
FROM Book
WHERE title LIKE '%and%';
