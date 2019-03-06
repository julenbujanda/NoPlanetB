package com.julenbujanda.noplanetb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class BLogin extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogin);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(v ->
                startActivity(new Intent(BLogin.this, BMain.class)));
    }
}
