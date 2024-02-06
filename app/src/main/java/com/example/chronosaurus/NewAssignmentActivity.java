package com.example.chronosaurus;

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
        Button addAssignmentButton = findViewById(R.id.addAssignment);
        addAssignmentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Handle onClick event for the views
        if (v.getId() == R.id.addAssignment) {
            // Add Assignment button clicked
            // Handle the button click event here
        }
        // Add more if-else blocks if you have more views with onClickListener
    }

}
