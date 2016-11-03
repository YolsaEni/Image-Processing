package com.lili.find;

import java.util.Random;

import lili.beauty.find.R;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import wxj.lili.model.BaseFragment;
import wxj.lili.model.Log;
import wxj.lili.util.LiMsg;
import wxj.lili.util.LiService;
import zst.lili.view.CircleButton;
import zst.lili.view.SimpleViewHolder;

public class MyFragment extends BaseFragment{
	
	private final String[] chs = { "我", "528", "529", "521", "10086",
			"流量查询","话费查询","套餐查询" };
	private final String[] chs2 = { "526", "528", "529", "521", "10086",
			"3053","102","1051"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.main, container, false);
		
        
        MyAdapter adapter = new MyAdapter(this.getActivity(),chs);

        final ListView list = (ListView) view.findViewById(R.id.list);
        Random rand = new Random();
		int color = rand.nextInt();
        ColorDrawable sage = new ColorDrawable(color);
        list.setDivider(sage);
        list.setDividerHeight(3);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                
                SimpleViewHolder vh = (SimpleViewHolder) arg1.getTag();
                if(vh!=null){
                	 Random rand = new Random();
             		int color = rand.nextInt();
                    ((CircleButton)vh.getSelectIv()).setColor(color); 
                    String s=(String) arg0.getItemAtPosition(position);
                    String s2 =chs2[position];
                    if(s!=null&&s2!=null){
                		if(s.endsWith("查询")){
     					LiMsg.sendSmsByManager(getActivity(),"10086", s2);
     					LiService.vibrate(getActivity(), 70);
     				}else{
     					Intent intent = new Intent(Intent.ACTION_CALL,
     							Uri.parse("tel:" + s2));
     					startActivity(intent);	
     					
     				}   
                    }	
                }
            }
        });
		return view;
	}

	@Override
	public String getFragmentName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}

}
