package com.smidigprosjekt.matias.smidigprosjektgruppe2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
        loadFragment(new Home_fragment());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.bottombaritem_home:
                    toolbar.setTitle("Home");
                    fragment = new Home_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.bottombaritem_groups:
                    toolbar.setTitle("Group");
                    fragment = new Group_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.bottombaritem_chat:
                    toolbar.setTitle("Chat");
                    fragment = new Chat_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.bottombaritem_notifications:
                    toolbar.setTitle("Notifications");
                    fragment = new Notification_fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.bottombaritem_drawermenu:
                    toolbar.setTitle("Menu");
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
