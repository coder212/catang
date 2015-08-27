package com.pegelinux.catetanngutang;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView liview;
	ListHutangAdapter adapter;
	String[] projection={"Nama","Hutang","Jatuh_tempo"};
	private Button baru;
	private DatabaseHutang dbhu;
	private ArrayList<KomponenCatatan> data = new ArrayList<KomponenCatatan>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODOs Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		dbhu = new DatabaseHutang(this);
		baru = (Button)findViewById(R.id.button);
		baru.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODOs Auto-generated method stub
				Intent newIntent = new Intent(MainActivity.this,TambahUtangActivity.class);
			    MainActivity.this.startActivity(newIntent);
				
			}
		});
		liview = (ListView)findViewById(R.id.listview);
		adapter = new ListHutangAdapter(this,R.layout.raw_layout, data);
		liview.setAdapter(adapter);
		if(exists()){
			if(data.size()>0){
				data.clear();
			}
			setList();
		}
		adapter.notifyDataSetChanged();
	}

	private void setList() {
		// TODOs Auto-generated method stub
		Uri url = Uri.parse("content://com.pegelinux.catetanngutang.hutangdatabaseprovider/element");
		Cursor cursor = MainActivity.this.getContentResolver().query(url, projection, null, null, null);
		
		if(cursor.getCount()>1){
			cursor.moveToFirst();
		    do{
			
			    String nama = cursor.getString(cursor.getColumnIndex("Nama"));
			    String hutang = cursor.getString(cursor.getColumnIndex("Hutang"));
			    String dueDate = cursor.getString(cursor.getColumnIndex("Jatuh_tempo"));
			    double htang = Double.parseDouble(hutang);
			    data.add(new KomponenCatatan(nama,htang,dueDate));
			
		     }while(cursor.moveToNext());
		}else{
			cursor.moveToFirst();
			String nama = cursor.getString(cursor.getColumnIndex("Nama"));
		    String hutang = cursor.getString(cursor.getColumnIndex("Hutang"));
		    String dueDate = cursor.getString(cursor.getColumnIndex("Jatuh_tempo"));
		    double htang = Double.parseDouble(hutang);
		    data.add(new KomponenCatatan(nama,htang,dueDate));
		}
		adapter.notifyDataSetChanged();
		cursor.close();
	}

	private boolean exists(){
		SQLiteDatabase db = dbhu.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from Utang", null);
		if(cursor !=null && cursor.getCount()>0){
			return true;
		}else{
			return false;
		}
	}
	
}

