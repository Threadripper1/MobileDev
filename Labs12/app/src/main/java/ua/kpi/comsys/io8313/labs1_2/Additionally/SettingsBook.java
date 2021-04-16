package ua.kpi.comsys.io8313.labs1_2.Additionally;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ua.kpi.comsys.io8313.labs1_2.R;
import ua.kpi.comsys.io8313.labs1_2.resource.Books.Book;

public class SettingsBook extends RecyclerView.Adapter<SettingsBook.BookViewHolder> {
    private LayoutInflater inflater;
    private final List<Book> bookList;

    public SettingsBook(Context context, List<Book> bookList) {
        this.bookList = bookList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.book_list_item, viewGroup, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsBook.BookViewHolder holder, int position) {
        Book book = bookList.get(position);
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
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        protected ImageView bookImageView;
        protected TextView bookSubtitleTextView;
        protected TextView bookTitleTextView;
        protected TextView bookPriceTextView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            this.bookImageView = itemView.findViewById(R.id.bookImageView);
            this.bookPriceTextView = itemView.findViewById(R.id.bookPriceTextView);
            this.bookSubtitleTextView = itemView.findViewById(R.id.bookSubtitleTextView);
            this.bookTitleTextView = itemView.findViewById(R.id.bookTitleTextView);
        }
    }
}
