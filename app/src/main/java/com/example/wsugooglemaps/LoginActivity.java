package com.example.wsugooglemaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText Username;
    private EditText Pass;
    private TextView Info;
    private Button Logon;
    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        /*/   // Username = (EditText)findViewById(R.id.etUsername);
        // Pass = (EditText)findViewById(R.id.etPass);
       //  Info = (TextView)findViewById(R.id.tvInfo);
        // Logon = (Button)findViewById(R.id.btnLogon);*/

        Logon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Pass.getText().toString());
            }
        });
    }

    private void validate(String username, String userPass){
        if((username == "Admin") && (userPass == "12345")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
            count--;

            Info.setText("Number of attempts remaining: " + String.valueOf(count));

            if(count == 0) {
                Logon.setEnabled(false);
            }
        }
    }
}
