package com.example.enclases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llenar el comboBox o Lista

        //pASO 1 - data
        final String[] datos =
                new
                        String[]{"Alojamiento"," Alimentacion y Bebidas","Atractivos culturales","Esparcimiento","Compras"};

        //paso 2 - adaptador

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        //paso 3 - vista

        Spinner cmbOpciones = (Spinner)findViewById(R.id.cdCategorias);
       adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       cmbOpciones.setAdapter(adaptador);
        cmbOpciones.setOnItemSelectedListener(this);

    }


    //LISTVIEW
    //PASO 1 DATA
    final String[] datos2 =
            new String[] {"EXPLOMUNDO","MULTICARIBE","XPLORA","CAFÉ & TINTO","FANCY MINT COFFEE & CAKE SHOP",
            "SWEET LAND","ORO CAFÉ"};
//PASO 2

    ArrayAdapter<String> adaptador2 =
            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos2);

    @Override
        public void onNothingSelected(AdapterView<?> parent, View view, int position, long id)
    {
        TextView txtItem = (TextView)findViewById(R.id.txtCategoria);
        txtItem.setText("Categoría: " +
                parent.getItemAtPosition(position));
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        TextView txtItem =
                (TextView)findViewById(R.id.txtCategoria);
        txtItem.setText("");
    }
});