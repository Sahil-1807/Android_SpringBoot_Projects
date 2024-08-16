package com.sahil.customanimation.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sahil.customanimation.R;
import com.sahil.customanimation.adapter.EmployeeAdapter;
import com.sahil.customanimation.model.Employee;
import com.sahil.customanimation.retrofit.EmployeeApi;
import com.sahil.customanimation.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowEmployees extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employees);

        recyclerView = findViewById(R.id.employee_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.employee_add_float_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowEmployees.this, AddEmployee.class);
                startActivity(intent);
            }
        });

        loadEmployees();
    }

    private void loadEmployees(){
        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);
        employeeApi.getAllEmployee()
                .enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable throwable) {
                        Toast.makeText(ShowEmployees.this, "Failed to load the employees.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<Employee>  employeeList){
        EmployeeAdapter employeeAdapter = new EmployeeAdapter(employeeList);
        recyclerView.setAdapter(employeeAdapter);

    }
}