package com.example.firebaseapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;
    private Button login;
    private FirebaseAuth auth;//for authentication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editTextEmailLogin);
        password = findViewById(R.id.editTextPasswordLogin);
        login = findViewById(R.id.buttonLogin);

        auth = FirebaseAuth.getInstance();//for authentication

        login.setOnClickListener(v->{
            //for authentication
            String email2 = email.getText().toString();
            String password2 = password.getText().toString();
            if(TextUtils.isEmpty(email2) || TextUtils.isEmpty(password2)){
                Toast.makeText(this, "fill both fields", Toast.LENGTH_SHORT).show();
            }
            else {
                login(email2,password2);
            }
        });
    }
    //for authentication
    private void login(String email , String password){

        //to sign in users
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(LoginActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
//                Toast.makeText(LoginActivity.this, "Login Succesful..!", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(LoginActivity.this,NextActivity.class)); //intent for nextActivity
                startActivity(new Intent(LoginActivity.this,next1.class));//intent for next1
                finish();
            }
        });
    }
}