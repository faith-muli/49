package com.example.faith.hairme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by faith on 5/26/15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    CharSequence Titles [];
    int NumofTabs;

    public ViewPagerAdapter( FragmentManager fm,CharSequence mTitles[], int mNumofTabsumb){
        super(fm);
        this.Titles=mTitles;
        this.NumofTabs=mNumofTabsumb;



    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            SalonPage salonPage = new SalonPage();
            return salonPage;
        }
        else {
            HairstylePage stylePage = new HairstylePage();
            return stylePage;
        }
    }
    public CharSequence getPageTitle(int position){
        return Titles[position];
    }
    @Override
    public int getCount() {
        return NumofTabs;
    }
}
