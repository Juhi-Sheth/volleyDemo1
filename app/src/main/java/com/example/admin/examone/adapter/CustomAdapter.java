package com.example.admin.examone.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.examone.MainActivity;
import com.example.admin.examone.R;
import com.example.admin.examone.fragments.ALLFragment;
import com.example.admin.examone.fragments.AlertFragment;
import com.example.admin.examone.fragments.SocialFragment;

/**
 * Created by Admin on 23-02-2018.
 */

public class CustomAdapter extends FragmentPagerAdapter{
    private final Context context;

    public CustomAdapter(Context context, FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new ALLFragment();
        }
        else if (position==1){
            return new SocialFragment();
        }
        else if (position==2){
            return new AlertFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getString(R.string.all);
            case 1:
                return context.getString(R.string.social);
            case 2:
                return context.getString(R.string.alert);
            default:
                return null;
        }
    }
}
