package com.example.expense_manager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

	private Context _context;
	public static int totalPage=4;
	public PagerAdapter(Context context, FragmentManager fm) {
		super(fm);	
		_context=context;
}
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
            break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
