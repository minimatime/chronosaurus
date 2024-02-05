package com.example.chronosaurus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.chronosaurus.Assignment;
import com.example.chronosaurus.AssignmentRepository;

import java.util.List;

// AssignmentViewModel.java
public class AssignmentViewModel extends ViewModel {
    private final AssignmentRepository repository;

    public AssignmentViewModel(AssignmentRepository repository) {
        this.repository = repository;
    }

    public void insert(Assignment assignment) {
        repository.insert(assignment);
    }

    public void update(Assignment assignment) {
        repository.update(assignment);
    }

    public void delete(Assignment assignment) {
        repository.delete(assignment);
    }

    public LiveData<List<Assignment>> getAllAssignmentsByDueDate() {
        return repository.getAllAssignmentsByDueDate();
    }

    public LiveData<List<Assignment>> getAllAssignmentsByClass() {
        return repository.getAllAssignmentsByClass();
    }
}
