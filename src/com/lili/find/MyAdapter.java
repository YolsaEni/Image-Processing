package com.lili.find;


import java.util.Random;

import zst.lili.view.CircleButton;
import zst.lili.view.SimpleViewHolder;
import lili.beauty.find.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	private final LayoutInflater mInflater;
	private final String[] chs;
	int color=0;
	public MyAdapter(Activity c,String[] chs) {
		mInflater = c.getLayoutInflater();
		this.chs = chs;
	}
	
	public int getCount() {
		return chs.length;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// convert view = design
		View v = convertView;
		SimpleViewHolder holder;
		if (v == null) {
			holder = new SimpleViewHolder();
			v = mInflater.inflate(R.layout.listitem, parent,false);
			holder.setSelectIv((ImageView) v.findViewById(R.id.select_iv));
			holder.setSelectTv((TextView) v.findViewById(R.id.select_tv));
			v.setTag(holder);
		} else {
			holder = (SimpleViewHolder) v.getTag();
		}
		holder.getSelectTv().setText(chs[position]);
		Random rand = new Random();
		color=rand.nextInt();
		((CircleButton)holder.getSelectIv()).setColor(color);
		return v;
	}


	@Override
	public Object getItem(int position) {
		return chs[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
