package com.example.greads;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.HashMap;

public class SplashActivity extends Activity {

    ImageView imglogo;
    ImageView ivtop,ivbottom,ivbeat;
    TextView textView;
    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivtop = findViewById(R.id.iv_top);
        imglogo = findViewById(R.id.splash_imglogo);
        ivbeat = findViewById(R.id.iv_beat);
        ivbottom = findViewById(R.id.iv_bottom);
        textView = findViewById(R.id.text_view);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.top_wave);

        ivtop.setAnimation(animation1);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                imglogo,
                PropertyValuesHolder.ofFloat("ScaleX",1.2f),
                PropertyValuesHolder.ofFloat("ScaleY",1.2f)
        );
        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();

        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/demoapp-ae96a.appspot.com/o/heart_beat.gif?alt=media&token=b21dddd8-782c-457c-babd-f2e922ba172b")
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivbeat);

        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.bottom_wave);

        ivbottom.setAnimation(animation2);

        animatText("Welcome to GReads");

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(SplashActivity.this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                finish();
            }
        },5000);
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView.setText(charSequence.subSequence(0,index++));

            if (index <= charSequence.length()){
                handler.postDelayed(runnable,delay);
            }
        }
    };

    public void animatText(CharSequence cs){
        charSequence = cs;
        index = 0;
        textView.setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,delay);

    }
}