package com.example.darth.search_recyclerview.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.darth.search_recyclerview.R;
import com.example.darth.search_recyclerview.controllers.SessionManager;
import com.example.darth.search_recyclerview.controllers.UserController;
import com.example.darth.search_recyclerview.model.LoginUserModel;
import com.example.darth.search_recyclerview.model.ResponseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.3.191:8080/cvsi-server/";
    private UserController userController;
    private Button button;
    private EditText emailET;
    private EditText passwordET;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(getApplicationContext());
        initViews();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();

                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute("1");

            }
        });
    }

    public void initViews() {
        emailET = (EditText) findViewById(R.id.email_et);
        emailET.setText("cvsiserver@gmail.com");
        passwordET = (EditText) findViewById(R.id.password_et);
        passwordET.setText("cvsiserver");
        button = (Button) findViewById(R.id.log_in_button);
    }

    public void onLoginButtonClick() {
        LoginUserModel userModel = new LoginUserModel();
        userModel.setEmail(emailET.getText().toString());
        userModel.setPassword(passwordET.getText().toString());
        userController = new UserController();
        userController.login(userModel, this.getApplicationContext());
    }

    public void getMainActivity() {
        Intent getListItemsIntent = new Intent(this, MainActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "LoginActivity");
        startActivityForResult(getListItemsIntent, result);
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0]) * 1000;

                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
                if (sessionManager.getToken() != null) {
                    getMainActivity();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            Log.w("RESP", resp);
            return resp;
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(LoginActivity.this,
                    "ProgressDialog",
                    "Loading...");
        }


        @Override
        protected void onProgressUpdate(String... text) {

        }
    }
}
