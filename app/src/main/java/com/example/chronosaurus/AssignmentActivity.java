package com.example.chronosaurus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        AssignmentAdapter adapter = new AssignmentAdapter(this, assignments);
        recyclerView.setAdapter(adapter);

        // Add Assignment button click listener
        findViewById(R.id.addAssignment).setOnClickListener(v -> {
            Intent intent = new Intent(AssignmentActivity.this, NewAssignmentActivity.class);
            startActivity(intent, savedInstanceState);
        });

    }
    // Add sorting options (e.g., in onCreateOptionsMenu)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return true;
    }

    // Handle sorting option selected (e.g., in onOptionsItemSelected)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.sort_by_due_date) {
            // Sort assignments by due date
            Collections.sort(assignments, new Comparator<Assignment>() {
                @Override
                public int compare(Assignment a1, Assignment a2) {
                    // Compare due dates
                    // Implement comparison logic based on due dates
                    return 0; // Return the result of comparison
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        } else if (itemId == R.id.sort_by_associated_class) {
            // Sort assignments by associated class
            Collections.sort(assignments, new Comparator<Assignment>() {
                @Override
                public int compare(Assignment a1, Assignment a2) {
                    // Compare associated classes
                    // Implement comparison logic based on associated classes
                    return 0; // Return the result of comparison
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


}
