package com.julenbujanda.noplanetb;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class SplashScreenActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        linearLayout = findViewById(R.id.splash_linear_layout);
        ivIcon = findViewById(R.id.iv_splash_icon);
        loadImages();
    }

    private void loadImages() {
        Glide.with(this)
                .load(R.drawable.planetearth)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, Transition<? super Drawable> transition) {
                        linearLayout.setBackground(resource);
                    }
                });
        Glide.with(this)
                .load(R.drawable.rocketlogo)
                .apply(RequestOptions.circleCropTransform())
                .into(ivIcon);
    }

}
