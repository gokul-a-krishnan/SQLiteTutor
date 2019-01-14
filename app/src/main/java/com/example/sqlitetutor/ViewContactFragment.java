package com.example.sqlitetutor;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewContactFragment extends Fragment {

    TextView textView;

    public ViewContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_view_contact, container, false);
        textView = view.findViewById(R.id.textView);
        readContacts();
        return view;
    }

    private void readContacts(){
        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
        SQLiteDatabase db = contactDBHelper.getReadableDatabase();
        String info = "";
        Cursor cursor = contactDBHelper.readContact(db);
        while (cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            info = info + "\n\nId : " + id + "\nName : " + name + "\nEmail : " + email;
        }
        textView.setText(info);
        contactDBHelper.close();
    }
}
