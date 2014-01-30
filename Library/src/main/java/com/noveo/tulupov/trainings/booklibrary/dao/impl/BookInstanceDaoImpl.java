package com.noveo.tulupov.trainings.booklibrary.dao.impl;

import com.noveo.tulupov.trainings.booklibrary.dao.BookInstanceDao;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.QueryExecutor;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.ResultHandler;
import com.noveo.tulupov.trainings.booklibrary.model.Author;
import com.noveo.tulupov.trainings.booklibrary.model.Book;
import com.noveo.tulupov.trainings.booklibrary.model.BookInstance;
import com.noveo.tulupov.trainings.booklibrary.model.Publisher;
import com.noveo.tulupov.trainings.booklibrary.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookInstanceDaoImpl implements BookInstanceDao {
    protected final Connection connection;

    public BookInstanceDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<BookInstance> getBookInstances() throws SQLException {
        final List<BookInstance> bookInstances = new ArrayList<BookInstance>();
        PreparedStatement selectQuery = connection.prepareStatement("SELECT * FROM BookInstance");
        QueryExecutor.executeQuery(selectQuery, new ResultHandler() {
            @Override
            public void onNextRow(ResultSet result) throws SQLException {
                final BookInstance bookInstance = new BookInstance();
                bookInstance.setId(result.getInt("id"));
                bookInstance.setBookId(result.getInt("book_id"));
                bookInstance.setPublisherId(result.getInt("publisher_id"));
                bookInstance.setYear(result.getInt("year"));
                bookInstance.setIsbn(result.getString("isbn"));
                bookInstances.add(bookInstance);
            }
        });
        return bookInstances;
    }

    @Override
    public void addBookInstance(BookInstance bookInstance) throws SQLException {
        PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO BookInstance (book_id, publisher_id, year, isbn) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        insertQuery.setInt(1, bookInstance.getBookId());
        insertQuery.setInt(2, bookInstance.getPublisherId());
        insertQuery.setInt(3, bookInstance.getYear());
        insertQuery.setString(4, bookInstance.getIsbn());
        QueryExecutor.executeQuery(insertQuery);

    }

    @Override
    public void deleteBookInstance(int id) throws SQLException {
        PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM BookInstance WHERE id = ?");
        deleteQuery.setInt(1, id);
        QueryExecutor.executeQuery(deleteQuery);
    }


    @Override
    public void addBookInstances(List<BookInstance> bookInstances) throws SQLException {
        if (bookInstances.isEmpty()) {
            return;
        }
        CallableStatement addQuery = connection.prepareCall("CALL ADD_BOOK(?, ?, ?, ?, ?)");


        String title;
        List<String> authors = new ArrayList<String>();
        List<String> publishers = new ArrayList<String>();
        List<String> years = new ArrayList<String>();
        List<String> isbns = new ArrayList<String>();

        title = bookInstances.get(0).getBook().getTitle();
        for (Author author : bookInstances.get(0).getBook().getAuthors()) {
            authors.add(author.getName());
        }
        for (BookInstance bookInstance : bookInstances) {
            publishers.add(bookInstance.getPublisher().getName());
            years.add(Integer.toString(bookInstance.getYear()));
            isbns.add(bookInstance.getIsbn());
        }

        final String delimiter = ";";
        addQuery.setString(1, title);
        addQuery.setString(2, StringUtils.join(authors, delimiter));
        addQuery.setString(3, StringUtils.join(publishers, delimiter));
        addQuery.setString(4, StringUtils.join(years, delimiter));
        addQuery.setString(5, StringUtils.join(isbns, delimiter));

        QueryExecutor.executeQuery(addQuery);
    }

    private List<Author> getBookAuthors(int bookId) throws SQLException {
        final List<Author> authors = new ArrayList<Author>();

        PreparedStatement selectQuery = null;
        try {
            selectQuery = connection.prepareStatement("SELECT Author.id, Author.name FROM BookAuthor INNER JOIN Author ON Author.id = BookAuthor.author_id AND BookAuthor.book_id = ?");
            selectQuery.setInt(1, bookId);
            final ResultSet result = selectQuery.executeQuery();

            while (result.next()) {
                final Author author = new Author();
                author.setId(result.getInt("id"));
                author.setName(result.getString("name"));
                authors.add(author);
            }
        } finally {
            if (selectQuery != null) {
                selectQuery.close();
            }
        }

        return authors;
    }

    private List<Integer> getBooks() throws SQLException {
        final List<Integer> books = new ArrayList<Integer>();
        PreparedStatement selectQuery = connection.prepareStatement("SELECT book_id FROM BookInstance GROUP BY book_id");

        QueryExecutor.executeQuery(selectQuery, new ResultHandler() {
            @Override
            public void onNextRow(ResultSet result) throws SQLException {
                books.add(result.getInt("book_id"));
            }
        });


        return books;
    }

    @Override
    public List<List<BookInstance>> getFullBookInstances() throws SQLException {
        List<List<BookInstance>> list = new ArrayList<List<BookInstance>>();

        List<Integer> books = getBooks();

        for (Integer bookId : books) {
            list.add(getFullBookInstances(bookId));
        }

        return list;
    }


    private List<BookInstance> getFullBookInstances(int bookId) throws SQLException {
        final List<BookInstance> bookInstances = new ArrayList<BookInstance>();
        PreparedStatement selectQuery = connection.prepareStatement("SELECT Book.id, Book.title, Publisher.id, Publisher.name, BookInstance.id, BookInstance.isbn, BookInstance.year FROM BookInstance JOIN Book INNER JOIN Publisher ON book_id = Book.id AND BookInstance.publisher_id = Publisher.id AND book_id = ?");
        selectQuery.setInt(1, bookId);

        QueryExecutor.executeQuery(selectQuery, new ResultHandler() {
            @Override
            public void onNextRow(ResultSet result) throws SQLException {
                final BookInstance bookInstance = new BookInstance();

                final Book book = new Book();
                book.setId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthors(getBookAuthors(book.getId()));
                bookInstance.setBook(book);
                final Publisher publisher = new Publisher();
                publisher.setId(result.getInt(3));
                publisher.setName(result.getString(4));
                bookInstance.setPublisher(publisher);
                bookInstance.setId(result.getInt(5));
                bookInstance.setIsbn(result.getString(6));
                bookInstance.setYear(result.getInt(7));
                bookInstances.add(bookInstance);
            }
        });


        return bookInstances;
    }
}
