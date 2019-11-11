package com.lcardoso.dadosdenovousuario.ui;

import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserDataActivityTest {

    @Mock
    UserDataActivity activity;
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
    public void onStop() {
        activity.onStop();
        Mockito.verify(activity, Mockito.times(1)).onStop();
    }

    @Test
    public void setTextViews() {
        activity.setTextViews();
        Mockito.verify(activity, Mockito.times(1)).setTextViews();
    }

    @Test
    public void setButton() {
        activity.setButton();
        Mockito.verify(activity, Mockito.times(1)).setButton();
    }

    @Test
    public void setFormData() {
        activity.setFormData();
        Mockito.verify(activity, Mockito.times(1)).setFormData();
    }

    @Test
    public void showMessage() {
        activity.showMessage("Test");
        Mockito.verify(activity, Mockito.times(1)).showMessage("Test");
    }

    @Test
    public void finishActivity() {
        activity.finishActivity();
        Mockito.verify(activity, Mockito.times(1)).finishActivity();
    }
}