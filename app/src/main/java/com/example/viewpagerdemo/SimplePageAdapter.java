package com.example.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SimplePageAdapter extends FragmentStatePagerAdapter {

	private List<Fragment> fragments;

	public SimplePageAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}
	
//	public void addFragment(int i,ArrayList<Model> modelList){
//		GridFragment  gf=GridFragment.newInstance(i,modelList);
//		fragments.add(gf);
//	}
//
//
	

}
