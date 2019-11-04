package com.lcardoso.dadosdenovousuario.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.lcardoso.dadosdenovousuario.R;
import com.lcardoso.dadosdenovousuario.contract.UserContract;
import com.lcardoso.dadosdenovousuario.model.User;
import com.lcardoso.dadosdenovousuario.presenter.UserPresenter;

public class UserFormActivity extends AppCompatActivity implements UserContract.View {

    private EditText etName, etLastName, etPhone, etMobilePhone, etCpf, etAdress, etNeighborhood,
            etPassword, etPasswordConfim;
    private Spinner spSchool, spState;
    private Button btnSend, btnReset;
    private User mUser;
    private UserContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        presenter = new UserPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onStart(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onStop();
    }

    @Override
    public void setEditTexts() {
        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        etMobilePhone = findViewById(R.id.etMobilePhone);
        etCpf = findViewById(R.id.etCpf);
        etAdress = findViewById(R.id.etAdress);
        etNeighborhood = findViewById(R.id.etNeighborhood);
        etPassword = findViewById(R.id.etPassword);
        etPasswordConfim = findViewById(R.id.etPasswordConfim);
    }

    @Override
    public void setSpinners() {
        spSchool = findViewById(R.id.spSchool);
        spState = findViewById(R.id.spState);

        ArrayAdapter adapterSchool = ArrayAdapter.createFromResource(this, R.array.school, R.layout.spinner_item);
        adapterSchool.setDropDownViewResource(R.layout.spinner_dropdown);
        ArrayAdapter adapterState = ArrayAdapter.createFromResource(this, R.array.state, R.layout.spinner_item);
        adapterState.setDropDownViewResource(R.layout.spinner_dropdown);

        spSchool.setAdapter(adapterSchool);
        spState.setAdapter(adapterState);
    }

    @Override
    public void setButtons() {
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSendButtonClicked();
            }
        });

        btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onResetButtonClicked();
            }
        });
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(UserFormActivity.this, UserDataActivity.class);
        intent.putExtra("user", getFormData());
        startActivity(intent);
        clearForm();
    }

    @Override
    public User getFormData() {
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

    @Override
    public void clearForm() {
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
