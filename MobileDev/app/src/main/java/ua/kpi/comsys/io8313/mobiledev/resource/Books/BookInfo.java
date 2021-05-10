package ua.kpi.comsys.io8313.mobiledev.resource.Books;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BookInfo implements Serializable {

    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("authors")
    private String authors;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("isbn13")
    private String isbn13;

    @JsonProperty("pages")
    private String pages;

    @JsonProperty("year")
    private String year;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("price")
    private String price;

    @JsonProperty("image")
    private String image;

    public BookInfo(){}

    public BookInfo(String title, String subtitle, String authors, String publisher,
                    String isbn13, String pages, String year, String rating,
                    String desc, String price, String image){
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn13 = isbn13;
        this.pages = pages;
        this.year = year;
        this.rating = rating;
        this.desc = desc;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getPages() {
        return pages;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", authors='" + authors + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", pages='" + pages + '\'' +
                ", year ='" + year + '\'' +
                ", rating='" + rating + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
