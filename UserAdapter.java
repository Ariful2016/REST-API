package com.example.json_complex_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.json_complex_api.Models.Users;
import com.example.json_complex_api.R;
import com.example.json_complex_api.ViewHolders.UserViewHolder;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private List<Users> usersList;

    public UserAdapter(Context context, List<Users> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_users,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        Users users = usersList.get(position);

        holder.uname.setText("Name: " + users.getName());
        holder.username.setText("UserName: " + users.getUsername());
        holder.email.setText("Email: " + users.getEmail());

        holder.address.setText("Address:");

        holder.street.setText("Street: " + users.getAddress().getStreet());
        holder.suite.setText("Suite: " + users.getAddress().getSuite());
        holder.city.setText("City: " + users.getAddress().getCity());
        holder.zipcode.setText("ZipCode: " + users.getAddress().getZipcode());

        holder.geo.setText("Geo:");

        holder.lat.setText("Lat: " + users.getAddress().getGeo().getLat());
        holder.lng.setText("Lng: " + users.getAddress().getGeo().getLng());

        holder.phone.setText("Phone: " + users.getPhone());
        holder.website.setText("Website: " + users.getWebsite());

        holder.company.setText("Company:");

        holder.cname.setText("CompanyName: " + users.getCompany().getName());
        holder.catchPhrase.setText("CatchPhrase: " + users.getCompany().getCatchPhrase());
        holder.bs.setText("Bs: " + users.getCompany().getBs());



    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
