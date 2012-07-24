package sample.application.memopad; 

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;



public class MemoDBHelper extends SQLiteOpenHelper {
	//クラス変数の定義
	public static final String name ="memos.db";
	public static final Integer version = 1;
	public static final CursorFactory factory = null; // factory;　(これでもnullが入ってる）
	//インスタンス変数　static書かない
	public final String name2 ="memos.db";
	
		 //↓コンストラクタ（戻り値なし）	
	public MemoDBHelper(Context context) {
		//↓superは親クラスのこと　thisは呼び出しているクラス自身（子）のこと　を指定している
		super(context, name, factory, version);
		
	}
	
	@Override			//↓引数の型　　　　 ↓変数
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table memoDB ("
				+ android.provider.BaseColumns._ID
				+ " integer primary key autoincrement, title Text, memo TEXT); ";
		db.execSQL(sql); //SQLiteDatabese の　インスタンス変数
	}
		
	
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	
	
}
