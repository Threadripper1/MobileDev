package ua.kpi.comsys.io8313.labs1_2.resource.Books;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Books {

    private static final ObjectMapper mapper = new ObjectMapper();

    private Books() {}

    public static List<Book> getBookFromJsonData(InputStream inputStream){
        try {
            BooksSearcher booksSearcher = mapper.readValue(inputStream, BooksSearcher.class);
            return booksSearcher.getBooks();
    }
        catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
