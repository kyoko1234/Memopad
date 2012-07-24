package sample.application.memopad;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
//P61í«â¡
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
import android.content.Intent;

public class MemoList extends ListActivity {
	
	//P61í«â¡
	static final String[] cols= {"title" , "memo" , android.provider.BaseColumns._ID ,}; //îzóÒ
	MemoDBHelper memos;

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		memos = new MemoDBHelper(this);
		SQLiteDatabase db = memos.getWritableDatabase();
		Cursor cursor = db.query("memoDB" , cols , "_ID=" + String.valueOf(id) , null , null , null , null);
		this.startManagingCursor(cursor);
		int idx = cursor.getColumnIndex("memo");
		cursor.moveToFirst();
		Intent i = new Intent();
		
		i.putExtra("text", cursor.getString(idx));
		setResult(Activity.RESULT_OK,i);
		memos.close();
		finish();
		
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.memolist);
		this.showMemos(this.getMemos());
		
		ListView lv = (ListView) this.findViewById(android.R.id.list);
		this.registerForContextMenu(lv);
	}
	
	public void showMemos(Cursor cursor){
		if(cursor!=null){ //cursorÇ™nullÇ≈Ç»ÇØÇÍÇŒà»â∫ÇÃèàóù
			String[] from = {"title"};
			int[] to = {android.R.id.text1};
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
					this , android.R.layout.simple_list_item_1 , cursor , from , to);
					setListAdapter(adapter);
		}
	memos.close();
		
	}

	public Cursor getMemos() {
		this.memos = new MemoDBHelper(this);
		SQLiteDatabase db = memos.getReadableDatabase();
		Cursor cursor = db.query("memoDB", MemoList.cols, null, null, null, null, null);
		startManagingCursor(cursor);
		return cursor;
	}

}
