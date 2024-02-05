package com.example.chronosaurus;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Assignment.java
@Entity(tableName = "assignments")
public class Assignment {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String title;
    public String dueDate;
    public String associatedClass;
    // Add other fields as needed
}

