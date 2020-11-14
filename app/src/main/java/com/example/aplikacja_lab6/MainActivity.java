package com.example.aplikacja_lab6;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        final Kolorki kolorki = new ViewModelProvider(this).get(Kolorki.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int randomColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)); ;

                if (findViewById(R.id.constraint_layout1) != null){
                    kolorki.kolorki_layout1.setValue(randomColor);
                }
                if (findViewById(R.id.constraint_layout2) != null){
                    kolorki.kolorki_layout2.setValue(randomColor);
                }
                if (findViewById(R.id.constraint_layout3) != null){
                    kolorki.kolorki_layout3.setValue(randomColor);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action1:
                navController.navigate(R.id.FirstFragment);
            break;
            case R.id.action2:
                navController.navigate(R.id.SecondFragment);
            break;
            case R.id.action3:
                navController.navigate(R.id.thirdFragment);
            break;
        }

        return super.onOptionsItemSelected(item);
    }
}