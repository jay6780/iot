package com.cea.cea_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayFragment extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private TextView display_temp, display_hum, display_light, display_soil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fragment);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        drawerLayout = findViewById(R.id.drawer_layout);
        display_temp = findViewById(R.id.dis_temp);
        display_hum = findViewById(R.id.dis_hum);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference temp_ref = database.getReference("Sensor/Temperature");
        DatabaseReference hum_ref = database.getReference("Sensor/Humidity");

        //Read temperature data from firebase
        temp_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Double doubleValue = snapshot.getValue(Double.class);
                    if (doubleValue != null) {
                        String stringValue = String.valueOf(doubleValue);
                        Log.d("Firebase","Temperature exits");
                        display_temp.setText(stringValue + "%");
                        // Now you can use stringValue as a String.
                    }
                }else {
                    Log.d("Firebase", "Temperature data doesn't exist.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Firebase", "Failed to read temperature value.", error.toException());
            }
        });

        //Read humidity data from firebase
        hum_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Double doubleValue = snapshot.getValue(Double.class);
                    if (doubleValue != null) {
                        String humstringVal = String.valueOf(doubleValue);
                        display_hum.setText(humstringVal + "%");
                        // Now you can use stringValue as a String.
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Firebase", "Failed to read humidity value.", error.toException());
            }
        });



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_display: {
                        Toast.makeText(getApplicationContext(),"Nav display", Toast.LENGTH_SHORT).show();
                        break;
                    }


                    case R.id.nav_control: {
                        Toast.makeText(getApplicationContext(),"Nav control", Toast.LENGTH_SHORT).show();
                        break;
                    }


                    case R.id.nav_img_classify: {
                        Toast.makeText(getApplicationContext(),"Nav img classify", Toast.LENGTH_SHORT).show();
                        break;
                    }


                    case R.id.nav_logout: {
                        Toast.makeText(getApplicationContext(),"Nav logout", Toast.LENGTH_SHORT).show();
                        break;
                    }




                }
                return false;

            }
        });



    }




    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}