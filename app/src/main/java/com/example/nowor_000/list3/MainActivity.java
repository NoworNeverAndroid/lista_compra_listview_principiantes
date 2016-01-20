package com.example.nowor_000.list3;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Context ctx;
    private List<Producto> listaProducto;
    private EditText edNombre, edDescripcion;
    ArrayAdapter<Producto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx=this;
        addView();


    }



    private void addView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        edDescripcion =(EditText) findViewById(R.id.edDescripcionProducto);
        edNombre =(EditText) findViewById(R.id.edNombreProducto);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                listaProducto.add(get(edNombre.getText().toString(), edDescripcion.getText().toString(), R.drawable.icon_add));
                adapter.notifyDataSetChanged();
                edNombre.getText().clear();
                edDescripcion.getText().clear();



            }
        });

        // create an array of Strings, that will be put to our ListActivity
        ListView listaView=(ListView) findViewById(R.id.listView);
        adapter = new ListaAdapter(MainActivity.this, getListaProductos());
        listaView.setAdapter(adapter);
        listaView.refreshDrawableState();

    }


    private List<Producto> getListaProductos(){
        listaProducto= new ArrayList<Producto>();
        String [] titulos;
        String [] descripciones;
        titulos=  ctx.getResources().getStringArray(R.array.titulos);
        descripciones= ctx.getResources().getStringArray(R.array.descripciones);




        int [] imagenes= new int[]{
                R.drawable.icon_pan1
                , R.drawable.icon_naranja2
                , R.drawable.icon_zanahoria3
                ,R.drawable.icon_cereal4
                , R.drawable.icon_leche5
                , R.drawable.icon_limon6
                , R.drawable.icon_sal7
        };







        for (int i=0; i<imagenes.length; i++){
            listaProducto.add(get(titulos[i],descripciones[i],imagenes[i]));

        }
        //listaProducto.get(0).setSelected(true);

        return listaProducto;
    }


    private Producto get(String titulo,String descripcion, int imagen ) {
        return new Producto(titulo, descripcion, imagen);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch (id){




            case R.id.menu_duplicar:

                for (int i=0; i<listaProducto.size(); i++){


                    if(listaProducto.get(i).isSelected()){
                        listaProducto.add(get(listaProducto.get(i).getTitulo(), listaProducto.get(i).getDescripcion(), listaProducto.get(i).getId_imagen()));
                        listaProducto.get(i).setSelected(false);
                    }

                }

                adapter.notifyDataSetChanged();

                break;

            case R.id.menu_borrar:

                for (int i=listaProducto.size()-1; i>=0; i--){
                    if(listaProducto.get(i).isSelected()){
                        listaProducto.remove(i);

                    }
                }
                adapter.notifyDataSetChanged();




                break;
            default:
                break;

        }


        return super.onOptionsItemSelected(item);
    }



}
