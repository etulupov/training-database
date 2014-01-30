package com.noveo.tulupov.trainings.booklibrary.model;

public class BookInstance {
    private int id;

    private int year;
    private String isbn;

    private Book book;
    private Publisher publisher;

    public BookInstance() {
        book = new Book();
        publisher = new Publisher();
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return book.getId();
    }

    public void setBookId(int bookId) {
        book.setId(bookId);
    }

    public int getPublisherId() {
        return publisher.getId();
    }

    public void setPublisherId(int publisherId) {
        publisher.setId(publisherId);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
