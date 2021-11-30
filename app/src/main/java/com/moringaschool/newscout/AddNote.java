package com.moringaschool.newscout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class AddNote extends AppCompatActivity {
    @BindView(R.id.titleInput) EditText mTitleInput;
    @BindView(R.id.descriptionInput) EditText mDescriptionInput;
    @BindView(R.id.button_add_note) MaterialButton mAddNoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);


        mAddNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm.init(getApplicationContext());
                Realm realm = Realm.getDefaultInstance();
                String title =mTitleInput.getText().toString();
                String description = mDescriptionInput.getText().toString();

                realm.beginTransaction();
                Note note = realm.createObject(Note.class);
                note.setTitle(title);
                note.setDescription(description);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(), "Note Saved",Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }
}