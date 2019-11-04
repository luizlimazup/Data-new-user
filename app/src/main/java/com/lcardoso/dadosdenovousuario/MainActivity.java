package com.lcardoso.dadosdenovousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.lcardoso.dadosdenovousuario.Model.User;

public class MainActivity extends AppCompatActivity {

    EditText etName, etLastName, etPhone, etMobilePhone, etCpf, etAdress, etNeighborhood,
    etPassword, etPasswordConfim;
    Spinner spSchool, spState;
    Button btnSend, btnReset;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        etMobilePhone = findViewById(R.id.etMobilePhone);
        etCpf = findViewById(R.id.etCpf);
        etAdress = findViewById(R.id.etAdress);
        etNeighborhood = findViewById(R.id.etNeighborhood);
        etPassword = findViewById(R.id.etPassword);
        etPasswordConfim = findViewById(R.id.etPasswordConfim);
        spSchool = findViewById(R.id.spSchool);
        spState = findViewById(R.id.spState);

        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sendData();
            }
        });

        btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });

        ArrayAdapter adapterSchool = ArrayAdapter.createFromResource(this, R.array.school, R.layout.spinner_item);
        adapterSchool.setDropDownViewResource(R.layout.spinner_dropdown);
        ArrayAdapter adapterState = ArrayAdapter.createFromResource(this, R.array.state, R.layout.spinner_item);
        adapterState.setDropDownViewResource(R.layout.spinner_dropdown);

        spSchool.setAdapter(adapterSchool);
        spState.setAdapter(adapterState);
    }

    private void sendData() {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("user", registerUser());
        startActivity(intent);
        clearForm();

    }

    public User registerUser(){
        mUser = new User();

        mUser.setName(etName.getText().toString());
        mUser.setLastName(etLastName.getText().toString());
        mUser.setPhone(etPhone.getText().toString());
        mUser.setMobilePhone(etMobilePhone.getText().toString());
        mUser.setCpf(etCpf.getText().toString());
        mUser.setAdress(etAdress.getText().toString());
        mUser.setNeighborhod(etNeighborhood.getText().toString());
        mUser.setSchool(spSchool.getSelectedItem().toString());
        mUser.setState(spState.getSelectedItem().toString());

        return mUser;
    }

    public void clearForm(){

        etName.getText().clear();
        etLastName.getText().clear();
        etPhone.getText().clear();
        etMobilePhone.getText().clear();
        etCpf.getText().clear();
        etAdress.getText().clear();
        etNeighborhood.getText().clear();
        spSchool.setSelection(0);
        spState.setSelection(0);
        etPassword.getText().clear();
        etPasswordConfim.getText().clear();
    }
}
