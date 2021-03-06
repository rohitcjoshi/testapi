package com.rohit.android.testmvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rohit.android.testmvp.presenter.ILoginPresenter;
import com.rohit.android.testmvp.presenter.LoginPresenterImpl;
import com.rohit.android.testmvp.view.HomeActivity;
import com.rohit.android.testmvp.view.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText etEmailId;
    private EditText etPassword;
    private Button btnLogin;

    private ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmailId = findViewById(R.id.editEmailId);
        etPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);

        loginPresenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(etEmailId.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this.getApplicationContext(), message, Toast.LENGTH_SHORT, true).show();
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onLoginError(String errorMessage) {
        Toasty.error(this.getApplicationContext(), errorMessage, Toast.LENGTH_SHORT, true).show();
    }
}
