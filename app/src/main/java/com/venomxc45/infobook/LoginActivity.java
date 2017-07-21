package com.venomxc45.infobook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String usr = "userKey";
    public static final String pass = "passKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button)findViewById(R.id.btnLogin);
        username=(EditText)findViewById(R.id.editLoginUsername);
        password=(EditText)findViewById(R.id.editLoginPassword);
        final int[] a1 = {1,2,3,4};
        //sharedpreferences = this.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = username.getText().toString().trim().toLowerCase();
                String p = password.getText().toString().trim();
                SharedPreferences.Editor editor = preference.edit();
                editor.putString(usr,u);
                editor.putString(pass,p);
                editor.commit();
                username.setText(preference.getString(usr,u));
                if(u.equals("sabin") || u.equals("Admin") && p.equals("12345678")) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.putExtra("key",u);
                    i.putExtra("numberarray",a1);
                    startActivity(i);
                    finish();
                }
                else
                    Toast.makeText(getBaseContext(),"Login failed",Toast.LENGTH_LONG).show();
            }
        });
    }
}
