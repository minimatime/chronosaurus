package com.example.chronosaurus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewAssignmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_assignment);

        // Find your views and set onClickListener
        Button addAssignmentButton = findViewById(R.id.addAssignment2);
        addAssignmentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Handle onClick event for the views
        if (v.getId() == R.id.addAssignment2) {

            // Add Assignment button clicked
            findViewById(R.id.addAssignment2).setOnClickListener(vi -> {
                Intent intent = new Intent(NewAssignmentActivity.this, AssignmentActivity.class);
                startActivity(intent);
            });
            // Handle the button click event here
        }
        // Add more if-else blocks if you have more views with onClickListener
    }

}
