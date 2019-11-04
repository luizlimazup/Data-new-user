package com.lcardoso.dadosdenovousuario.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lcardoso.dadosdenovousuario.R;
import com.lcardoso.dadosdenovousuario.contract.UserDataContract;
import com.lcardoso.dadosdenovousuario.model.User;
import com.lcardoso.dadosdenovousuario.presenter.UserDataPresenter;

public class UserDataActivity extends AppCompatActivity implements UserDataContract.View {

    private  TextView textName, textLastName, textPhone, textMobilePhone, textCpf, textSchool, textAdress,
             textNeighborhood, textState;
    private  Button btnDone;
    private UserDataContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        presenter = new UserDataPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void setTextViews() {
        textName = findViewById(R.id.textName);
        textLastName = findViewById(R.id.textLastName);
        textPhone = findViewById(R.id.textPhone);
        textMobilePhone = findViewById(R.id.textMobilePhone);
        textCpf = findViewById(R.id.textCpf);
        textSchool = findViewById(R.id.textSchool);
        textAdress = findViewById(R.id.textAdress);
        textNeighborhood = findViewById(R.id.textNeighborhood);
        textState = findViewById(R.id.textState);
    }

    @Override
    public void setButton() {
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDoneButtonClicked();
            }
        });
    }

    @Override
    public void setFormData() {
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

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void finishActivity() {
        super.onBackPressed();
    }
}
