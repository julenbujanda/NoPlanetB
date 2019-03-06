package com.julenbujanda.noplanetb;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class BSplash extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ImageView ivIcon;
    private TextView txtTitle, txtSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        linearLayout = findViewById(R.id.splash_linear_layout);
        ivIcon = findViewById(R.id.iv_splash_icon);
        txtTitle = findViewById(R.id.txt_splash_title);
        txtSubtitle = findViewById(R.id.txt_splash_subtitle);
        loadImages();
        mostrarAnimaciones();
/*        new Handler().postDelayed(() -> {

        }, 3000);*/
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

    private void mostrarAnimaciones() {
        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        txtTitle.startAnimation(slideDown);
        ivIcon.startAnimation(fadeIn);
        ivIcon.setVisibility(View.VISIBLE);
        txtSubtitle.startAnimation(fadeIn);
        txtSubtitle.setVisibility(View.VISIBLE);
    }

}
