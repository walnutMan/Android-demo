package com.example.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridFragment extends Fragment implements View.OnTouchListener{

	private View view;
	private ImageView img;
	private int pos = -1;
	private FragmentActivity context;
	private List<Model> modelList;



	public static GridFragment newInstance(int pos, ArrayList<Model> modelList) {
		GridFragment gf = new GridFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("pos", pos);
        System.out.println("newInstance---newInstance:" + pos);
		bundle.putParcelableArrayList("model", modelList);
		gf.setArguments(bundle);
		return gf;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//        Log.i("tag", "当前shiiiiiiiiiiiiiiiiiiiiiiiiiionCreateView哦");

		if (view == null) {
            Log.i("tag", "当前页数是" + (pos + 1) + ",view是null哦");
			context = getActivity();
			Bundle bundle = getArguments();
			pos = bundle.getInt("pos");
			modelList = bundle.getParcelableArrayList("model");
			view = LayoutInflater.from(context).inflate(R.layout.fragment_grid,container, false);
			img = (ImageView) view.findViewById(R.id.imgView);
            img.setImageResource(modelList.get(pos).getResId());
			img.setOnTouchListener(this);
        } else {
//			Log.i("tag", "当前页数是" + (pos + 1) + ",view不不不是null哦");
			ViewGroup root = (ViewGroup) view.getParent();
			if (root != null) {
				root.removeView(view);
			}
		}

		Log.i("tag", "当前页数是" + (pos + 1));

		return view;
	}
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		switch (event.getAction() & MotionEvent.ACTION_MASK) {


			case MotionEvent.ACTION_DOWN:
				System.out.println("MotionEvent--ACTION_DOWN");
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				System.out.println("MotionEvent--ACTION_POINTER_DOWN---");

				break;
			case MotionEvent.ACTION_UP:
				System.out.println("MotionEvent--ACTION_UP");

				break;
			case MotionEvent.ACTION_POINTER_UP:
				System.out.println("MotionEvent--ACTION_POINTER_UP");


				break;
			case MotionEvent.ACTION_MOVE:
				System.out.println("MotionEvent--ACTION_MOVE");

				break;
		}
		return true;
	}



}
