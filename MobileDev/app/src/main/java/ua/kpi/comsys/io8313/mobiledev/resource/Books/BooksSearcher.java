<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev.resource.Books;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BooksSearcher {

    private List<Book> books;

    @JsonProperty("List")
    public List<Book> getBooks(){
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev.resource.Books;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BooksSearcher {

    private List<Book> books;

    @JsonProperty("List")
    public List<Book> getBooks(){
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
>>>>>>> f951f76 (lab5)
