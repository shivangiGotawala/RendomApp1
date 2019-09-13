package com.rendomapp.rendomapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class EmptyActivity extends AppCompatActivity {

    String txt[] = {"", "Helping you understand what may be helping your acne and what may be contributing to your breakouts.",
            "Our experts helped us put together this list of the most common influences on skin health.",
            "You can also create custom notes to keep track of anything of interest in your routine."};

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        final TextView tvNoteTitle = findViewById(R.id.tvTitle_one);
        final TextView tvNoteDesc = findViewById(R.id.tvOne);
        ImageView ivNoteGif = findViewById(R.id.iv_note_gif);
        Button btnNext = findViewById(R.id.btnNext);


        Glide.with(this).asGif().load(R.drawable.note_animation).listener(new RequestListener<GifDrawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                resource.setLoopCount(1);
                resource.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        //do whatever after specified number of loops complete
                    }
                });
                return false;
            }}).into(ivNoteGif);

//        Glide.with(EmptyActivity.this).load(R.drawable.note_animation).into(ivNoteGif);

        tvNoteTitle.setText(R.string.onboarding_note_title);
//        Thread thread  = new Thread(){
//            @Override
//            public void run() {
//                while (!isInterrupted()){
//                    try{
//                        Thread.sleep(5000);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                tvNoteTitle.setText(R.string.onboarding_note_title_two);
//                            }
//                        });
//
//                    }catch(InterruptedException exception){
//                        exception.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread.start();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                tvNoteTitle.setText(R.string.onboarding_note_title_two);
            }
        }, 5000);


        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(2500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i < txt.length) {
                                    tvNoteDesc.setText(txt[i]);
                                    i++;
                                }
                            }
                        });
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        };
        t.start();

//        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
//        slideUp.setDuration(20000);
//        slideUp.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                tvNoteTitle.setText(R.string.onboarding_note_title_two);
//            }
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//
//        tvNoteTitle.startAnimation(slideUp);

//
//        final Animation in = new AlphaAnimation(0.0f, 1.0f);
//        in.setDuration(3000);
//
//        final Animation out = new AlphaAnimation(1.0f, 0.0f);
//        out.setDuration(3000);
//
//        AnimationSet as = new AnimationSet(true);
//        as.addAnimation(out);
//        in.setStartOffset(3000);
//        as.addAnimation(in);

//        viewFlipperOne.setAutoStart(true);
//        viewFlipperOne.startFlipping();
//        viewFlipperOne.setFlipInterval(5500);
//
//        viewFlipperTwo.setAutoStart(true);
//        viewFlipperTwo.startFlipping();
//        viewFlipperTwo.setFlipInterval(2000);

//        viewFlipperOne.setAutoStart(true);
//        viewFlipperOne.startFlipping();
//        viewFlipperOne.setFlipInterval(5400);
//
//        viewFlipperTwo.setAutoStart(true);
//        viewFlipperTwo.startFlipping();
//        viewFlipperTwo.setFlipInterval(2800);

    }
}
