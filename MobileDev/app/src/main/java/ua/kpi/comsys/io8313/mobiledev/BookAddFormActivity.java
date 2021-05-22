<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.kpi.comsys.io8313.mobiledev.parts.BooksFragment;
import ua.kpi.comsys.io8313.mobiledev.resource.Books.Book;

import static android.widget.Toast.LENGTH_SHORT;

public class BookAddFormActivity extends AppCompatActivity {
    public static final String TAG = "BookAddFormActivity";

    private EditText titleTextEdit;
    private EditText subtitleTextEdit;
    private EditText priceTextEdit;
    private Button addButton;
    private TextView logBooks;
    private List<Book> logBooksList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add_form);
        this.titleTextEdit = findViewById(R.id.titleTextEdit);
        this.subtitleTextEdit = findViewById(R.id.subtitleTextEdit);
        this.priceTextEdit = findViewById(R.id.priceTextEdit);
        this.addButton = findViewById(R.id.addBookButton);
        this.logBooks = findViewById(R.id.logView);
        this.logBooksList = new ArrayList<>();


        addButton.setOnClickListener(view -> {
            String title = titleTextEdit.getText().toString();
            String subtitle = subtitleTextEdit.getText().toString();
            String price = priceTextEdit.getText().toString();

            if (fieldAreValid(title, subtitle, price));
            Book book = new Book(title, subtitle, "", price, "");
            BooksFragment.addToBookList(book);
            titleTextEdit.setText("");
            subtitleTextEdit.setText("");
            priceTextEdit.setText("");
            logBooksList.add(book);
            logBooks.append(notifyLogBookList());
            Toast.makeText(getApplicationContext(),
                    String.format("%s was successfully added to the your book list", book.getTitle()),
                    Toast.LENGTH_LONG).show();
            addButton.setFocusable(true);
        });
    }

    private String notifyLogBookList() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("yyyy:dd:MM[HH:mm:ss]");
        String now = simpleDateFormat.format(new Date());
        Book lastBook = logBooksList.get(logBooksList.size() - 1);

        return String.format("%s:%s - %s subtitle, %s price%n", now, lastBook.getTitle(), lastBook.getSubtitle(), lastBook.getPrice());
    }

    private boolean fieldAreValid(String title, String subtitle, String price) {
        float parsedPrice;

        if (title.isEmpty() || subtitle.isEmpty() || price.isEmpty()) {
            Toast.makeText(getApplicationContext(), "One of the field is empty",
                    Toast.LENGTH_LONG).show();
            return false;
        } else if (title.length() < 3 || subtitle.length() < 3) {
            Toast.makeText(getApplicationContext(), "Title or type field's size must be >= 3",
                    LENGTH_SHORT).show();
            return false;
        }

        try {
            parsedPrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            Log.e(TAG, "cannot parse the price: "+e.getMessage());
            Toast.makeText(getApplicationContext(),
                    "Invalid specified price, expected numeric format"+price,
                    LENGTH_SHORT).show();
            return false;
        }

        if (parsedPrice < 0) {
            Toast.makeText(getApplicationContext(),
                    "Price cannot be less then 0. \uD83D\uDE42",
                    LENGTH_SHORT
            ).show();
            return false;
        }

        return true;
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.kpi.comsys.io8313.mobiledev.parts.BooksFragment;
import ua.kpi.comsys.io8313.mobiledev.resource.Books.Book;

import static android.widget.Toast.LENGTH_SHORT;

public class BookAddFormActivity extends AppCompatActivity {
    public static final String TAG = "BookAddFormActivity";

    private EditText titleTextEdit;
    private EditText subtitleTextEdit;
    private EditText priceTextEdit;
    private Button addButton;
    private TextView logBooks;
    private List<Book> logBooksList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add_form);
        this.titleTextEdit = findViewById(R.id.titleTextEdit);
        this.subtitleTextEdit = findViewById(R.id.subtitleTextEdit);
        this.priceTextEdit = findViewById(R.id.priceTextEdit);
        this.addButton = findViewById(R.id.addBookButton);
        this.logBooks = findViewById(R.id.logView);
        this.logBooksList = new ArrayList<>();


        addButton.setOnClickListener(view -> {
            String title = titleTextEdit.getText().toString();
            String subtitle = subtitleTextEdit.getText().toString();
            String price = priceTextEdit.getText().toString();

            if (fieldAreValid(title, subtitle, price));
            Book book = new Book(title, subtitle, "", price, "");
            BooksFragment.addToBookList(book);
            titleTextEdit.setText("");
            subtitleTextEdit.setText("");
            priceTextEdit.setText("");
            logBooksList.add(book);
            logBooks.append(notifyLogBookList());
            Toast.makeText(getApplicationContext(),
                    String.format("%s was successfully added to the your book list", book.getTitle()),
                    Toast.LENGTH_LONG).show();
            addButton.setFocusable(true);
        });
    }

    private String notifyLogBookList() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("yyyy:dd:MM[HH:mm:ss]");
        String now = simpleDateFormat.format(new Date());
        Book lastBook = logBooksList.get(logBooksList.size() - 1);

        return String.format("%s:%s - %s subtitle, %s price%n", now, lastBook.getTitle(), lastBook.getSubtitle(), lastBook.getPrice());
    }

    private boolean fieldAreValid(String title, String subtitle, String price) {
        float parsedPrice;

        if (title.isEmpty() || subtitle.isEmpty() || price.isEmpty()) {
            Toast.makeText(getApplicationContext(), "One of the field is empty",
                    Toast.LENGTH_LONG).show();
            return false;
        } else if (title.length() < 3 || subtitle.length() < 3) {
            Toast.makeText(getApplicationContext(), "Title or type field's size must be >= 3",
                    LENGTH_SHORT).show();
            return false;
        }

        try {
            parsedPrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            Log.e(TAG, "cannot parse the price: "+e.getMessage());
            Toast.makeText(getApplicationContext(),
                    "Invalid specified price, expected numeric format"+price,
                    LENGTH_SHORT).show();
            return false;
        }

        if (parsedPrice < 0) {
            Toast.makeText(getApplicationContext(),
                    "Price cannot be less then 0. \uD83D\uDE42",
                    LENGTH_SHORT
            ).show();
            return false;
        }

        return true;
    }
}
>>>>>>> f951f76 (lab5)
