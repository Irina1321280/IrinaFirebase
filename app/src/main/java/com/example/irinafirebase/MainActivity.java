package com.example.irinafirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("concert");

        Intent intent = new Intent(this, ListItems.class);
        findViewById(R.id.viewRecord).setOnClickListener(v -> startActivity(intent));

        EditText name = findViewById(R.id.Name);
        EditText date = findViewById(R.id.Date);
        EditText price = findViewById(R.id.Price);

        findViewById(R.id.addRecord).setOnClickListener(v -> {
            myRef.push().setValue(new Concert(name.getText().toString(),
                    date.getText().toString(),
                    Integer.parseInt(price.getText().toString()))).addOnCompleteListener(task -> {
                name.setText("");
                date.setText("");
                price.setText("");
            });
            Toast.makeText(MainActivity.this, "Данные добавлены!", Toast.LENGTH_LONG).show();
        });
    }
}