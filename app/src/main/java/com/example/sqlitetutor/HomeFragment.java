package com.example.sqlitetutor;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    Button Bnadd,Bnview,Bnupdate,Bndelete;
    DbOperationListener dbOperationListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface DbOperationListener{

        public void DbOperationPerformed(int method);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Bnadd = view.findViewById(R.id.bn_addcontact);
        Bnadd.setOnClickListener(this);
        Bnview = view.findViewById(R.id.bn_viewcontact);
        Bnview.setOnClickListener(this);
        Bnupdate = view.findViewById(R.id.bn_updatecontact);
        Bnupdate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_addcontact:
                dbOperationListener.DbOperationPerformed(0);
                break;
            case R.id.bn_viewcontact:
                dbOperationListener.DbOperationPerformed(1);
                break;
            case R.id.bn_updatecontact:
                dbOperationListener.DbOperationPerformed(2);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            dbOperationListener = (DbOperationListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must Implement the interface method....");
        }
    }
}
