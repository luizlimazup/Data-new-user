package com.lcardoso.dadosdenovousuario.contract;

import com.lcardoso.dadosdenovousuario.model.User;

public interface UserContract {

    interface View {
        void setEditTexts();
        void setSpinners();
        void setButtons();
        void navigateToNextScreen();
        User getFormData();
        void clearForm();
    }

    interface Presenter {
        void onStart(UserContract.View view);
        void onStop();
        void onResetButtonClicked();
        void onSendButtonClicked();
    }
}
