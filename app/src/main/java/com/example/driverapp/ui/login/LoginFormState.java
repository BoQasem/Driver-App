package com.example.driverapp.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
public class LoginFormState {
    @Nullable
    private Integer phoneNumberEditText;
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    LoginFormState(@Nullable Integer phoneNumberEditText, @Nullable Integer passwordError) {
        this.phoneNumberEditText = phoneNumberEditText;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.phoneNumberEditText = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getphoneNumberEditText() {
        return phoneNumberEditText;
    }

    @Nullable
    public Integer getPasswordError() {
        return passwordError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}