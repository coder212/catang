package com.pegelinux.catetanngutang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView liview;
	private Button baru;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODOs Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		baru = (Button)findViewById(R.id.button);
		baru.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODOs Auto-generated method stub
				Intent newIntent = new Intent(MainActivity.this,TambahUtangActivity.class);
			    MainActivity.this.startActivity(newIntent);
				
			}
		});
	}

	
}
