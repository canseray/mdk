package com.mdk.myapplication;

import android.util.Base64;
import android.util.Pair;

import com.mdk.myapplication.helper.callbacks.Callback;

import org.w3c.dom.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APP {
   // public static String path = "http://192.168.0.10/MDK/mobil";

    public static String path ="http://www.limonist.ist/MDK/mobil";

    public static String base64Encode(String text) {
        byte[] data = null;
        try {
            data = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        return Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public static String base64Decode(String text) {
        byte[] data1 = Base64.decode(text, Base64.DEFAULT);
        String text1 = null;
        try {
            text1 = new String(data1, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            text1 = "fail";
        }

        return text1;
    }

    public static void get1(List<Pair<String, String>> nameValuePairs, String services_part, Callback callback) {

        try {
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            for (Pair<String, String> pair : nameValuePairs) {
                formBodyBuilder.add(pair.first, pair.second);
            }
            FormBody formBody = formBodyBuilder.build();

            Request.Builder builder = new Request.Builder();

            builder = builder.url(services_part);
            builder = builder.get();
            Request request = builder.build();

            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = null;
            try {
                response = okHttpClient.newCall(request).execute();
                callback.onResponse(response.body().string().replaceAll("[\\t\\n\\r]+",""));
              //  return response.body().string();
            } catch (IOException e) {
            //    return "fail";
            }
        } catch (Exception ex) {
            //return "fail";
        }
    }

    public static String getElement(Document parse, String element) {
        return parse.getElementsByTagName(element).getLength() > 0 ? parse.getElementsByTagName(element).item(0).getTextContent() : "";
    }
}
