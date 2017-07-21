package com.venomxc45.infobook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Sabin Nakarmi on 19-Jul-17.
 */

public class NewsFeedActivity extends Fragment{
    ListView listMul;
    SeekBar value;
    TextView label;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_news_feed, container, false);
        final String[] mulValue = {"1","2","3","4","5","6","7","8","9","10"};
        final ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mulValue);
        listMul = rootView.findViewById(R.id.listMultiplication);
        listMul.setAdapter(adapter);
        label = rootView.findViewById(R.id.txtLabel);
        value = rootView.findViewById(R.id.seekMulValue);
        value.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int minvalue = 1;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i< minvalue) {
                    i=1;
                }
                label.setText("Multiplication Table of "+i);
                try {
                        String Value[] ={"1","2","3","4","5","6","7","8","9","10"};
                        ArrayAdapter secondAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Value);
                        for(String x:Value) {
                            int z = Integer.parseInt(x);
                            Value[z - 1] = i +" x "+ z +" = " +z*i;
                            listMul.setAdapter(secondAdapter);
                        }
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return rootView;

    }
}
