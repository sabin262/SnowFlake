package com.venomxc45.infobook;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Sabin Nakarmi on 19-Jul-17.
 */

public class FriendListActivity extends Fragment{
    ListView listView;
    Button change,close;
    EditText name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_friend_list, container, false);
        final String[] mobileArray = {"Ankit Tandukar", "Aviral Ghimire", "Aryan Sitaula", "Nischal Maharjan", "Nivaja Man Singh","Sahil Man Singh", "Sagar Dyola", "Sushant Acharya"};
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mobileArray);
        listView =  rootView.findViewById(R.id.listFriends);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                //Toast.makeText(getActivity(),"List Item " + mobileArray[i]+" clicked",Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(getActivity(),AlertDialog.class);
                //startActivity(intent);
                //openDialog();
                final Dialog dialog = new Dialog(getActivity()); // Context, this, etc.
                dialog.setContentView(R.layout.activity_alert_dialog);
                dialog.setTitle(R.string.change_name);
                dialog.show();
                name = dialog.findViewById(R.id.etName);
                change = dialog.findViewById(R.id.dialog_ok);
                close = dialog.findViewById(R.id.dialog_cancel);
                change.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String n = name.getText().toString();
                        mobileArray[i]=n;
                        dialog.dismiss();
                    }
                });
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }

        });
        return rootView;

    }

}
