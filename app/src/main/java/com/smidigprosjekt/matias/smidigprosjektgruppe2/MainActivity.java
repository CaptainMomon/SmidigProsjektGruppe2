package com.smidigprosjekt.matias.smidigprosjektgruppe2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Home");
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottombaritem_home:
                    toolbar.setTitle("Home");
                    return true;
                case R.id.bottombaritem_groups:
                    toolbar.setTitle("Group");
                    return true;
                case R.id.bottombaritem_chat:
                    toolbar.setTitle("Chat");
                    return true;
                case R.id.bottombaritem_notifications:
                    toolbar.setTitle("Notifications");
                    return true;
                case R.id.bottombaritem_drawermenu:
                    toolbar.setTitle("Menu");
                    return true;
            }
            return false;
        }
    };


}
