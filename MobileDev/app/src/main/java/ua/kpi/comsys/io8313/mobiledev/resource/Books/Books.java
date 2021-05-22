<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev.resource.Books;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static BookInfo getBookInfo(InputStream inputStream){
        BookInfo bookInfo = null;

        try {
            bookInfo = mapper.readValue(inputStream, BookInfo.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(bookInfo).orElse(new BookInfo());
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev.resource.Books;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static BookInfo getBookInfo(InputStream inputStream){
        BookInfo bookInfo = null;

        try {
            bookInfo = mapper.readValue(inputStream, BookInfo.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(bookInfo).orElse(new BookInfo());
    }
}
>>>>>>> f951f76 (lab5)
