package com.pio.skripsi.dfskripsi.dfs.model;

import java.util.List;

import com.pio.skripsi.dfskripsi.dfs.model.DaoMaster.DevOpenHelper;
import com.pio.skripsi.dfskripsi.dfs.model.tb_relationDao.Properties;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.System;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.QueryBuilder;

public class DFSmodel extends ListActivity {

	public SQLiteDatabase db;

	public Cursor cursor;
	
	public EditText editTextLat;
	public EditText editTextLon;
	
	public void onSelect(String idNodeAwal){
		
		String path = Environment.getExternalStorageDirectory().getPath() + "/dfs_db.sqlite";
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, path, null);
		db = helper.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		DaoSession daoSession = daoMaster.newSession();
		tb_nodeDao nodeDao = daoSession.getTb_nodeDao();
		tb_relationDao relationDao = daoSession.getTb_relationDao();
		
		//--query select tb_relation
		String sql = "SELECT id_way FROM tb_relation WHERE id_node = "+idNodeAwal;
		cursor = db.rawQuery(sql, null);
		
		java.lang.System.out.println(cursor);
	}
	
	
	
}
