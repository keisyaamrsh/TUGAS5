package com.example.tugas5;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name, country, age;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

            DB = new DBHelper(this);
            name = new ArrayList<>();
            country = new ArrayList<>();
            age = new ArrayList<>();
            recyclerView = findViewById(R.id.recylerview);
            adapter = new MyAdapter(this, name, country, age);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata();

        if (cursor.getCount()==0)
        {
            Toast.makeText(Userlist.this, "No Entry Exist", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                country.add(cursor.getString(1));
                age.add(cursor.getString(2));

            }
        }
    }
}