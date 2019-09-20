package com.quangcv.dwre.no3_hide_view_ids;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

/**
 * Created by QuangCV on 06-Sep-2019
 **/

public class CustomContextWrapper extends ContextWrapper {

    private CustomResources resources;

    public CustomContextWrapper(Context base) {
        super(base);
        resources = new CustomResources(base.getResources());
    }

    @Override
    public Resources getResources() {
        return resources;
    }

}