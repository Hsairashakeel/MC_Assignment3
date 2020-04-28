package com.example.assign3;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import android.view.View;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    Context context;

    private ArrayList<String> title;
    private ArrayList<String> level;
    private ArrayList<String> info;
    private ArrayList<String> imgid;
    private ArrayList<String> bookBtn;
    public RVAdapter(Context context, ArrayList<String> title, ArrayList<String> level, ArrayList<String> info, ArrayList<String> imgid, ArrayList<String> bookUrl) {

        this.context = context;

        this.imgid = new ArrayList<String>(imgid.size());
        for (String i : imgid) {
            this.imgid.add(new String(i));
        }
        this.title = new ArrayList<String>(title.size());
        for (String i : title) {

            this.title.add(new String(i));
        }
        this.level = new ArrayList<String>(level.size());
        for (String i : level) {
            this.level.add(new String(i));
        }
        this.info = new ArrayList<String>(info.size());
        for (String i : info) {

            this.info.add(new String(i));
        }


        this.bookBtn = new ArrayList<String>(bookUrl.size());
        for (String i : bookUrl) {
            this.bookBtn.add(new String(i));
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.list_items, null);
        ViewHolder holder = new ViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_title.setText(title.get(position));
        holder.tv_level.setText(level.get(position));
        holder.tv_info.setText(info.get(position));
        Picasso.with(context).load("https://raw.githubusercontent.com/revolunet/PythonBooks/master/" + imgid.get(position)).into(holder.image);
        String a = bookBtn.get(position);
        String asub = a.substring(a.length() - 3, a.length());
        if (asub.equals("zip") || asub.equals("pdf")) {
            holder.btn_book.setText("DOWNLOAD");
        } else {
            holder.btn_book.setText("READ ONLINE");
        }


    }
    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title;
        public TextView tv_level;
        public TextView tv_info;
        public ImageView image;
        public Button btn_book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.title);
            tv_level = itemView.findViewById(R.id.level);
            tv_info = itemView.findViewById(R.id.info);
            image = itemView.findViewById(R.id.imageView);
            btn_book = itemView.findViewById(R.id.button);
        }
    }

}





