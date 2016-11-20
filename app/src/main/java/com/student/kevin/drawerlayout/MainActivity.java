package com.student.kevin.drawerlayout;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private Button mShowNextPage;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle("Kevin");
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show back button and make it enabled
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mShowNextPage = (Button) findViewById(R.id.btn_next_page);
        mShowNextPage.setOnClickListener(this);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_layout_open, R.string.drawer_layout_close);
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mActionBarDrawerToggle.setHomeAsUpIndicator(R.mipmap.ic_launcher);//channge the icon
        mActionBarDrawerToggle.syncState();//show the default icon and sync the DrawerToggle state
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mDrawerLayout.setStatusBarBackgroundColor(ContextCompat.getColor(this, R.color.green));//set background color for status bar

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_next_page) {
            startActivity(new Intent(MainActivity.this, NextActivity.class));
        }
    }
}
