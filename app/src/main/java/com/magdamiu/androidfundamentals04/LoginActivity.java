package com.magdamiu.androidfundamentals04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailAddressEditText;
    private EditText phoneEditText;
    private CheckBox terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailAddressEditText = findViewById(R.id.emailAddressEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        terms = findViewById(R.id.termsCheckBox);

        emailAddressEditText.setText("android@gmail.com");
    }

    public void loginOnClick(View view) {
        String email = emailAddressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        if (email.isEmpty()) {
            emailAddressEditText.setError(getString(R.string.error_validate_email));
        }
        if (phone.isEmpty()) {
            phoneEditText.setError("Please fill the phone number");
        }
        if (terms.isChecked() == false) {
            Toast.makeText(this, "Please accept terms and conditions", Toast.LENGTH_LONG).show();
        }

        if (!email.isEmpty() && !phone.isEmpty() && terms.isChecked()) {
            Toast.makeText(this, email + " " + phone, Toast.LENGTH_LONG).show();
        }
    }

    private boolean isEmailValid(String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        } else {
            return false;
        }
    }
}
