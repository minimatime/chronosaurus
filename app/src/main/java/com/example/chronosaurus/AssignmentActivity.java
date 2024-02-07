package com.example.chronosaurus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class AssignmentActivity extends AppCompatActivity implements AssignmentAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private AssignmentAdapter adapter;
    private List<Assignment> assignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        recyclerView = findViewById(R.id.AssignmentRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        assignments = new ArrayList<>();
        adapter = new AssignmentAdapter(this, assignments);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        // Add Assignment button click listener
        findViewById(R.id.addAssignment).setOnClickListener(v -> {
            Intent intent = new Intent(AssignmentActivity.this, NewAssignmentActivity.class);
            startActivityForResult(intent, 1); // Start activity for result
        });
    }

    // Handle the result from NewAssignmentActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Assignment assignment = (Assignment) data.getSerializableExtra("assignment");
            assignments.add(assignment);
            adapter.notifyDataSetChanged();
        }
    }

    // Create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return true;
    }

    // Handle options menu item selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.sort_by_due_date) {
            // Sort assignments by due date
            Collections.sort(assignments, new Comparator<Assignment>() {
                @Override
                public int compare(Assignment a1, Assignment a2) {
                    return a1.getDueDate() - a2.getDueDate();
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        } else if (itemId == R.id.sort_by_associated_class) {
            // Sort assignments by associated class
            Collections.sort(assignments, new Comparator<Assignment>() {
                @Override
                public int compare(Assignment a1, Assignment a2) {
                    return a1.getAssociatedClass().compareTo(a2.getAssociatedClass());
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Handle item click from the adapter
    @Override
    public void onItemClick(View view, int position) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.assignment_options_menu);
        popupMenu.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.edit) {
                // Implement edit functionality
                // You can navigate to NewAssignmentActivity with data of selected assignment
            } else if (itemId == R.id.delete) {
                // Implement delete functionality
                assignments.remove(position);
                adapter.notifyItemRemoved(position);
            } else if (itemId == R.id.mark_complete) {
                // Implement mark as complete functionality
                adapter.markAsComplete(position);
            }
            return true;
        });
        popupMenu.show();
    }
}
