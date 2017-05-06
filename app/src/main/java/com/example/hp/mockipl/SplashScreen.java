package com.example.hp.mockipl;

import android.content.Intent;
import android.icu.util.TimeUnit;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.TimeUtils;

import com.example.hp.mockipl.db.Helper;

/**
 * Created by HP on 3/20/2017.
 */

public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.splash);
        new Dbloader().execute();

    }
    public class Dbloader extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
          //  Helper hp=new Helper(getApplicationContext());

            try {
                Thread.sleep(3000);
            }
            catch (Exception e){

            }
            return null;
        }
        protected void onPostExecute( Void res){
            super.onPostExecute(res);
            Intent i=new Intent(SplashScreen.this,MainActivity.class);
            startActivity(i);
            finish();

        }
    }
}
