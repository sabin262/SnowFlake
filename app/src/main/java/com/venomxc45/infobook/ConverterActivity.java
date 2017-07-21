package com.venomxc45.infobook;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sabin Nakarmi on 19-Jul-17.
 */

public class ConverterActivity extends Fragment{
    EditText input;
    RadioButton cmtoinch,inchtocm;
    Button convert;
    TextView result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_converter, container, false);
        input = rootView.findViewById(R.id.etValueToConvert);
        cmtoinch = rootView.findViewById(R.id.rbCmToInch);
        inchtocm = rootView.findViewById(R.id.rbInchToCm);
        convert = rootView.findViewById(R.id.btnConvert);
        result = rootView.findViewById(R.id.txtResult);



        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    double value = Double.parseDouble(input.getText().toString());
                    if(inchtocm.isChecked()){
                        double r = value*2.54;
                        result.setText(r+"cm");
                    }
                    else if(cmtoinch.isChecked()){
                        double r = value/2.54;
                        result.setText(r+"inch");
                    }
                }
                catch(Exception e){
                 e.printStackTrace();
                }
            }
        });
        return rootView;
    }
}
