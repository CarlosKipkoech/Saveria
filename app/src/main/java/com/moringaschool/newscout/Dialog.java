package com.moringaschool.newscout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.PriorityQueue;

import butterknife.BindView;
import butterknife.ButterKnife;

      public class Dialog extends AppCompatDialogFragment {
//    @BindView(R.id.EditTextTitle)
//    EditText mEditTextTitle;
//    @BindView(R.id.EditTextDescription)
//    EditText mEditTextDescription;

          private EditText editTextDescription;
          private DialogListener listener;





        @Override
        public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.activity_dialog,null);
            builder.setView(view)
                    .setTitle("Let's Create a Quick note")
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String description = editTextDescription.getText().toString();
                            ArrayList<Note> mNote = new ArrayList<Note>();
                            listener.applyTexts(description,mNote);

                        }
                    });

            editTextDescription = view.findViewById(R.id.EditTextDescription);


            return builder.create();
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            try {
                listener = (DialogListener) context;
            } catch (ClassCastException e){
                throw  new ClassCastException(context.toString()+"must implement dialog listener");
            }

        }

        public interface DialogListener{
            void applyTexts(String title,String description,ArrayList<Note> mNote);

        }
    }

