package com.example.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

public class MainActivity extends FragmentActivity {

	private ViewPager vp;
	private List<Fragment> fragments;
	private SimplePageAdapter pageAdapter;
	/**
	 *存储照片的数组和位置
	 */
	private int[] imgId = new int[] {
			R.drawable.pic01,
			R.drawable.pic02,
			R.drawable.pic03,
			R.drawable.pic04,
			R.drawable.pic05
	};

	/**
	 * 传递的数据
	 */
	private ArrayList<Model> modelList;

	/**
	 * 一共有多少页
	 */
	private int pageCount = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vp = (ViewPager) findViewById(R.id.viewpager);
		fragments = new ArrayList<Fragment>();

		initData();
		pageCount = modelList.size();

		for (int pos = 0; pos < pageCount; pos++) {
			//初始化每一个fragment
			GridFragment gf = GridFragment.newInstance(pos, modelList);
			fragments.add(gf);
		}

		//初始化pageAdapter
		pageAdapter = new SimplePageAdapter(getSupportFragmentManager(),
				fragments);

		vp.setAdapter(pageAdapter);

		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
//				Log.i("tag", "当前shiiiiiiiiiiiiiiiiiiiiiiiiiionPageSelected哦");
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
//				Log.i("tag", "当前shiiiiiiiiiiiiiiiiiiionPageScrolled哦");
//				System.out.println("MotionEvent--ACTION_POINTER_DOWN---");
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		modelList = new ArrayList<Model>();

		for (int page = 0; page < pageCount; page++) {
			Model model = new Model(imgId[page]);
			modelList.add(model);
		}
	}

}
