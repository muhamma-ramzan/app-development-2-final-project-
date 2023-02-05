package com.example.fitx;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    TextView textView_name,textView_email,textView_message;
    Button button_change;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME ="name";
    private static final String KEY_EMAIL ="email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView_name=findViewById(R.id.fullname);
        textView_email=findViewById(R.id.textemail);
        textView_message=findViewById(R.id.message);
        button_change=findViewById(R.id.change);


        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=sharedPreferences.getString(KEY_NAME,null);
        String email=sharedPreferences.getString(KEY_EMAIL,null);

        if (name != null|| email != null){
            textView_name.setText("Full name -"+name);
            textView_email.setText("Email -"+email);
        }
        button_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(result.this, "Now you can change.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





    }
}