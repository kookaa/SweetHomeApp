package com.example.sweethomeapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class TopActivity extends ActionBarActivity {

    private Handler hdl = null;
    private OpSplashHandler or = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        hdl = new Handler();
        // 第２引数で切り替わる秒数(ミリ秒)を指定
        or = new OpSplashHandler();
        hdl.postDelayed(or, 3000);


    }

    // Opening SplashHandlerクラス
    class OpSplashHandler implements Runnable {
        public void run() {
            Intent intent = new Intent(TopActivity.this, Movie1Activity.class);
            startActivity(intent);
            TopActivity.this.finish();
        }
    }



}
