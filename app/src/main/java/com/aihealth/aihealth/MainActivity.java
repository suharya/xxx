package com.aihealth.aihealth;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dr;
    private Toolbar tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawer
        tl = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tl);
        ProsesNavigasi();
        //close drawer
        Button btnsu = (Button)  findViewById(R.id.buttonsu);

        btnsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent su = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(su);


            }
        });

        Button btnsi = (Button)  findViewById(R.id.buttonsi);

        btnsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent si = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(si);
            }
        });
    }

    // drawer declare
    public void ProsesNavigasi() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        break;
                    case R.id.settings:
                        Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.trash:
                        Toast.makeText(getApplicationContext(), "Petunjuk", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        break;
                    case R.id.buttonsi:
                        Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                        dr.closeDrawers();
                        break;


                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.tv_email);
        //tv_email.setText("Ridwan, S.ST");
        dr = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dr, tl, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        dr.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        }

}

