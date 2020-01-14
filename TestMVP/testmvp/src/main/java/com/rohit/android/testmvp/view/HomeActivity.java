package com.rohit.android.testmvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rohit.android.testmvp.R;
import com.rohit.android.testmvp.presenter.HomePresenterImpl;
import com.rohit.android.testmvp.presenter.IHomePresenter;

public class HomeActivity extends AppCompatActivity implements IHomeView {

    private TextView tvInfo;
    private Button btnUpdate;
    private IHomePresenter homePresenter;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homePresenter = new HomePresenterImpl(this);

        tvInfo = findViewById(R.id.homeTextInfoTV);
        btnUpdate = findViewById(R.id.btnHomeUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePresenter.onButtonClick();
            }
        });
    }

    @Override
    public void updateText() {
        counter++;
        if(counter % 2 != 0) {
            tvInfo.setText(R.string.home_page_text_update);
        } else {
            tvInfo.setText(R.string.home_page_text);
        }
    }
}
