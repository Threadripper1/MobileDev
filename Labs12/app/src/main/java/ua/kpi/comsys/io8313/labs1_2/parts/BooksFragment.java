package ua.kpi.comsys.io8313.labs1_2.parts;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;

import ua.kpi.comsys.io8313.labs1_2.Additionally.SettingsBook;
import ua.kpi.comsys.io8313.labs1_2.R;
import ua.kpi.comsys.io8313.labs1_2.resource.Books.Books;

public class BooksFragment extends Fragment {

    private RecyclerView booksListView;

    public BooksFragment(){}

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

        InputStream inputStream = null;
        try {
            inputStream = getContext().getAssets().open("json/BooksList.txt");
            System.out.println(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SettingsBook settingsBook = new SettingsBook(view.getContext(), Books.getBookFromJsonData(inputStream));
        booksListView.setAdapter(settingsBook);
        booksListView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }
}
