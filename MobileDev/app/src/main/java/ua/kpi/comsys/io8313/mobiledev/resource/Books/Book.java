<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev.resource.Books;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("isbn13")
    private String isbn13;

    @JsonProperty("price")
    private String price;

    @JsonProperty("image")
    private String image;

    public Book(){}

    public Book(String title, String subtitle, String image, String price, String isbn13){
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.price = price;
        this.isbn13 = isbn13;
    }

    public String getTitle() { return title; }

    public String getPrice() {
        return price;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getImage() {
        return image;
    }

    public String getIsbn13(){ return isbn13;}

    public void setIsbn13(String isbn13) { this.isbn13 = isbn13;}

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev.resource.Books;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("isbn13")
    private String isbn13;

    @JsonProperty("price")
    private String price;

    @JsonProperty("image")
    private String image;

    public Book(){}

    public Book(String title, String subtitle, String image, String price, String isbn13){
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.price = price;
        this.isbn13 = isbn13;
    }

    public String getTitle() { return title; }

    public String getPrice() {
        return price;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getImage() {
        return image;
    }

    public String getIsbn13(){ return isbn13;}

    public void setIsbn13(String isbn13) { this.isbn13 = isbn13;}

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
>>>>>>> f951f76 (lab5)
