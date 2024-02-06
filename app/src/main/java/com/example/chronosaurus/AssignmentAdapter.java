package com.example.chronosaurus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {

    private List<Assignment> assignments;
    private Context context; // Add this context variable

    // Constructor to initialize assignments list
    public AssignmentAdapter(Context context, List<Assignment> assignments) {
        this.context = context;
        this.assignments = assignments;
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_layout, parent, false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }


    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Assignment assignment = assignments.get(position);
        holder.bind(assignment);

        // Handle options click
        holder.optionsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a popup menu to choose edit, remove, or mark as complete
                showPopupMenu(v, assignment);
            }
        });
    }

    private void showPopupMenu(View view, Assignment assignment) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.inflate(R.menu.assignment_options_menu); // Create a menu resource file
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.edit) {
                    // Implement edit functionality
                } else if (itemId == R.id.remove) {
                    // Implement remove functionality
                } else if (itemId == R.id.mark_complete) {
                    // Implement mark as complete functionality
                }
                return true;
            }

        });
        popupMenu.show();
    }

    // Other methods...

    public static class AssignmentViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView associatedClassTextView;
        private TextView detailsTextView;
        private ImageView optionsImageView; // Define optionsImageView

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            associatedClassTextView = itemView.findViewById(R.id.associatedClass);
            detailsTextView = itemView.findViewById(R.id.details);
            optionsImageView = itemView.findViewById(R.id.options); // Initialize optionsImageView
        }

        public void bind(Assignment assignment) {
            titleTextView.setText(assignment.getTitle());
            associatedClassTextView.setText(assignment.getAssociatedClass());
            detailsTextView.setText(assignment.getDetails());
            // Add more bindings as per your requirement
        }
    }
}
