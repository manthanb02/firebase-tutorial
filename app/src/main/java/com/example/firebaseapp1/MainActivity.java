package com.example.firebaseapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button register , login;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register = findViewById(R.id.registerButton);
        login = findViewById(R.id.loginButton);

        register.setOnClickListener(v->{
//            intent = new Intent(MainActivity.this,RegisterActivity.class);
//            startActivity(intent);
//            finish();

//            Or
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));

        });

        login.setOnClickListener(v->{
//            intent = new Intent(MainActivity.this,LoginActivity.class);
//            startActivity(intent);
//            finish();

//            or
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        });

    }
}