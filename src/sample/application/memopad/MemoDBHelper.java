package sample.application.memopad; 

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;



public class MemoDBHelper extends SQLiteOpenHelper {
	//�N���X�ϐ��̒�`
	public static final String name ="memos.db";
	public static final Integer version = 1;
	public static final CursorFactory factory = null; // factory;�@(����ł�null�������Ă�j
	//�C���X�^���X�ϐ��@static�����Ȃ�
	public final String name2 ="memos.db";
	
		 //���R���X�g���N�^�i�߂�l�Ȃ��j	
	public MemoDBHelper(Context context) {
		//��super�͐e�N���X�̂��Ɓ@this�͌Ăяo���Ă���N���X���g�i�q�j�̂��Ɓ@���w�肵�Ă���
		super(context, name, factory, version);
		
	}
	
	@Override			//�������̌^�@�@�@�@ ���ϐ�
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table memoDB ("
				+ android.provider.BaseColumns._ID
				+ " integer primary key autoincrement, title Text, memo TEXT); ";
		db.execSQL(sql); //SQLiteDatabese �́@�C���X�^���X�ϐ�
	}
		
	
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	
	
}
