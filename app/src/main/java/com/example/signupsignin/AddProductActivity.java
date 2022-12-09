package com.example.signupsignin;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddProductActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private EditText etName, etInfo;
    private Spinner spCat;
    private EditText etPrice;
    private EditText etCompany;
    private FirebaseServices fbs;
    private Product product;
    private Button btnAddProAddProduct;
    private int maxid=0;

    public AddProductActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        connectComponents();
    }
    private void connectComponents() {
        etName = findViewById(R.id.etProductNameAddProduct);
        spCat = findViewById(R.id.spProductCatADDPRODUCT);
        etInfo = findViewById(R.id.etdInfoAddProduct);
        etPrice = findViewById(R.id.etProPriceAddProduct);
        etCompany = findViewById(R.id.etProductCompanyAddPro);
        btnAddProAddProduct=findViewById(R.id.btnAddProAddProduct);
        fbs = FirebaseServices.getInstance();
        spCat.setAdapter(new ArrayAdapter<ProductCat>(this, android.R.layout.simple_list_item_1, ProductCat.values()));
    }
    public void add(View view)
    {
        String productName, proInfo, proCompany, proPhoto, proPrice;
        productName = etName.getText().toString();
        proInfo = etInfo.getText().toString();
        proPrice = etPrice.getText().toString();
        proCompany = etCompany.getText().toString();

        if (productName.trim().isEmpty() || proInfo.trim().isEmpty() || proCompany.trim().isEmpty()) {
            Toast.makeText(this, "error fields empty", Toast.LENGTH_SHORT).show();
            return;
        }
        product = new Product();
        ref=database.getInstance().getReference().child("item");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.exists())
                {
                   maxid =(int)dataSnapshot.getChildrenCount();
                }
                else
                {

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnAddProAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                product.setProductName(etName.getText().toString());
                product.setProPrice(etPrice.getText().toString());
                product.setProCompany(etCompany.getText().toString());
                product.setProInfo(etInfo.getText().toString());
                ref.child(String.valueOf(maxid+1)).setValue(product);
            }
        });
}
}