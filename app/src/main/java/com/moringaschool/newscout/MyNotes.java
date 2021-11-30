package com.moringaschool.newscout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyNotes extends AppCompatActivity implements  Dialog.DialogListener {
    @BindView(R.id.imageViewOpenDialog) ImageView ImageViewOpenDialog;
    @BindView(R.id.notesListView) ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);

        ButterKnife.bind(this);


        ImageViewOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
            
        });


    }

    private void openDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void applyTexts(ArrayList<String> NotesList) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyNotes.this, android.R.layout.simple_list_item_1,NotesList);
        listView.setAdapter(adapter);
    }
}