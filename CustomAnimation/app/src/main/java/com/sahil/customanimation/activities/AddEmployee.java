package com.sahil.customanimation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sahil.customanimation.MainActivity;
import com.sahil.customanimation.R;
import com.sahil.customanimation.model.Employee;
import com.sahil.customanimation.retrofit.EmployeeApi;
import com.sahil.customanimation.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        initializeComponents();
    }

    public void initializeComponents(){
        TextInputEditText inputEditName = findViewById(R.id.form_textFieldName);
        TextInputEditText inputEditBranch = findViewById(R.id.form_textFieldBranch);
        TextInputEditText inputEditLocation = findViewById(R.id.form_textFieldLocation);
        MaterialButton button = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

        button.setOnClickListener(view -> {
            String name = String.valueOf(inputEditName.getText());
            String Branch = String.valueOf(inputEditBranch.getText());
            String Location = String.valueOf(inputEditLocation.getText());

            Employee employee = new Employee();
            employee.setName(name);
            employee.setBranch(Branch);
            employee.setLocation(Location);

            employeeApi.save(employee)
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Toast.makeText(AddEmployee.this, "Save is successful you can see the entry.", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable throwable) {
                            Toast.makeText(AddEmployee.this, "Save is Failed check and try again..", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "error occurred.", throwable);
                        }
                    });
        });
    }
}