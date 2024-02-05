package com.example.chronosaurus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

// AlarmActivity.java
public class AlarmActivity extends AppCompatActivity {
    private AssignmentViewModel assignmentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        assignmentViewModel = new ViewModelProvider(this).get(AssignmentViewModel.class);

        // Use assignmentViewModel to interact with the data
    }
}
