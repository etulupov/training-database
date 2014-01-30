INSERT INTO Author (name) VALUES 
	('Leo Tolstoy'),
	('Brian Kernighan'),
	('Dennis Ritchie'),
	('Herberd Schildt'),
	('Fred Hall'),
	('Roger Greeno'),
	('John Purkiss'),
	('Alexander Pushkin');



INSERT INTO Book (title) VALUES 
	('War and Peace'),
	('The C Programming Language'),
	('The Complete Reference Book - C++'),
	('Building Services Handbook'),
	('Fire Safety Engineering: Design of Structures'),
	('Eugene Onegin'),
	('Ruslan and Lyudmila'),
	('Poemy I Povesti');

INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'War and Peace') AND (Author.name = 'Leo Tolstoy');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'The C Programming Language') AND (Author.name = 'Brian Kernighan');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'The C Programming Language') AND (Author.name = 'Dennis Ritchie');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'The Complete Reference Book - C++') AND (Author.name = 'Herberd Schildt');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'Building Services Handbook') AND (Author.name = 'Fred Hall');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'Building Services Handbook') AND (Author.name = 'Roger Greeno');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'Fire Safety Engineering: Design of Structures') AND (Author.name = 'John Purkiss');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'Eugene Onegin') AND (Author.name = 'Alexander Pushkin');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'Ruslan and Lyudmila') AND (Author.name = 'Alexander Pushkin');
INSERT INTO BookAuthor (book_id, author_id) SELECT Book.id, Author.id FROM Book, Author WHERE (Book.title = 'Poemy I Povesti') AND (Author.name = 'Alexander Pushkin');


INSERT INTO Publisher (name) VALUES 
	('OReilly'),
	('Prentice Hall'),
	('Addison-Wesley Professional'),
	('Osborne'),
	('Butterworth-Heinemann'),
	('Astrel'),
	('Oko'),
	('Hesperus Press'),
	('Univ of Wisconsin Pr');


INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 1998, '0078824761' FROM Book, Publisher WHERE (Book.title = 'The Complete Reference Book - C++') AND (Publisher.name = 'Osborne');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2007, '0750682205' FROM Book, Publisher WHERE (Book.title = 'Building Services Handbook') AND (Publisher.name = 'Butterworth-Heinemann');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 1988, '0781108947' FROM Book, Publisher WHERE (Book.title = 'The C Programming Language') AND (Publisher.name = 'OReilly');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 1988, '0131103628' FROM Book, Publisher WHERE (Book.title = 'The C Programming Language') AND (Publisher.name = 'Prentice Hall');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2002, '0258744545' FROM Book, Publisher WHERE (Book.title = 'The C Programming Language') AND (Publisher.name = 'Addison-Wesley Professional');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2006, '0750664436' FROM Book, Publisher WHERE (Book.title = 'Fire Safety Engineering: Design of Structures') AND (Publisher.name = 'Butterworth-Heinemann');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2010, '9785170707973' FROM Book, Publisher WHERE (Book.title = 'War and Peace') AND (Publisher.name = 'Astrel');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2007, '9785699088607' FROM Book, Publisher WHERE (Book.title = 'War and Peace') AND (Publisher.name = 'Oko');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2001, '5983790110' FROM Book, Publisher WHERE (Book.title = 'Eugene Onegin') AND (Publisher.name = 'Astrel');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2004, '1843911167' FROM Book, Publisher WHERE (Book.title = 'Eugene Onegin') AND (Publisher.name = 'Oko');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2000, '5862183809' FROM Book, Publisher WHERE (Book.title = 'Ruslan and Lyudmila') AND (Publisher.name = 'Hesperus Press');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2001, '9684115687' FROM Book, Publisher WHERE (Book.title = 'Poemy I Povesti') AND (Publisher.name = 'Univ of Wisconsin Pr');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2000, '4584115547' FROM Book, Publisher WHERE (Book.title = 'Poemy I Povesti') AND (Publisher.name = 'Hesperus Press');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2003, '9889115217' FROM Book, Publisher WHERE (Book.title = 'Poemy I Povesti') AND (Publisher.name = 'Astrel');
INSERT INTO BookInstance (book_id, publisher_id, year, isbn) SELECT Book.id, Publisher.id, 2008, '8784115877' FROM Book, Publisher WHERE (Book.title = 'Poemy I Povesti') AND (Publisher.name = 'Oko');




