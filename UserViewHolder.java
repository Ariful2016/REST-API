package com.example.json_complex_api.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.json_complex_api.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

  public   TextView uname,username,email,address,street,suite,city,zipcode,geo,lat,lng,phone,
            website,company,cname,catchPhrase,bs;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        uname = itemView.findViewById(R.id.uname);
        username = itemView.findViewById(R.id.username);
        email = itemView.findViewById(R.id.email);
        address = itemView.findViewById(R.id.address);
        street = itemView.findViewById(R.id.street);
        suite = itemView.findViewById(R.id.suite);
        city = itemView.findViewById(R.id.city);
        zipcode = itemView.findViewById(R.id.zipcode);
        geo = itemView.findViewById(R.id.geo);
        lat = itemView.findViewById(R.id.lat);
        lng = itemView.findViewById(R.id.lng);
        phone = itemView.findViewById(R.id.phone);
        website = itemView.findViewById(R.id.website);
        company = itemView.findViewById(R.id.company);
        cname = itemView.findViewById(R.id.cname);
        catchPhrase = itemView.findViewById(R.id.catchPhrase);
        bs = itemView.findViewById(R.id.bs);



    }
}
