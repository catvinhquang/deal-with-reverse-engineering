package com.quangcv.dwre.no2_signature_recognition;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.quangcv.dwre.R;

import java.security.MessageDigest;

/**
 * Created by QuangCV on 11-Sep-2019
 **/

public class LoginActivity extends Activity {

    private String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context ctx = LoginActivity.this;
                final ProgressDialog dlg = new ProgressDialog(ctx);
                dlg.setMessage("Connecting...");
                dlg.show();

                button.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String origin = "70:2F:87:6A:67:48:0A:C1:7A:16:81:14:97:49:34:52:26:31:94:2D";
                        String current = getSignature(ctx, "SHA1");

                        if (origin.equals(current)) {
                            Toast.makeText(ctx, "Success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ctx, "Failure", Toast.LENGTH_SHORT).show();
                        }

                        TextView note = findViewById(R.id.note);
                        note.setText(current);

                        Log.e(TAG, current);
                        dlg.dismiss();
                    }
                }, 1000);
            }
        });
    }

    private String getSignature(Context c, String algorithm) {
        try {
            byte[] signature = c.getPackageManager()
                    .getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES)
                    .signatures[0]
                    .toByteArray();
            byte[] array = MessageDigest.getInstance(algorithm).digest(signature);

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                String s = Integer.toHexString(0xFF & array[i]);
                if (s.length() == 1) {
                    builder.append("0");
                }

                builder.append(s);

                if (i != array.length - 1) {
                    builder.append(':');
                }
            }
            return builder.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}