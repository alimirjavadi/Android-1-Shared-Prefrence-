package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2, editTextResult;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtname = findViewById(R.id.name);
        EditText edtfamily = findViewById(R.id.family);
        Button btn = findViewById(R.id.btn);

        SharedPreferences dpuser = getSharedPreferences("mydb" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = dpuser.edit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String sname = edtname.getText().toString().trim();
                    String sfamily = edtfamily.getText().toString().trim();
                    editor.putString("name" , sname);
                    editor.putString("family" , sfamily);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "اطلاعات با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}
