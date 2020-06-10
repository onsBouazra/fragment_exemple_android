package com.example.myfragmentsapplication;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {
    Index activity;
    String []data;
    public interface Index{
        void onIndex(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
        activity=(Index)context;}
        catch(ClassCastException e){
        throw new ClassCastException(activity.toString()+"Must imlement the interface");
        }



    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    activity.onIndex(position);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       data=getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_expandable_list_item_1,data));
        if(getActivity().findViewById(R.id.landscape_layout)!=null)
        activity.onIndex(0);

    }
}
