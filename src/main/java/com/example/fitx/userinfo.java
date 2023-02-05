package com.example.fitx;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class userinfo extends AppCompatActivity  {

    EditText editText_name,editText_emil;
    Button button_save;
    RadioGroup radioGroup;
    Spinner dropdown;


    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME ="name";
    private static final String KEY_EMAIL ="email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        editText_name=findViewById(R.id.nameinput);
        editText_emil=findViewById(R.id.editTextTextEmailAddress1);
        button_save=findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name=sharedPreferences.getString(KEY_NAME,null);
        if(name != null){
            Intent intent=new Intent(userinfo.this,result.class);
            startActivity(intent);

        }
        button_save=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radio1);
        dropdown=findViewById(R.id.spinner);

        List<String> list= new ArrayList<>();
        list.add("45 - 55 kgs");
        list.add("55 - 65 kgs");
        list.add("65 - 75 kgs");
        list.add("75 - 85 kgs");


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.male:
                        Toast.makeText(getApplicationContext(),"male",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.female:
                        Toast.makeText(getApplicationContext(),"female",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue= parent.getItemAtPosition(position).toString();
                Toast.makeText(userinfo.this,"Selected"+itemvalue,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_NAME,editText_name.getText().toString());
                editor.putString(KEY_EMAIL,editText_emil.getText().toString());
                editor.apply();
                Intent intent= new Intent(userinfo.this,result.class);
                startActivity(intent);

                Toast.makeText(userinfo.this,"Setup complete",Toast.LENGTH_LONG).show();
            }
        });




    }





}


