package com.example.in2dm3_03.ud4menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST=0;
    static final int OPCION_1 = 0;
    private String mTexto;
    private String mNombre="";
    private TextView mTNombre;
    private EditText t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText) findViewById(R.id.editText) ;
        TextView text=(TextView)findViewById(R.id.textViewContextual);
        mTNombre=(TextView)findViewById(R.id.textViewNombre);

        registerForContextMenu(text);
        //ActionBar a=getSupportActionBar();

        //a.hide();
    }

    public void recogerTexto(){
        mTexto= String.valueOf(t1.getText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;

    }


    //REVISAR
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST) {
                mNombre = getIntent().getStringExtra("texto");
                Log.d("prueba", mNombre + "Hay algo?");
                rellenarNombre();
            }
        }
    }

    public void rellenarNombre(){
        mTNombre.setText(mNombre);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        seleccionarOpcion(item);
        return true;    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        crearMenu(menu);
    }

    private void crearMenu(ContextMenu menu) {
        MenuItem item1 = menu.add(Menu.NONE, OPCION_1, Menu.NONE,"cambio"); //La segunda opcion es la ID

       /* Intent i1=new Intent(this, pantalla.class);
        i1.putExtra("texto", mTexto);

        startActivityForResult(i1,REQUEST);*/
    }

    private void seleccionarOpcion(MenuItem item){
        int itemId= item.getItemId();

        switch (itemId){
            case R.id.cambiarActividad:
                Toast.makeText(this,"Cambiando de actividad",Toast.LENGTH_LONG ).show();
                recogerTexto();
                Intent i1=new Intent(this, pantalla.class);
                i1.putExtra("texto", mTexto);

                startActivityForResult(i1,REQUEST);
                break;
        }
    }
}
