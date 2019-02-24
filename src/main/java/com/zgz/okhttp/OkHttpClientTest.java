package com.zgz.okhttp;

import okhttp3.*;

import java.io.IOException;

public class OkHttpClientTest {

    private static OkHttpClient okHttpClient = new OkHttpClient();

    public void getAsyn(String url){
        Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call= okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("fail" +e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse: " + response.body().string());
            }
        });
    }

    public Response get(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
