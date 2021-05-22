<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

import ua.kpi.comsys.io8313.mobiledev.resource.Books.BookInfo;

public class BookInfoActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        BookInfo bookInfo = ((BookInfo) getIntent().getSerializableExtra("bookInfo"));

        ImageView imageView = findViewById(R.id.bookImageView);
        if (!bookInfo.getImage().equals("")){
            try {
                InputStream ims = getApplicationContext().getAssets().open(
                        "book_image/" + bookInfo.getImage());
                Drawable d = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            imageView.setImageResource(0);
        }

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView subtitleTextView = findViewById(R.id.subtitleTextView);
        TextView authorsTextView = findViewById(R.id.authorsTextView);
        TextView publisherTextView = findViewById(R.id.publisherTextView);
        TextView isbn13TextView = findViewById(R.id.isbn13TextView);
        TextView pagesTextView = findViewById(R.id.pagesTextView);
        TextView yearTextView = findViewById(R.id.yearTextView);
        TextView ratingTextView = findViewById(R.id.ratingTextView);
        TextView deskTextView = findViewById(R.id.deskTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);

        titleTextView.setText(bookInfo.getTitle());
        subtitleTextView.setText(bookInfo.getSubtitle());
        authorsTextView.setText(bookInfo.getAuthors());
        publisherTextView.setText(bookInfo.getPublisher());
        isbn13TextView.setText(bookInfo.getIsbn13());
        pagesTextView.setText(bookInfo.getPages());
        yearTextView.setText(bookInfo.getYear());
        ratingTextView.setText(bookInfo.getRating());
        deskTextView.setText(bookInfo.getDesc());
        priceTextView.setText(bookInfo.getPrice());
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

import ua.kpi.comsys.io8313.mobiledev.resource.Books.BookInfo;

public class BookInfoActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        BookInfo bookInfo = ((BookInfo) getIntent().getSerializableExtra("bookInfo"));

        ImageView imageView = findViewById(R.id.bookImageView);
        if (!bookInfo.getImage().equals("")){
            try {
                InputStream ims = getApplicationContext().getAssets().open(
                        "book_image/" + bookInfo.getImage());
                Drawable d = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            imageView.setImageResource(0);
        }

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView subtitleTextView = findViewById(R.id.subtitleTextView);
        TextView authorsTextView = findViewById(R.id.authorsTextView);
        TextView publisherTextView = findViewById(R.id.publisherTextView);
        TextView isbn13TextView = findViewById(R.id.isbn13TextView);
        TextView pagesTextView = findViewById(R.id.pagesTextView);
        TextView yearTextView = findViewById(R.id.yearTextView);
        TextView ratingTextView = findViewById(R.id.ratingTextView);
        TextView deskTextView = findViewById(R.id.deskTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);

        titleTextView.setText(bookInfo.getTitle());
        subtitleTextView.setText(bookInfo.getSubtitle());
        authorsTextView.setText(bookInfo.getAuthors());
        publisherTextView.setText(bookInfo.getPublisher());
        isbn13TextView.setText(bookInfo.getIsbn13());
        pagesTextView.setText(bookInfo.getPages());
        yearTextView.setText(bookInfo.getYear());
        ratingTextView.setText(bookInfo.getRating());
        deskTextView.setText(bookInfo.getDesc());
        priceTextView.setText(bookInfo.getPrice());
    }
}
>>>>>>> f951f76 (lab5)
