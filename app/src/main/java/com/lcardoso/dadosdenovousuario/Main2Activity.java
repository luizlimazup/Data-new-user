package com.lcardoso.dadosdenovousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lcardoso.dadosdenovousuario.Model.User;

public class Main2Activity extends AppCompatActivity {

    TextView textName, textLastName, textPhone, textMobilePhone, textCpf, textSchool,textAdress,
             textNeighborhood, textState;
    Button  btnDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textName = findViewById(R.id.textName);
        textLastName = findViewById(R.id.textLastName);
        textPhone = findViewById(R.id.textPhone);
        textMobilePhone = findViewById(R.id.textMobilePhone);
        textCpf = findViewById(R.id.textCpf);
        textSchool = findViewById(R.id.textSchool);
        textAdress = findViewById(R.id.textAdress);
        textNeighborhood = findViewById(R.id.textNeighborhood);
        textState = findViewById(R.id.textState);
        btnDone = findViewById(R.id.btnDone);

        getUser();

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cadastro concluído com sucesso", Toast.LENGTH_SHORT)
                        .show();
                
                finish();
            }
        });
    }

    public void getUser(){

//       Bundle data = getIntent().getExtras();
//       User user = (User) data.getSerializable("user");

        User user = getIntent().getExtras().getParcelable("user");

        textName.setText(user.getName());
        textLastName.setText(user.getLastName());
        textPhone.setText(user.getPhone());
        textMobilePhone.setText(user.getMobilePhone());
        textCpf.setText(user.getCpf());
        textSchool.setText(user.getSchool());
        textAdress.setText(user.getAdress());
        textNeighborhood.setText(user.getNeighborhod());
        textState.setText(user.getState());

    }
}
