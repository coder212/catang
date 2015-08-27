package com.pegelinux.catetanngutang;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TambahUtangActivity extends Activity {

	
	private EditText edName,edAmount,edDue;
	private TextView empty;
	private Button save;
	private String name,amount,dueDate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODOs Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_utang);
		empty = (TextView)findViewById(R.id.textEmpty);
		empty.setVisibility(View.INVISIBLE);
		edName = (EditText)findViewById(R.id.EditName);
		edAmount = (EditText)findViewById(R.id.EditOwe);
		edDue = (EditText)findViewById(R.id.EditTanggaljth);
		save = (Button)findViewById(R.id.buttonSave);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODOs Auto-generated method stub
				saveData();
				
			}
		});
	}
	
	private void saveData(){
		if((edName.getText().toString().equalsIgnoreCase(""))||(edAmount.getText().toString().equalsIgnoreCase(""))||
				(edDue.getText().toString().equalsIgnoreCase(""))){
			empty.setVisibility(View.VISIBLE);
		}else{
			
			name = edName.getText().toString();
			amount = edAmount.getText().toString();
			dueDate = edDue.getText().toString();
			
			ContentValues values = new ContentValues();
			values.put("Nama", name);
			values.put("Hutang", amount);
			values.put("Jatuh_tempo", dueDate);
			
			TambahUtangActivity.this.getContentResolver().insert(Uri.parse("content://com.pegelinux.catetanngutang.hutangdatabaseprovider/element"), values);
			
			Intent intent = new Intent(TambahUtangActivity.this, MainActivity.class);
			TambahUtangActivity.this.startActivity(intent);
			TambahUtangActivity.this.finish();
			
		}
	}
	
	

}
