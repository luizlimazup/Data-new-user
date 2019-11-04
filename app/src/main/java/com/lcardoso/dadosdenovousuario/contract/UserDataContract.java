package com.lcardoso.dadosdenovousuario.contract;

import com.lcardoso.dadosdenovousuario.model.User;

public interface UserDataContract {

    interface View {
        void setTextViews();
        void setButton();
        void setFormData();
        void showMessage(String message);
        void finishActivity();
    }

    interface Presenter {
        void onStart();
        void onStop();
        void onDoneButtonClicked();
    }
}
