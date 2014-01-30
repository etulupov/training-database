-- DROP DATABASE IF EXISTS Library
-- ;

--CREATE DATABASE IF NOT EXISTS Library
--;

USE Library
;

CREATE TABLE IF NOT EXISTS Author (
	id INTEGER AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS Publisher (
	id INTEGER AUTO_INCREMENT, 
	name VARCHAR(100) NOT NULL,
	book_count INTEGER DEFAULT 0 NOT NULL,
	PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS Book (
	id INTEGER AUTO_INCREMENT, 
	title VARCHAR(100) NOT NULL, 
	PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS BookAuthor (
	book_id INTEGER NOT NULL,
	author_id INTEGER NOT NULL,
	PRIMARY KEY (book_id, author_id),
	FOREIGN KEY (book_id) REFERENCES Book (id),
	FOREIGN KEY (author_id) REFERENCES Author (id)
)
;

CREATE TABLE IF NOT EXISTS BookInstance (
	id INTEGER AUTO_INCREMENT, 
	book_id INTEGER NOT NULL,
	publisher_id INTEGER NOT NULL,
	year INTEGER NOT NULL, 
	isbn VARCHAR(15) NOT NULL, 
	PRIMARY KEY (id),
	FOREIGN KEY (book_id) REFERENCES Book (id),
	FOREIGN KEY (publisher_id) REFERENCES Publisher (id) ON DELETE CASCADE 
)
;
