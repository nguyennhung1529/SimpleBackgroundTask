package com.example.simplebackgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class UserDetailActivity extends AppCompatActivity {
    // private TextView mUser;
    private TextView mID;
    private TextView mName;
    private TextView mEmail;
    private TextView mGender;
    private TextView mStatus;
    private String dtaUserString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        // mUser = findViewById(R.id.UserDetail);
        mID = findViewById(R.id.id);
        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mGender = findViewById(R.id.gender);
        mStatus = findViewById(R.id.status);

        Intent intent = getIntent();
        // Lấy dữ liệu từ intent
        dtaUserString = intent.getStringExtra("user");
        // mUser.setText(dtaString);

        try {
            JSONObject user = new JSONObject(dtaUserString);
            // mUser.setText(user.getString("name"));
            mID.setText(user.getString("id"));
            mName.setText(user.getString("name"));
            mEmail.setText(user.getString("email"));
            mGender.setText(user.getString("gender"));
            mStatus.setText(user.getString("status"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void navigation(View view) {
        if (view.getId() == R.id.btn_add_user) {
             startActivity(new Intent(this, AddUserActivity.class));
        } else if (view.getId() == R.id.btn_edit_user) {
            Intent intent = new Intent(this, UpdateUserDetailActivity.class);
            intent.putExtra("user", dtaUserString);
            startActivity(intent);
        }
    }
}