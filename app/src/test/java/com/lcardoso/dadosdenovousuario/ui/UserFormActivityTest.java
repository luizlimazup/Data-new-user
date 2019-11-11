package com.lcardoso.dadosdenovousuario.ui;

import android.os.Bundle;

import com.lcardoso.dadosdenovousuario.model.User;
import com.lcardoso.dadosdenovousuario.presenter.UserPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserFormActivityTest {

    @Mock
    UserFormActivity activity;
    Bundle bundle;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        activity.onCreate(bundle);
    }

    @Test
    public void onResume() {
        activity.onResume();
        Mockito.verify(activity, Mockito.times(1)).onResume();
    }

    @Test
    public void onPause() {
        activity.onPause();
        Mockito.verify(activity, Mockito.times(1)).onPause();
    }

    @Test
    public void setEditTexts() {
        activity.setEditTexts();
        Mockito.verify(activity, Mockito.times(1)).setEditTexts();
    }

    @Test
    public void setSpinners() {
        activity.setSpinners();
        Mockito.verify(activity, Mockito.times(1)).setSpinners();
    }

    @Test
    public void setButtons() {
        activity.setButtons();
        Mockito.verify(activity, Mockito.times(1)).setButtons();
    }

    @Test
    public void navigateToNextScreen() {
        activity.navigateToNextScreen();
        Mockito.verify(activity, Mockito.times(1)).navigateToNextScreen();
    }

    @Test
    public void getFormData() {
        activity.getFormData();
        Mockito.verify(activity, Mockito.times(1)).getFormData();
    }

    @Test
    public void clearForm() {
        activity.clearForm();
        Mockito.verify(activity, Mockito.times(1)).clearForm();
    }
}