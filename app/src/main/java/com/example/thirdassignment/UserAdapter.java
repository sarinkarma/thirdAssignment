package com.example.thirdassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdassignment.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Holder>{

    List<User> userList = new ArrayList<>();
    private Context context;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.gender.setText(user.getGender());
        holder.address.setText(user.getAddress());
        holder.age.setText(user.getAge());
        String gender = user.getGender();
        if(gender == "Male"){
            holder.profileImg.setImageResource(R.drawable.male);
        }else if(gender == "Female"){
            holder.profileImg.setImageResource(R.drawable.female);
        }else{
            holder.profileImg.setImageResource(R.drawable.others);
        }

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userList.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        ImageView profileImg, delete;
        TextView name, age, address, gender;


        public Holder(@NonNull View itemView) {
            super(itemView);

            profileImg = itemView.findViewById(R.id.profileimg);
            age = itemView.findViewById(R.id.ageview);
            name = itemView.findViewById(R.id.nameview);
            address = itemView.findViewById(R.id.addressview);
            gender = itemView.findViewById(R.id.genderview);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
