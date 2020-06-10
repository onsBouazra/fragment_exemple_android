package com.example.myfragmentsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.Index {
    TextView tvDetail;
   String[]dataDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetail=findViewById(R.id.tvDetail);
        dataDetail=getResources().getStringArray(R.array.descriptions);

        //the phone is in the landscape mode

        if(findViewById(R.id.landscape_layout)!= null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .commit();

        }
        //the phone is in a portrait layout
        if(findViewById(R.id.portrait_layout)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();

        }

    }

    @Override
    public void onIndex(int index) {

        tvDetail.setText(dataDetail[index]);
        if(findViewById(R.id.portrait_layout)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();

        }

        }

   }

