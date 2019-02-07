package com.example.sqlitetutor;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteContactFragment extends Fragment {

    EditText editTextId;
    Button delete;

    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);
        editTextId = view.findViewById(R.id.delete_contact_id);
        delete = view.findViewById(R.id.bn_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        return view;
    }

    private void deleteContact() {
        if(!editTextId.getText().toString().isEmpty()) {
            int id = Integer.parseInt(editTextId.getText().toString());
            ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
            SQLiteDatabase db = contactDBHelper.getWritableDatabase();
            contactDBHelper.deleteContact(id, db);
            contactDBHelper.close();
            editTextId.setText("");
            Toast.makeText(getActivity(), "Contact Deleted Sucessfully", Toast.LENGTH_SHORT).show();
        }
    }

}
