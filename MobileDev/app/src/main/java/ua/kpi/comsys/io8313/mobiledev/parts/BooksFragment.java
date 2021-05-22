package ua.kpi.comsys.io8313.mobiledev.parts;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import ua.kpi.comsys.io8313.mobiledev.Additionally.SettingsBook;
import ua.kpi.comsys.io8313.mobiledev.BookAddFormActivity;
import ua.kpi.comsys.io8313.mobiledev.BookInfoActivity;
import ua.kpi.comsys.io8313.mobiledev.R;
import ua.kpi.comsys.io8313.mobiledev.resource.Books.Book;
import ua.kpi.comsys.io8313.mobiledev.resource.Books.BookInfo;
import ua.kpi.comsys.io8313.mobiledev.resource.Books.Books;
import ua.kpi.comsys.io8313.mobiledev.tabs.AssetHelper;

public class BooksFragment extends Fragment implements SettingsBook.OnBookListener {
    private static final String TAG = "BooksFragment";

    private static SettingsBook settingsBook;
    private static List<Book> bookList;
    private static List<Book> filteredBookList;
    private RecyclerView booksListView;
    private EditText searchEditText;
    public CharSequence searchText = "";


    private ItemTouchHelper.SimpleCallback itemToucHCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int adapterPosition = viewHolder.getAdapterPosition();
            Toast.makeText(getContext(), String.format("%s book was removed successfully",
                    bookList.get(adapterPosition).getTitle()), Toast.LENGTH_LONG).show();
            bookList.remove(adapterPosition);
            settingsBook.notifyDataSetChanged();
        }
    };

    public static void addToBookList(Book book) {
        bookList.add(book);
        filteredBookList = bookList;
        settingsBook.notifyDataSetChanged();
    }

    public BooksFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.books_fragment, container, false);
        this.booksListView = view.findViewById(R.id.booksListView);

        FloatingActionButton fabAdd = view.findViewById(R.id.fab_add);

        searchEditText = view.findViewById(R.id.search_book_bar);

        InputStream inputStream = null;
        try {
            inputStream = AssetHelper.getInputStreamFromFile(view.getContext(),"json/BooksList.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookList = Books.getBookFromJsonData(inputStream);
        filteredBookList = bookList;

        settingsBook = new SettingsBook(view.getContext(), bookList, this);
        booksListView.setAdapter(settingsBook);
        booksListView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        new ItemTouchHelper(itemToucHCallback).attachToRecyclerView(booksListView);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                settingsBook.getFilter().filter(s);
                filteredBookList = settingsBook.getActualFilteredList();
                searchText = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                filteredBookList = settingsBook.getActualFilteredList();
            }
        });

        fabAdd.setOnClickListener(view1 -> {
            Intent intent = new Intent(this.getContext(), BookAddFormActivity.class);
            startActivity(intent);
        });
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBookClickListener(int position) {
        Intent intent = new Intent(this.getContext(), BookInfoActivity.class);
        filteredBookList = settingsBook.getActualFilteredList();
        String filePath = "";
        try {
            filePath = "books_info/".concat(filteredBookList.get(position).getIsbn13()).concat(".txt");
            InputStream inputStream = AssetHelper.getInputStreamFromFile(Objects.requireNonNull(getContext()), filePath);

            BookInfo bookInfo = Books.getBookInfo(inputStream);
            intent.putExtra("bookInfo", bookInfo);
            startActivity(intent);

        } catch (FileNotFoundException e) {
            Log.e(TAG, String.format("cannot find specified file %s", filePath));
            Toast.makeText(getContext(), "There is not found into about this book", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Log.e(TAG, e.getMessage());
        }
    }
}
