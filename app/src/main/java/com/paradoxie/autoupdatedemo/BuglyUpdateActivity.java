package com.paradoxie.autoupdatedemo;/**
 * Created by xiehehe on 2016/10/13.
 */

import android.app.Activity;
import android.os.Bundle;

import com.tencent.bugly.Bugly;

/**
 * User: xiehehe
 * Date: 2016-10-13
 * Time: 13:16
 * FIXME
 */
public class BuglyUpdateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugly);
        Bugly.init(getApplicationContext(), "3fa52a53a0", true);//bugly自动升级
    }
}
