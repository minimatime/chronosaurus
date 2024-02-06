package com.example.chronosaurus;

import static com.example.chronosaurus.R.id.scheduler;

import android.content.Intent;
import android.os.Bundle;

import com.example.chronosaurus.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chronosaurus.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private AppBarConfiguration appBarConfiguration;
    //private ActivityMainBinding binding;

    EditText username;
    EditText year;
    Button submit;
    FloatingActionButton addClass;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        username = findViewById(R.id.username);
        year = findViewById(R.id.classYear);
        submit = findViewById(R.id.loginButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                Toast.makeText(MainActivity.this, "Welcome, " + name, Toast.LENGTH_SHORT).show();
                setContentView(R.layout.fragment_schedule);
                addClass = findViewById(R.id.fab);

//                binding = ActivityMainBinding.inflate(getLayoutInflater());
//                setContentView(binding.getRoot());
//
//                replaceFragment(new ScheduleFragment());
//                binding.bottomNavView.setBackground(null);
//
//                binding.bottomNavView.setOnItemSelectedListener(item -> {
//                    switch (item.getItemId()) {
//                        case R.id.scheduler:
//                            replaceFragment(new ScheduleFragment());
//                            break;
//
//                        case R.id.assignments:
//                            //placeholder for actual fragments
//                            //replaceFragment(new ScheduleFragment());
//                            break;
//
//                        case R.id.tasks:
//                            //placeholder for actual fragments
//                            //replaceFragment(new ScheduleFragment());
//                            break;
//                    }
//                });

                RecyclerView recyclerView;
                List<DataClass> dataList;
                DatabaseReference databaseReference;
                //ValueEventListener valueEventListener;
                recyclerView = findViewById(R.id.recyclerView);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
                recyclerView.setLayoutManager(gridLayoutManager);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setView(R.layout.progress_layout);
                AlertDialog dialog = builder.create();
                dialog.show();

                dataList = new ArrayList<>();

                MyAdapter adapter = new MyAdapter(MainActivity.this, dataList);
                recyclerView.setAdapter(adapter);

                databaseReference = FirebaseDatabase.getInstance().getReference("chronosaurus");
                dialog.show();

                valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        dataList.clear();
                        for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                            DataClass dataClass = itemSnapshot.getValue(DataClass.class);
                            dataClass.setKey(itemSnapshot.getKey());
                            dataList.add(dataClass);
                        }
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        dialog.dismiss();
                    }
                });

                addClass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}