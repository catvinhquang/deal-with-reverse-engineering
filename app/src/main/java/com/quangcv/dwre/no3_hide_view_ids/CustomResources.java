package com.quangcv.dwre.no3_hide_view_ids;

import android.content.res.Resources;
import android.util.Log;

/**
 * Created by QuangCV on 06-Sep-2019
 **/

public class CustomResources extends Resources {

    private String TAG = CustomResources.class.getSimpleName();

    public CustomResources(Resources res) {
        super(res.getAssets(), res.getDisplayMetrics(), res.getConfiguration());
    }

    // works on uiautomatorviewer
    @Override
    public String getResourceName(int resid) throws NotFoundException {
        Log.e(TAG, "getResourceName: " + super.getResourceName(resid));
        return "(name removed)";
    }

    // works on "adb shell dumpsys activity top"
    @Override
    public String getResourceEntryName(int resid) throws NotFoundException {
        Log.e(TAG, "getResourceEntryName: " + super.getResourceEntryName(resid));
        return "(name removed)";
    }

}