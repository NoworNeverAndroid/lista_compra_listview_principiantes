package com.example.nowor_000.list3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nowor_000 on 18/01/2016.
 */

public class ListaAdapter extends ArrayAdapter<Producto> {

    private final List<Producto> list;
    private final Context context;

    public ListaAdapter(Context context, List<Producto> list) {
        super(context, R.layout.list_fila, list);
        this.context = context;
        this.list = list;
    }


    static class ViewHolder {//Un miembro protegido es accesible dentro de su clase y por instancias de clases derivadas.
        protected ImageView imageview_alimento;
        protected TextView tvTitulo;
        protected TextView tvDescripcion;
        protected CheckBox checkbox;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator =LayoutInflater.from(context);// Activity.getLayoutInflater();
            view = inflator.inflate(R.layout.list_fila, null);// java.lang.UnsupportedOperationException: addView(View, LayoutParams) is not supported in AdapterView
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvTitulo = (TextView) view.findViewById(R.id.tvTitulo);
            viewHolder.tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcion);
            viewHolder.imageview_alimento = (ImageView) view.findViewById(R.id.ImagView_Producto);
            viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);

            viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override                    //checkbox ,                activado:true-false
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Producto element = (Producto) viewHolder.checkbox.getTag();
                    element.setSelected(buttonView.isChecked());

                }
            });

            view.setTag(viewHolder);
            viewHolder.checkbox.setTag(list.get(position));
        } else {
            view = convertView;
            ((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));

        }
        ViewHolder holder = (ViewHolder) view.getTag();

        holder.tvTitulo.setText(list.get(position).getTitulo());
        holder.tvDescripcion.setText(list.get(position).getDescripcion());
        holder.imageview_alimento.setImageResource(list.get(position).getId_imagen());

        holder.checkbox.setChecked(list.get(position).isSelected());
        return view;
    }


    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Producto getItem(int position) {
        return super.getItem(position);
    }



}