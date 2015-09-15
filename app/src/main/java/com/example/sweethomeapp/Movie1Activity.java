package com.example.sweethomeapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;


public class Movie1Activity extends Activity implements
        SurfaceHolder.Callback,
        MediaPlayer.OnCompletionListener {
    private static final String TAG = "VideoPlayer";

    private SurfaceHolder holder;

    private SurfaceView mPreview;

    private MediaPlayer mp = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie1);

        getWindow().setFormat(PixelFormat.TRANSPARENT);
        mPreview = (SurfaceView) findViewById(R.id.surfaceView1);
        holder = mPreview.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(this);
    }

    public boolean onDestroy(MediaPlayer mp, int what, int extra) {
        if (mp != null) {
            mp.release();
            mp = null;
        }
        return false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
        //String mediaPath = "https://www.youtube.com/watch?v=i4bAhKHlVBI";
        String mediaPath = "android.resource://" + getPackageName() + "/" + R.raw.movie1;
        try {
            mp = new MediaPlayer();
            mp.setDataSource(this, Uri.parse(mediaPath));
            mp.setDisplay(paramSurfaceHolder);
            mp.prepare();
            mp.start();
            mp.setOnCompletionListener(this);

        } catch (IllegalArgumentException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1,
                               int paramInt2, int paramInt3) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        // TODO Auto-generated method stub
        Log.v("MediaPlayer", "onCompletion");
        Intent intent = new Intent(Movie1Activity.this, Question1Activity.class);
        // 次画面のアクティビティ起動
        startActivity(intent);
    }
}
