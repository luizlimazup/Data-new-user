package com.lcardoso.dadosdenovousuario.presenter;

import com.lcardoso.dadosdenovousuario.contract.UserContract;

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;

    public UserPresenter() {}

    @Override
    public void onStart(UserContract.View view) {
        this.view = view;
        view.setEditTexts();
        view.setSpinners();
        view.setButtons();
    }

    @Override
    public void onStop() {
        view = null;
    }

    @Override
    public void onResetButtonClicked() {
        view.clearForm();
    }

    @Override
    public void onSendButtonClicked() {
        view.navigateToNextScreen();
    }
}
