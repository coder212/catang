package com.pegelinux.catetanngutang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHutang extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "utang.db";
	private static final int DATABASE_VERSION = 1;
	
	public final String ID = "Id";
	public final String NAMA = "Nama";
	public final String HUTANG = "Hutang";
	public final String JATUH_TEMPO = "Jatuh_tempo";
	
	public final String TABLE_UTANG = "Utang";
	
	private final String CREATE_TABLE_UTANG = "create table "+TABLE_UTANG+"("+ID+" integer primary key,"+NAMA+" text,"+
	HUTANG+" text,"+JATUH_TEMPO+" text);";

	public DatabaseHutang(Context context) {
		super(context, DATABASE_NAME,null,DATABASE_VERSION);
		// TODOs Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODOs Auto-generated method stub
		db.execSQL(CREATE_TABLE_UTANG);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldDb, int newDb) {
		// TODOs Auto-generated method stub
		db.execSQL("drop table if exists "+TABLE_UTANG);
		onCreate(db);
	}

}
