package com.example.thirdassignment.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.thirdassignment.Model.User;
import com.example.thirdassignment.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    private DashboardViewModel dashboardViewModel;
    EditText name, age, address;
    RadioGroup radioGroup;
    Button savebtn;
    String gender, Name, Age, Address;
    public static List<User> users = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        name = root.findViewById(R.id.name);
        age = root.findViewById(R.id.age);
        address = root.findViewById(R.id.address);
        radioGroup = root.findViewById(R.id.RG);
        savebtn = root.findViewById(R.id.btnSubmit);

        radioGroup.setOnCheckedChangeListener(this);
        savebtn.setOnClickListener(this);

        return root;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.RBMale){
            gender = "Male";
        }
        if(checkedId == R.id.RBFemale){
            gender = "Female";
        }
        if(checkedId == R.id.RBOther){
            gender = "Other";
        }
    }

    @Override
    public void onClick(View v) {
        Name = name.getText().toString();
        Age = age.getText().toString();
        Address = address.getText().toString();

        if(v.getId() == R.id.btnSubmit){
            if(validate()){
                users.add(new User(Name, gender, Age, Address));
                Toast.makeText(getContext(), "ALL OK", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validate(){
        if(TextUtils.isEmpty(Name)){
            name.setError("Enter Name");
            name.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(gender)){
            Toast.makeText(getContext(), "Please Select a Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(Age)){
            age.setError("Enter dob");
            age.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(Address)){
            address.setError("Enter dob");
            address.requestFocus();
            return false;
        }
        return true;
    }
}