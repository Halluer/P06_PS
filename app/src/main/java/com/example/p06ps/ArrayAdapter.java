package com.example.p06ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArrayAdapter extends android.widget.ArrayAdapter<Note> {
    Context context;
    ArrayList<Note> notes;
    int resource;
    TextView tvName, tvDesc;

    public ArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
        super(context, resource, notes);
        this.context = context;
        this.notes = notes;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables
        tvName = rowView.findViewById(R.id.tvName);
        tvDesc = rowView.findViewById(R.id.tvDesc);

        Note note = notes.get(position);

        tvName.setText(note.getNoteContent());
        tvDesc.setText(note.getNoteContent());

        return rowView;
    }



}