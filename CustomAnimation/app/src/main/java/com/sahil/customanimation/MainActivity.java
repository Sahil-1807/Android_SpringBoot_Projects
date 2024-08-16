package com.sahil.customanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sahil.customanimation.activities.AddEmployee;
import com.sahil.customanimation.activities.ShowEmployees;
import com.sahil.customanimation.model.Employee;
import com.sahil.customanimation.retrofit.EmployeeApi;
import com.sahil.customanimation.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button addButton, showButton;
    LottieAnimationView laview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.button_add);
        showButton = findViewById(R.id.button_show);

        // set OnClick Listener
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEmployee.class);
                startActivity(intent);
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowEmployees.class);
                startActivity(intent);
            }
        });
    }
}