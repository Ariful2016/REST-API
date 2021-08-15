package com.example.json_complex_api.Activies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.json_complex_api.Adapters.UserAdapter;
import com.example.json_complex_api.Models.Address;
import com.example.json_complex_api.Models.Company;
import com.example.json_complex_api.Models.Geo;
import com.example.json_complex_api.Models.Users;
import com.example.json_complex_api.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue;
    public final String url = "http://jsonplaceholder.typicode.com/users";

    List<Users> usersList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        usersList =new ArrayList<>();

        queue = Volley.newRequestQueue(MainActivity.this);

        getUserAllData();


    }

    private void getUserAllData() {

        JsonArrayRequest request =
                new JsonArrayRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                for(int i=0;i<response.length();i++)
                                {
                                    try {
                                        JSONObject jsonObject = response.getJSONObject(i);

                                        String lat = jsonObject.getJSONObject("address").getJSONObject("geo").getString("lat");
                                        String lng = jsonObject.getJSONObject("address").getJSONObject("geo").getString("lng");

                                        Geo geo = new Geo(lat,lng);

                                        String street = jsonObject.getJSONObject("address").getString("street");
                                        String suite = jsonObject.getJSONObject("address").getString("suite");
                                        String city = jsonObject.getJSONObject("address").getString("city");
                                        String zipcode = jsonObject.getJSONObject("address").getString("zipcode");

                                        Address address = new Address(street,suite,city,zipcode,geo);

                                        String cname = jsonObject.getJSONObject("company").getString("name");
                                        String catchPhrase = jsonObject.getJSONObject("company").getString("catchPhrase");
                                        String bs = jsonObject.getJSONObject("company").getString("bs");

                                        Company company = new Company(cname,catchPhrase,bs);

                                        int id = jsonObject.getInt("id");
                                        String name = jsonObject.getString("name");
                                        String username = jsonObject.getString("username");
                                        String email = jsonObject.getString("email");
                                        String phone = jsonObject.getString("phone");
                                        String website = jsonObject.getString("website");

                                        Users users = new Users(id,name,username,email,phone,website,address,company);

                                        usersList.add(users);


                                    } catch (JSONException e) {

                                        e.printStackTrace();
                                    }
                                }

                                UserAdapter adapter = new UserAdapter(MainActivity.this,usersList);

                                recyclerView.setAdapter(adapter);


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                            }
                        });


        queue.add(request);

    }
}