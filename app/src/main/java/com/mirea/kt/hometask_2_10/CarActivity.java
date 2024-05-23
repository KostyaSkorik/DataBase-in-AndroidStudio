package com.mirea.kt.hometask_2_10;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        DBManager dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));
        RecyclerView rcView = findViewById(R.id.recyclerView);
        CarAdapter adapter = new CarAdapter(dbManager.loadAllCarsFromDatabase());
        rcView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcView.setAdapter(adapter);
    }
}