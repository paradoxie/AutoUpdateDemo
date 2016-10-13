package com.paradoxie.autoupdatedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button check, bugly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = (Button) findViewById(R.id.check_update);
        check.setOnClickListener(this);
        bugly = (Button) findViewById(R.id.bugly_updata);
        bugly.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.check_update:
                Toast.makeText(this, "heihei", Toast.LENGTH_LONG).show();
                break;
            case R.id.bugly_updata:
                startActivity(new Intent(this, BuglyUpdateActivity.class));
                break;
            default:
                break;
        }

    }
}
