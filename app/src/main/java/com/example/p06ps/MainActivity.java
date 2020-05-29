package com.example.p06ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Note> note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        DBHelper db = new DBHelper(MainActivity.this);
        note = db.getAllNotes();

        aa = new ArrayAdapter(this, R.layout.row, note);
        lv.setAdapter(aa);



        btnAdd = findViewById(R.id.btnAddNext);
        lv = findViewById(R.id.lv);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
            }
        });

    }
}
