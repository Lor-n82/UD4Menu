package com.example.in2dm3_03.ud4menu;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text=(TextView)findViewById(R.id.textView);

        //ActionBar a=getSupportActionBar();

        //a.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        seleccionarOpcion(item);
        return true;    }

    private void seleccionarOpcion(MenuItem item){
        int itemId= item.getItemId();

        switch (itemId){
            case R.id.cambiarActividad:
                Toast.makeText(this,"Opcion 1 elegida",Toast.LENGTH_LONG ).show();
               // recogerTexto();
                Intent i1=new Intent(this, pantalla.class);
              //  i1.putExtra("texto", mTexto);

                startActivity(i1);
                break;
        }
    }
}
