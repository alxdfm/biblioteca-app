package entities;

public class Book {

    private int num;
    private String title;
    private String author;
    private int year;
    private String status;
    private String borrowedTo;

    public Book() {
    }

    public Book(int num, String title, String author, int year, String status, String borrowedTo) {
        this.num = num;
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = status;
        this.borrowedTo = borrowedTo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(String borrowedTo) {
        this.borrowedTo = borrowedTo;
    }

    @Override
    public String toString() {
        return
                "Número: " + num + "\n" +
                "Título: " + title + "\n" +
                "Autor: " + author + "\n" +
                "Ano: " + year + "\n" +
                "Status: " + status + "\n" +
                "Emprestado para: " + borrowedTo + "\n";

    }

}
