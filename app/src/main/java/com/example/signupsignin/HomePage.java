package com.example.signupsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity
{
    private Button btnBenefit;
    private Button btnSheglow;
    private Button btnHudaBeauty;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        connect();
    }

   public void connect()
    {
        btnBenefit=findViewById(R.id.btnBenefit);
        btnSheglow=findViewById(R.id.btnSheglow);
        btnHudaBeauty=findViewById(R.id.btnHudaBeauty);
        textView2=findViewById(R.id.textView2);
    }
}