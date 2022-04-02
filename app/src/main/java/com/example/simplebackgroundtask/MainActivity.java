package com.example.simplebackgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Handler mHandler;
    private ProgressBar progressBar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        mHandler = new Handler();
    }


    public void startTask(View view) {
        mTextView.setText(R.string.loading); // hien thi chu loading
        progressBar.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);

//        new Thread(() ->{
//            // CV chay trong Background Thread / Worker Thread
//            URL url = null;
//            try {
//                url = new URL("https://gorest.co.in/public/v2/users");
//                HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//
//                // mTextView.setText(R.string.done); // err => dang o trong backgroud tread => k the update UI
//                mHandler.post(()->{
//                    // Nhung cau lenh trong nay se chay tren Main Thread / UI Thread
//                    progressBar.setVisibility(View.INVISIBLE);
//                    button.setVisibility(View.VISIBLE);
//                    mTextView.setText(response);
//                });
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();



//        ApiClient.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
//            @Override
//            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
//                ArrayList<User> userList = response.body();
//                mTextView.setText("Number of Users: " + userList.size());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//        });

//        ApiClient.getAPI().getUsersByID(2910).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                mTextView.setText(user.name);
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//        });

//        User user = new User();
//        user.gender = "male";
//        user.name = "Nguyen Thi No";
//        user.email = "no@test.com";
//        user.status = "inactive";
//
//        ApiClient.getAPI().addUser(user).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                mTextView.setText("User ID: " + user.id);
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//        });
    }
}