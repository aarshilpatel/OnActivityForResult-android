package com.example.aarshil.onactivityforresult;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class MyPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;
    FragmentManager supportFragmentManager;

    public MyPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);

        this.tabCount = tabCount;
        this.supportFragmentManager = supportFragmentManager;

    }

    @Override
    public Fragment getItem(int position) {

       switch (position){

           case 0:
               HomeFragment homeFragment = new HomeFragment();
               return homeFragment;

           case 1:
               GalleryFragment galleryFragment = new GalleryFragment();
               return galleryFragment;

           case 2:
               SlideshowFragment slideshowFragment = new SlideshowFragment();
               return slideshowFragment;

               default:
                   return null;

       }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

