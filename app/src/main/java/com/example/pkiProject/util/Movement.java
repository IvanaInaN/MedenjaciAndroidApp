package com.example.pkiProject.util;

import android.app.Activity;
import android.content.Intent;


import com.example.pkiProject.basket.BasketActivity;
import com.example.pkiProject.user.User;
import com.example.pkiProject.user.UserActivity;

public class Movement {

    public static void startUserActivity(Activity activity, User user){
        Intent intent = new Intent(activity, UserActivity.class);
        intent.putExtra(AppConstants.CURRENT_USER, user);
        activity.startActivity(intent);
    }

    public static void startBasketActivity(Activity activity){
        Intent intent = new Intent(activity, BasketActivity.class);
        activity.startActivity(intent);
    }

}
