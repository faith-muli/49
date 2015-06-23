package com.example.faith.hairme;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Salons","Hairstyles"};
    int NumofTabs =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating toolbar

        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        //adapter that passes fragments to main activity

        adapter= new ViewPagerAdapter(getSupportFragmentManager(),Titles,NumofTabs);

        //assigning viewpager view and setting adapter

        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //assigning sliding tab layout view
        tabs=(SlidingTabLayout)findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        //setting collor for scroll bar
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer(){


            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScollColor);
            }
        });
        //setting viewpager for sliding pager
        tabs.setViewPager(pager);

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
