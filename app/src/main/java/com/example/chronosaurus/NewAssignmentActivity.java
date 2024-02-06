package com.example.chronosaurus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NewAssignmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_assignment);

        // Add Assignment button click listener
        findViewById(R.id.addAssignment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addAssignment:
                // Handle the add assignment button click
                // Get data from EditText fields and save it to database or perform necessary action
                break;

            // Add more cases if there are other clickable views in your layout
        }
    }
}
