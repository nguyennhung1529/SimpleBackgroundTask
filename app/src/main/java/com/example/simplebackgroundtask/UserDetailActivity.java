package com.example.simplebackgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserDetailActivity extends AppCompatActivity {
    private TextView mUser;
    private JSONObject jObject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        mUser = findViewById(R.id.UserDetail);
        Intent intent = getIntent();
        // Lấy dữ liệu từ intent
        String dtaString = intent.getStringExtra("user");
        mUser.setText(dtaString);

        try {
            JSONObject user = new JSONObject(dtaString);
            mUser.setText(user.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}