package com.example.pkiProject.util;

import android.app.AlertDialog;
import android.content.Context;

public class DialogUtils {

    public static void showMessagge(Context context, String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", (dialog, which) -> { dialog.dismiss(); });
        alertDialog.show();
    }

}
