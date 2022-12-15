package com.example.signupsignin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllProductsActivity extends AppCompatActivity
{
    private RecyclerView rvAllProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        ArrayList<Product> products;
        products = new ArrayList<Product>();
        RecyclerView recyclerView = findViewById(R.id.rvAllProducts);
    }
}