package com.example.chronosaurus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {

    private List<Assignment> assignments;

    // Constructor to initialize assignments list
    public AssignmentAdapter(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_layout, parent, false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Assignment assignment = assignments.get(position);
        holder.bind(assignment);
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    public class AssignmentViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView associatedClassTextView;
        private TextView detailsTextView;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            associatedClassTextView = itemView.findViewById(R.id.associatedClass);
            detailsTextView = itemView.findViewById(R.id.details);
        }

        public void bind(Assignment assignment) {
            titleTextView.setText(assignment.getTitle());
            associatedClassTextView.setText(assignment.getAssociatedClass());
            detailsTextView.setText(assignment.getDetails());
            // Add more bindings as per your requirement
        }
    }
}
