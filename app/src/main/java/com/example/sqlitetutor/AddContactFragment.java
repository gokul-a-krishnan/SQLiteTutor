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
public class AddContactFragment extends Fragment implements View.OnClickListener{

    Button Bnsave;
    EditText id,name,email;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        Bnsave = view.findViewById(R.id.bn_save);
        id = view.findViewById(R.id.edittext_contact_id);
        name = view.findViewById(R.id.edittext_name);
        email = view.findViewById(R.id.edittext_email);
        Bnsave.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_save:
                String Name = name.getText().toString().trim();
                String Email = email.getText().toString();
                if ( !id.getText().toString().isEmpty() && !Name.isEmpty() && !Email.isEmpty()){
                    int Id = Integer.parseInt(id.getText().toString());
                    ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                    SQLiteDatabase db = contactDBHelper.getWritableDatabase();
                    contactDBHelper.addContact(Id,Name,Email,db);
                    db.close();
                    id.setText("");
                    name.setText("");
                    email.setText("");
                    Toast.makeText(getActivity(),"Conatct Saved Sucessfully",Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }
}
