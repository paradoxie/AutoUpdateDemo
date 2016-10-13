package com.paradoxie.autoupdatedemo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button check, bugly;
    UpdateManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = (Button) findViewById(R.id.check_update);
        check.setOnClickListener(this);
        bugly = (Button) findViewById(R.id.bugly_updata);
        bugly.setOnClickListener(this);

        manager = new UpdateManager(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.check_update:
                RxPermissions.getInstance(this)
                        .request(
                                //Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE)//申请存储权限
                        .subscribe(new Action1<Boolean>() {
                            @Override
                            public void call(Boolean granted) {
                                if (granted) {
                                    //同意
                                    manager.checkUpdate();//点击检查更新；可放到oncreate方法中，则为  自动检测更新
                                } else {
                                    //不同意，给提示
                                    Toast.makeText(MainActivity.this, "检查更新后会将软件包下载至手机，请允许此项权限", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                break;
            case R.id.bugly_updata:
                startActivity(new Intent(this, BuglyUpdateActivity.class));
                break;
            default:
                break;
        }

    }
}
