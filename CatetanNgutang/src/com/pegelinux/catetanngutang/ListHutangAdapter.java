package com.pegelinux.catetanngutang;

import java.text.NumberFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListHutangAdapter extends ArrayAdapter<KomponenCatatan> {

	
	private Activity context;
	private int ResId;
	RecordHolder holder;
	private ArrayList<KomponenCatatan> data = new ArrayList<KomponenCatatan>();
	
	public ListHutangAdapter(Activity context, int resource, ArrayList<KomponenCatatan> data) {
		super(context, resource,resource, data);
		// TODOs Auto-generated constructor stub
		this.context = context;
		this.ResId = resource;
		this.data = data;
		
	}
	
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODOs Auto-generated method stub

		View row = convertView;
		holder = null;
		if(row == null){
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(ResId, parent, false);
			holder = new RecordHolder();
			holder.name = (TextView)row.findViewById(R.id.textNama);
			holder.amount = (TextView)row.findViewById(R.id.textAmount);
			holder.dueDate = (TextView)row.findViewById(R.id.textDuedate);
			
			row.setTag(holder);
			
		}else{
			
			holder = (RecordHolder)row.getTag();
			
		}
		KomponenCatatan kocat = data.get(position);
		holder.name.setText(kocat.getNama());
		holder.amount.setText("Rp. "+NumberFormat.getInstance().format(kocat.getHutang()));
		holder.dueDate.setText(kocat.getJatuhTempo());
		return row;
		
	}
	



	static class RecordHolder{
		TextView name,amount,dueDate;
	}

}
