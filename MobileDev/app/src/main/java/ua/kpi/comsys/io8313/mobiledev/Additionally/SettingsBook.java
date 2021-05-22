package ua.kpi.comsys.io8313.mobiledev.Additionally;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import ua.kpi.comsys.io8313.mobiledev.R;
import ua.kpi.comsys.io8313.mobiledev.resource.Books.Book;

public class SettingsBook extends RecyclerView.Adapter<SettingsBook.BookViewHolder> {
    public static final String TAG = "SettingsBook";

    private LayoutInflater inflater;
    private final List<Book> bookList;
    private List<Book> filteredBookList;
    private OnBookListener onBookListener;

    public List<Book> getActualFilteredList(){
        return filteredBookList;
    }

    public SettingsBook(Context context, List<Book> bookList, OnBookListener onBookListener) {
        this.bookList = bookList;
        this.inflater = LayoutInflater.from(context);
        this.onBookListener = onBookListener;
        this.filteredBookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.book_list_item, viewGroup, false);
        return new BookViewHolder(view, onBookListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsBook.BookViewHolder holder, int position) {
        Book book = filteredBookList.get(position);
        if (!book.getImage().equals("")) {
            try {
                InputStream ims = inflater.getContext().getAssets().open(
                        "book_image/" + book.getImage());
                Drawable d = Drawable.createFromStream(ims, null);
                holder.bookImageView.setImageDrawable(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            holder.bookImageView.setImageResource(0);
        }
        holder.bookSubtitleTextView.setText(book.getSubtitle());
        holder.bookTitleTextView.setText(book.getTitle());
        holder.bookPriceTextView.setText(book.getPrice());
    }

    @Override
    public int getItemCount() {
        return filteredBookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView bookImageView;
        protected TextView bookSubtitleTextView;
        protected TextView bookTitleTextView;
        protected TextView bookPriceTextView;
        protected OnBookListener onBookListener;

        public BookViewHolder(@NonNull View itemView, OnBookListener onBookListener) {
            super(itemView);
            this.bookImageView = itemView.findViewById(R.id.bookImageView);
            this.bookPriceTextView = itemView.findViewById(R.id.bookPriceTextView);
            this.bookSubtitleTextView = itemView.findViewById(R.id.bookSubtitleTextView);
            this.bookTitleTextView = itemView.findViewById(R.id.bookTitleTextView);
            this.onBookListener = onBookListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onBookListener.onBookClickListener(getAdapterPosition());
        }
    }

    public interface OnBookListener {
        void onBookClickListener(int position);
    }

    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence sequence) {
                String key = sequence.toString();
                if (key.isEmpty()){
                    filteredBookList = bookList;
                } else {
                    List<Book> fltBookList = new ArrayList<>();
                    for (Book book: bookList){
                        if (book.getTitle().toUpperCase().startsWith(key.toUpperCase())){
                            fltBookList.add(book);
                        }
                    }
                    filteredBookList = fltBookList;
                }
                FilterResults filterResults = new FilterResults();
                Log.d(TAG, "filteredBookList is empty: " + filteredBookList);
                filterResults.values = filteredBookList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence sequence, FilterResults results) {
                filteredBookList = (List<Book>) results.values;
                System.out.println(filteredBookList);
                notifyDataSetChanged();
            }
        };
    }
}
