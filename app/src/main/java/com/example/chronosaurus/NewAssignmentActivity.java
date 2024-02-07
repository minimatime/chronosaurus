package com.example.chronosaurus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewAssignmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_assignment);

        EditText titleEditText = findViewById(R.id.addTitle);
        EditText dueDateEditText = findViewById(R.id.addDueDate);
        EditText classEditText = findViewById(R.id.addAssociatedClass);
        EditText detailsEditText = findViewById(R.id.addDetails);

        Button addAssignmentButton = findViewById(R.id.addAssignment2);
        addAssignmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Assignment object
                Assignment assignment = new Assignment();

                // Set assignment details from EditText fields
                assignment.setTitle(titleEditText.getText().toString());
                assignment.setTitle(dueDateEditText.getText().toString());
                assignment.setAssociatedClass(classEditText.getText().toString());
                assignment.setDetails(detailsEditText.getText().toString());

                // Add the new assignment to the list in AssignmentActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("assignment", assignment);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
