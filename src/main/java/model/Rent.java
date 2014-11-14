package model;

import java.util.Date;

/**
 * Created by jan-philippbenecke on 14.11.14.
 */
public class Rent {

    private String id;
    private String idCustomer;
    private String idBook;
    private Book rentedBook;
    private Customer customer;
    private Date date;
    private Date returnDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public Book getRentedBook() {
        return rentedBook;
    }

    public void setRentedBook(Book rentedBook) {
        this.rentedBook = rentedBook;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
