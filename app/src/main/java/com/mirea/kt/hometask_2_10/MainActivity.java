package com.mirea.kt.hometask_2_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextModel,editTextNumber,editTextYear;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbManager=new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));
        editTextModel=findViewById(R.id.etModel);
        editTextNumber=findViewById(R.id.etNumber);
        editTextYear=findViewById(R.id.etYear);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnShowCar = findViewById(R.id.btnShowCar);
        btnAdd.setOnClickListener(this);
        btnShowCar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnAdd){
            if(this.dbManager!=null){
                String model = editTextModel.getText().toString();
                String number = editTextNumber.getText().toString();
                String year = editTextYear.getText().toString();
                if(!model.isEmpty() && !number.isEmpty() && !year.isEmpty()){
                    boolean result = dbManager.saveCarsToDatabase(new Car(model, number,Integer.parseInt(year)));
                    if (result){
                        Toast.makeText(this, R.string.insert_success,Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this,R.string.insert_error,Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this,R.string.incorrect_value,Toast.LENGTH_LONG).show();
                }
            }
        }else if (v.getId()==R.id.btnShowCar){
            startActivity(new Intent(this,CarActivity.class));
        }
    }
}