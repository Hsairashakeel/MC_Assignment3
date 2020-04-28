package com.example.assign3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> level = new ArrayList<>();
    ArrayList<String> info = new ArrayList<>();
    ArrayList<String> image= new ArrayList<>();
    ArrayList<String> btnClick= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv= (RecyclerView) findViewById(R.id.rec_view);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        try {
            JSONObject obj = new JSONObject(getJSONobject());
            JSONArray bookData = obj.getJSONArray("books");
            for (int i = 0; i < bookData.length(); i++) {
                JSONObject bookDetail = bookData.getJSONObject(i);
                title.add(bookDetail.getString("title"));
                level.add(bookDetail.getString("level"));
                info.add(bookDetail.getString("info"));
                image.add(bookDetail.getString("cover"));
                btnClick.add(bookDetail.getString("url"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        RVAdapter adapter = new RVAdapter(this, title, level,info);
//
//        rv.setAdapter(adapter);
    }
    public String getJSONobject() {
        String jsonData = "";
        try {

            InputStream is = getResources().openRawResource(R.raw.issues);
            byte[] data = new byte[is.available()];
            while (is.read(data)!=-1){
            }
            jsonData = new String(data);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return jsonData;
    }


    }

