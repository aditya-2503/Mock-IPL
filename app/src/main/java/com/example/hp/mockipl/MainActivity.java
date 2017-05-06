package com.example.hp.mockipl;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.mockipl.db.Helper;
import com.example.hp.mockipl.db.QuizContract;
import com.example.hp.mockipl.db.Qustions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView tv;
Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Helper hpl;
    Qustions qu;
    ArrayList<Qustions> lst;
    int id=0;
    int score=0;
    SharedPreferences.Editor editor;
    SharedPreferences sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       sf=getApplicationContext().getSharedPreferences("Mypef", Context.MODE_PRIVATE);
         editor=sf.edit();
        tv=(TextView)findViewById(R.id.quest);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        hpl=new Helper(this);
        addQuestions(hpl);
        lst=hpl.getall();
        qu=lst.get(id);
        for (Qustions cn : lst) {
            String log = "Id: "+cn.getQues()+" ,Name: " + cn.getAns() + " ,Phone: " + cn.getId();
            // Writing Contacts to log
            Log.d("Name: ", log);}
        setView();



    }
    private void addQuestions(Helper help) {
        Qustions q1=new Qustions(0,"which player has taken his 90 wicket in pepsi ipl 2013",
                " sunil narine",
                " rohit sharma",
                " dwayne bravo",
                " amit mishra","c");
        help.addQuestion(q1);
        Qustions q2=new Qustions(1,"which player is best in ipl in all fielder",
                " sunil narine",
                " rohit sharma",
                " dwayne bravo",
                " amit mishra","b");
        help.addQuestion(q2);
        Qustions q3=new Qustions(2,"which scored highest run in pepsi ipl 2013",
                " sunil narine",
                " rohit sharma",
                " dwayne bravo",
                " amit mishra","a");
        help.addQuestion(q3);
        Qustions q4=new Qustions(3,"how many cheerleaders are there in ones site team",
                " 3",
                " 5",
                " 8",
                " 6","d");
        help.addQuestion(q4);
    }


    public void setView(){
        tv.setText(qu.getQues());
        btn1.setText(qu.getOp1());
        btn2.setText(qu.getOp2());
        btn3.setText(qu.getOp3());
        btn4.setText(qu.getOp4());
    /*    btn1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btn2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btn3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btn4.setBackgroundColor(getResources().getColor(R.color.colorAccent));*/
       // id++;

    }

    @Override
    public void onClick(View view) {
        int red=view.getId();

        switch (red){
            case R.id.btn1:{
                if(qu.getAns().contentEquals("a")) {
                   // view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    score++;
                    editor.putInt("Q1",id+1);

                    //view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                   /* try{
                        Thread.sleep(5500);}
                    catch (Exception e){*/
                        Log.d("id",Integer.toString(id));
                    //}*/
                }

                if(id<3){
                   id++;
                    qu=lst.get(id);
                    setView();
                }
                else{
                    Intent it=new Intent(this,Result.class);
                    it.putExtra("Score",score);
                    startActivity(it);
                    finish();}


                }
                break;

            case R.id.btn2:{
                if(qu.getAns().contentEquals("b")) {
                 //   view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    score++;
                    editor.putInt("Q2",id+1);
                  //  view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    /*try{
                        Thread.sleep(5500);}
                    catch (Exception e){
                        Log.d("Exception","Error");
                    }*/
                }



                if(id<3){
                    id++;
                    qu=lst.get(id);
                    setView();
                }
                else{
                    Intent it=new Intent(this,Result.class);
                    it.putExtra("Score",score);
                    startActivity(it);
                    finish();}


                break;
            }
            case R.id.btn3:{
                if(qu.getAns().contentEquals("c")) {
                   // view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    score++;
                    editor.putInt("Q3",id+1);
                   /* try{
                        Thread.sleep(5500);}
                    catch (Exception e){
                        Log.d("Exception","Error");
                    }*/
                  }



                if(id<3){
                    id++;
                    qu=lst.get(id);
                    setView();
                }
                else{
                    Intent it=new Intent(this,Result.class);
                    it.putExtra("Score",score);
                    startActivity(it);
                    finish();}


                break;
            }
            case R.id.btn4:{
                if(qu.getAns().contentEquals("d")) {
                   // view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                  //  view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                   /* try{
                        Thread.sleep(5500);}
                    catch (Exception e){
                        Log.d("Exception","Error");
                    }*/
                score++;
                editor.putInt("Q4",id+1);}



                if(id<3){
                    id++;
                    qu=lst.get(id);
                    setView();
                }
                else{
                    Intent it=new Intent(this,Result.class);
                    it.putExtra("Score",score);
                    startActivity(it);
                    finish();}


                break;
            }
        }
        editor.commit();
    }
}
