package com.quangcv.dwre.no3_hide_view_ids;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;

import com.quangcv.dwre.R;

/**
 * Created by QuangCV on 06-Sep-2019
 **/

public class SampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyTextView v = new MyTextView(this);
        v.setId(R.id.my_text_view);
        v.setGravity(Gravity.CENTER);
        v.setText("Hello World!");
        setContentView(v);
    }

    public class MyTextView extends TextView {

        public MyTextView(Context context) {
            super(context);
        }

        // works on uiautomatorviewer
        @Override
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                info.setViewIdResourceName("(name removed)");
            }
        }

    }

    // works on uiautomatorviewer
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(new CustomContextWrapper(newBase));
//    }

}
