package com.example.chronosaurus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AssignmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AssignmentAdapter adapter;
    private List<Assignment> assignments; // Assuming you have this list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        recyclerView = findViewById(R.id.AssignmentRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Instantiate the list of assignments (populate it with data as needed)
        assignments = new ArrayList<>();
        // Populate assignments list with data

        // Initialize the adapter with the list of assignments
        adapter = new AssignmentAdapter(assignments);
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
