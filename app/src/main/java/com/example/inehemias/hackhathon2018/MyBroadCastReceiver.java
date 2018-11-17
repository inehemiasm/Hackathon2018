package com.example.inehemias.hackhathon2018;

public class MyBroadCastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.content.Intent start = new android.content.Intent(context, AlertActivity.class);
            context.startActivity(start);

    }
}