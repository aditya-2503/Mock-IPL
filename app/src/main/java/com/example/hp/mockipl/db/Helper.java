package com.example.hp.mockipl.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 3/20/2017.
 */

public class Helper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Quiz1.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + QuizContract.Quiz.TABLE_NAME + " (" +
                    QuizContract.Quiz.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    QuizContract.Quiz.COLUMN_NAME_Ques + " TEXT," +
                    QuizContract.Quiz.COLUMN_NAME_Op1 + " TEXT,"+
                    QuizContract.Quiz.COLUMN_NAME_Op2 + " TEXT,"+
                    QuizContract.Quiz.COLUMN_NAME_Op3 + " TEXT,"+
                    QuizContract.Quiz.COLUMN_NAME_Op4 + " TEXT,"+
                    QuizContract.Quiz.COLUMN_NAME_ans + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + QuizContract.Quiz.TABLE_NAME;

    public Helper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }/*

    private void addQuestions() {
        Qustions q1=new Qustions("which player has taken his 90 wicket in pepsi ipl 2013",
                " sunil narine",
                " rohit sharma",
                " dwayne bravo",
                " amit mishra","c");
        this.addQuestion(q1);
        Qustions q2=new Qustions("which player is best in ipl in all fielder",
                " sunil narine",
                " rohit sharma",
                " dwayne bravo",
                " amit mishra","b");
        this.addQuestion(q2);
    Qustions q3=new Qustions("which scored highest run in pepsi ipl 2013",
            " sunil narine",
            " rohit sharma",
            " dwayne bravo",
            " amit mishra","a");
        this.addQuestion(q3);
    Qustions q4=new Qustions("how many cheerleaders are there in ones site team",
            " sunil narine",
            " rohit sharma",
            " dwayne bravo",
            " amit mishra","d");
        this.addQuestion(q4);
    }*/

    public void addQuestion(Qustions q) {
 SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(QuizContract.Quiz.COLUMN_NAME_ID,q.getId());
        values.put(QuizContract.Quiz.COLUMN_NAME_Ques,q.getQues());
        values.put(QuizContract.Quiz.COLUMN_NAME_Op1,q.getOp1());
        values.put(QuizContract.Quiz.COLUMN_NAME_Op2,q.getOp2());
        values.put(QuizContract.Quiz.COLUMN_NAME_Op3,q.getOp3());
        values.put(QuizContract.Quiz.COLUMN_NAME_Op4,q.getOp4());
        values.put(QuizContract.Quiz.COLUMN_NAME_ans,q.getAns());
        db.insert(QuizContract.Quiz.TABLE_NAME, null,values);
        db.close();


    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
    }

    public ArrayList<Qustions> getall(){
        ArrayList<Qustions> quesList = new ArrayList<Qustions>();
        String query="Select * from "+ QuizContract.Quiz.TABLE_NAME;
        SQLiteDatabase db1=this.getReadableDatabase();
       Cursor cursor= db1.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Qustions ques=new Qustions();
                ques.setId(cursor.getInt(0));
                ques.setQues(cursor.getString(1));
                ques.setOp1(cursor.getString(2));
                ques.setOp2(cursor.getString(3));
                ques.setOp3(cursor.getString(4));
                ques.setOp4(cursor.getString(5));
                ques.setAns(cursor.getString(6));
                quesList.add(ques);

            }
            while (cursor.moveToNext());
        }
        return quesList;


    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + QuizContract.Quiz.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        cursor.close();
        return row;
    }
}
