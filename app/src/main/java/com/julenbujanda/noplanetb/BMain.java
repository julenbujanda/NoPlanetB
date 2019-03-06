package com.julenbujanda.noplanetb;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BMain extends AppCompatActivity {

    private ImageView imgIcon;
    private SwipeRefreshLayout swipeRefreshLayout;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgIcon = findViewById(R.id.img_main_icon);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        coordinatorLayout = findViewById(R.id.main_layout);
        Glide.with(this)
                .load(R.drawable.rocketlogo)
                .apply(RequestOptions.circleCropTransform())
                .into(imgIcon);
        swipeRefreshLayout.setOnRefreshListener(
                () -> {
                    Snackbar.make(coordinatorLayout, getString(R.string.refreshed), Snackbar.LENGTH_LONG)
                            .show();
                    swipeRefreshLayout.setRefreshing(false);
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }


}
