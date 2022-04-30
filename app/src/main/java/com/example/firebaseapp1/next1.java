package com.example.firebaseapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class next1 extends AppCompatActivity {

    Button show;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);

        show = findViewById(R.id.buttonShow);
        list = findViewById(R.id.list);

        show.setOnClickListener(v->
        {
            ArrayList arrayList = new ArrayList();
            ArrayAdapter adapter = new ArrayAdapter<String>(next1.this,R.layout.items,arrayList);
            list.setAdapter(adapter);

//            FirebaseDatabase.getInstance().getReference() // by this line we have access to database
         // addValueEventListener implementation:
//            FirebaseDatabase.getInstance().getReference().child("users").child("").addValueEventListener(new ValueEventListener() { // to access multiple child
//            FirebaseDatabase.getInstance().getReference().child("users").addListenerForSingleValueEvent(new ValueEventListener() { //single-valueEventListener
            FirebaseDatabase.getInstance().getReference().child("users").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot.exists()){
                        arrayList.clear();
                        for (DataSnapshot snapshot1:snapshot.getChildren())
                        {
                            //iterate data from database & then store in the i & then in t variable.
                            users i = snapshot1.getValue(users.class);
                            String t = i.getName()+" : "+i.getAge();
                            arrayList.add(t);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }
}