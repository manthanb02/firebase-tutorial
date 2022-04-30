package com.example.firebaseapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class NextActivity extends AppCompatActivity
{
    private EditText name , age;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);


        name = findViewById(R.id.editTextName);
        age = findViewById(R.id.editTextAge);
        add = findViewById(R.id.buttonAdd);

        add.setOnClickListener(v->
        {
            // creating an instance for firebase database using firebaseDatabase class
            //FirebaseDatabase.getInstance().getReference().child("vendor1").setValue("Ram");

            // code to add data in firebase realtime database.
            HashMap<String,Object>m = new HashMap<String,Object>();
            m.put("name",name.getText().toString());
            m.put("age",age.getText().toString());
//            FirebaseDatabase.getInstance().getReference().child("user1").setValue(m);
            //above function will update the existing data everytime you add new info of new user ; to avoid this & add every user's data  separately use following code:
            FirebaseDatabase.getInstance().getReference().child("users").push().setValue(m);

        });

    }
}