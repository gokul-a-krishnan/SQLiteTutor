package com.example.sqlitetutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements HomeFragment.DbOperationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null){
            if (savedInstanceState != null){
                return;
            }
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homeFragment).commit();
        }
    }

    @Override
    public void DbOperationPerformed(int method) {
        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddContactFragment()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ViewContactFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UpdateContactFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DeleteContactFragment()).addToBackStack(null).commit();
                break;
        }
    }
}