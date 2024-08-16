package com.sahil.customanimation.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahil.customanimation.R;

public class EmployeeHolder extends RecyclerView.ViewHolder {

    TextView name, location, branch;
    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.list_view_name);
        location = itemView.findViewById(R.id.list_view_location);
        branch = itemView.findViewById(R.id.list_view_branch);
    }
}
