package com.example.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static String api = "https://jsonplaceholder.typicode.com";
    List<userModel>allUserList;
    RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiinterface.getUser().enqueue(new Callback<List<userModel>>() {
            @Override
            public void onResponse(Call<List<userModel>> call, Response<List<userModel>> response) {
                allUserList = response.body();
//                for (int i = 0 ;i<allUserList.size();i++){
//                    Log.e("api","onSuccess:"+allUserList.get(i).title);
//                }
                rec.setAdapter(new userAdapter(MainActivity.this,allUserList));
            }

            @Override
            public void onFailure(Call<List<userModel>> call, Throwable t) {
                Log.e("api","onFailure" +t.getLocalizedMessage());
            }
        });

    }
}