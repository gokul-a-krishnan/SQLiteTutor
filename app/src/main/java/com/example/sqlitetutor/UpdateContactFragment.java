package com.example.sqlitetutor;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
public class UpdateContactFragment extends Fragment {

    private EditText editTextID,editTextName,editTextEmail;
    private Button BnUpdate;

    public UpdateContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_contact, container, false);
        editTextID = view.findViewById(R.id.edittext_update_contact_id);
        editTextName = view.findViewById(R.id.edittext_update_name);
        editTextEmail = view.findViewById(R.id.edittext_update_email);
        BnUpdate = view.findViewById(R.id.bn_update);
        BnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });
        return view;
    }

    private void updateContact() {
        int id = Integer.parseInt(editTextID.getText().toString());
        String name = editTextName.getText().toString();
        String email = editTextName.getText().toString();
        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
        SQLiteDatabase db = contactDBHelper.getWritableDatabase();
        contactDBHelper.updateContact(id,name,email,db);
        contactDBHelper.close();
        Toast.makeText(getActivity(),"Contact Updated Sucessfully",Toast.LENGTH_SHORT).show();
        editTextEmail.setText("");
        editTextName.setText("");
        editTextID.setText("");
    }
}
