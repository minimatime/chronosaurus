package com.example.chronosaurus;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// AssignmentDao.java
@Dao
public interface AssignmentDao {
    @Insert
    void insert(Assignment assignment);

    @Update
    void update(Assignment assignment);

    @Delete
    void delete(Assignment assignment);

    @Query("SELECT * FROM assignments ORDER BY dueDate")
    LiveData<List<Assignment>> getAllAssignmentsByDueDate();

    @Query("SELECT * FROM assignments ORDER BY associatedClass")
    LiveData<List<Assignment>> getAllAssignmentsByClass();
}
