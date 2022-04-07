package com.example.simplebackgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateUserDetailActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mEmail;
    private RadioGroup mGender;
    private RadioButton mMale;
    private RadioButton mFemale;
    private CheckBox mStatus;
    private String dtaUserString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_detail);

        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mGender = findViewById(R.id.radGroup_gender);
        mMale = findViewById(R.id.rad_mail);
        mFemale = findViewById(R.id.rad_femail);
        mStatus = findViewById(R.id.chk_status);

        // Lấy dữ liệu từ intent
        Intent intent = getIntent();
        dtaUserString = intent.getStringExtra("user");

        try {
            JSONObject user = new JSONObject(dtaUserString);
            mName.setText(user.getString("name"));
            mEmail.setText(user.getString("email"));

            if (user.getString("gender").equals("male"))
                 mMale.setChecked(true);
            else
                 mFemale.setChecked(true);

            if (user.getString("status").equals("active")) mStatus.setChecked(true);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void updateUser(View view) {

    }

    public void resetUser(View view) {
    }
}