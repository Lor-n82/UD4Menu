package com.example.in2dm3_03.ud4menu;

import android.content.Intent;
import android.graphics.Color;
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

    static final int REQUEST = 1;
    static final int OPCION_1 = 0;
    static final int OPCION_2 = 1;
    private String mTexto;
    private String mNombre = "";
    private String cambioColor = "";
    private TextView mTNombre;
    private EditText t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (EditText) findViewById(R.id.editText);
        TextView text = (TextView) findViewById(R.id.textViewContextual);
        mTNombre = (TextView) findViewById(R.id.textViewNombre);

        registerForContextMenu(text);

        //ActionBar a=getSupportActionBar();
        //a.hide();
    }

    public void recogerTexto() {
        mTexto = String.valueOf(t1.getText());
    }

    /**
     * Cargo el layout menu para ser usado
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }


    /**
     * Recogemos los datos de la segunda actividad
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST) {
                mNombre = data.getStringExtra("texto");
                rellenarNombre();
            }
        }
    }

    public void rellenarNombre() {
        mTNombre.setText(mNombre);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        seleccionarOpcion(item);
        return true;
    }

    /**
     * En este metodo llamamos a crearMenu()
     * @param menu
     * @param v
     * @param menuInfo
     */
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        crearMenu(menu);
    }

    /**
     * Creo los items que contiene el menu contextual para crearlo
     * @param menu
     */
    private void crearMenu(ContextMenu menu) {
        MenuItem item1 = menu.add(Menu.NONE, OPCION_1, Menu.NONE, "Cambiar a rojo"); //La segunda opcion es la ID
        MenuItem item2 = menu.add(Menu.NONE, OPCION_2, Menu.NONE, "Cambiar a azul");
    }

    /**
     * Metodo en el que selecciono la accion segun la opcion
     * para el menu contextual
     * @param item
     * @return
     */
    public boolean onContextItemSelected(MenuItem item) {
        Intent i1 = new Intent(this, pantalla.class);

        switch (item.getItemId()) {
            case OPCION_1:
                Log.d("mira", "Rojo");
                mTNombre.setTextColor(Color.RED);
                cambioColor = "Color cambiado a Rojo";
                i1.putExtra("cambioColor", cambioColor);

                break;
            case OPCION_2:
                Log.d("mira", "Azul");
                mTNombre.setTextColor(Color.BLUE);
                cambioColor = "Color cambiado a Azul";
                i1.putExtra("cambioColor", cambioColor);
                break;
        }
        startActivity(i1);
        return true;
    }

    /**
     * Metodo en el que selecciono la accion segun la opcion
     * para el menu de opciones
     * @param item
     */
    private void seleccionarOpcion(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.cambiarActividad:
                Toast.makeText(this, "Cambiando de actividad", Toast.LENGTH_LONG).show();
                recogerTexto();
                Intent i1 = new Intent(this, pantalla.class);
                i1.putExtra("texto", mTexto);

                startActivityForResult(i1, REQUEST);
                break;
        }
    }
}
