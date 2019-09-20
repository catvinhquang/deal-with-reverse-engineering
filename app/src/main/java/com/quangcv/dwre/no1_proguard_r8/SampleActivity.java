package com.quangcv.dwre.no1_proguard_r8;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by QuangCV on 14-Sep-2019
 **/

public class SampleActivity extends Activity {

    private String TAG = SampleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sayHi("Android");
    }

    private void sayHi(String name) {
        if (name != null) {
            Log.e(TAG, "Hi " + name);
        } else {
            Log.e(TAG, "Hi Anonymous!");
        }
    }

    private void unusedMethod() {
        Log.e(TAG, "unusedMethod");
    }

}