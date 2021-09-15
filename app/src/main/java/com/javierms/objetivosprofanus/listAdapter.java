package com.javierms.objetivosprofanus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class listAdapter extends ArrayAdapter<CObjetivo> {

    private Context miContext;
    private int miResource;


    public listAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CObjetivo> objects) {
        super(context, resource, objects);
        this.miContext = context;
        this.miResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(miContext);


        CObjetivo miObjetivo = getItem(position);

        convertView = layoutInflater.inflate(miResource, parent,false);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView txtId = convertView.findViewById(R.id.txtId);
        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        TextView txtMultiple = convertView.findViewById(R.id.txtMultiple);

        txtId.setText(""+miObjetivo.getId());
        txtNombre.setText(miObjetivo.getNombre());

        if (miObjetivo.getMultiple() == false){
            txtMultiple.setText("1");
        } else {
            txtMultiple.setText("Variable");
        }



        return convertView;


    }
}
