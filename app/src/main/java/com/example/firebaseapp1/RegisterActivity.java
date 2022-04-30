package com.example.firebaseapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

     private EditText email,password;
     private Button register;
     private FirebaseAuth auth;//for authentication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        register = findViewById(R.id.buttonRegister);
        auth = FirebaseAuth.getInstance();//for authentication

        register.setOnClickListener(v->{
            //for authentication
            String email1 = email.getText().toString();
            String password1 = password.getText().toString();

            if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)){
                Toast.makeText(this, "Fill both fields", Toast.LENGTH_SHORT).show();
            }
            else{
                regis(email1,password1);
            }
        });
    }

    //for authentication
    private  void regis(String email , String password){
        // to register users
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "successfully registered", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                
            }
        });
    }

}