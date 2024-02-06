package com.example.chronosaurus;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AssignmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AssignmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        recyclerView = findViewById(R.id.AssignmentRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AssignmentAdapter(); // Implement AssignmentAdapter
        recyclerView.setAdapter(adapter);

        // Add Assignment button click listener
        findViewById(R.id.addAssignment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignmentActivity.this, NewAssignmentActivity.class);
                startActivity(intent);
            }
        });
    }
}
