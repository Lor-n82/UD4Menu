package com.example.in2dm3_03.ud4menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla extends AppCompatActivity {
    private String mNombre;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);

        t1=(TextView)findViewById(R.id.textViewRecogerNombre);

        mNombre=getIntent().getStringExtra("texto");

        t1.setText(mNombre);
    }

    @Override
    public void onBackPressed() {
        Intent i1=new Intent();
        i1.putExtra("texto",mNombre);
        setResult(RESULT_OK,i1);
        super.onBackPressed();
    }
}
