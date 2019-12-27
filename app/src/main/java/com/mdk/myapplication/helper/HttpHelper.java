package com.mdk.myapplication.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Pair;

import com.mdk.myapplication.APP;
import com.mdk.myapplication.helper.callbacks.Callback;
import com.mdk.myapplication.helper.callbacks.HomeScreenCallback;
import com.mdk.myapplication.helper.callbacks.LoginCallback;
import com.mdk.myapplication.model.HomeCardsItem;
import com.mdk.myapplication.model.IntroScreenItem;
import com.mdk.myapplication.helper.callbacks.IntroScreenItemCallback;
import com.mdk.myapplication.model.Login;

import org.w3c.dom.Document;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class HttpHelper {
    private final String TAG = HttpHelper.class.getName();

   public static class IntroScreenRequest extends AsyncTask<String, Void, String> {
       private Context context;
       private IntroScreenItemCallback introScreenItemCallback;

       public IntroScreenRequest(Context context,IntroScreenItemCallback introScreenItemCallback) {
           this.context = context;
           this.introScreenItemCallback = introScreenItemCallback;
       }

       ArrayList<IntroScreenItem> results;
        String[] part1, part2;
        String part3, part4;

        protected String doInBackground(String... args) {

            results = new ArrayList<>();

            List<Pair<String, String>> nameValuePairs = new ArrayList<>();

/*
		nameValuePairs.add(new Pair<>("param1", APP.base64Encode("SOME_STRING_VALUE")));
		nameValuePairs.add(new Pair<>("param2", APP.base64Encode("SOME_STRING_VALUE")));
		nameValuePairs.add(new Pair<>("param3", APP.base64Encode("SOME_STRING_VALUE")));
*/

            APP.get1(nameValuePairs, APP.path + "/get_intro_screen_items.php", new Callback() {
                @Override
                public void onResponse(String response) {
                    String xml = response;

                    if (xml != null && !xml.contentEquals("") && !xml.contentEquals("fail")) {

                        try {
                            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                            Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));


                            for (int i = 0; i < parse.getElementsByTagName("row").getLength(); i++) {
                                part1 = APP.base64Decode(APP.getElement(parse, "part1")).split("\\[##\\]");
                                part2 = APP.base64Decode(APP.getElement(parse, "part2")).split("\\[#\\]");
                                part3 = APP.base64Decode(APP.getElement(parse, "part3"));
                                part4 = APP.base64Decode(APP.getElement(parse, "part4"));
                            }


                            if (part3.contentEquals("")) {

                                PackageInfo pInfo = null;

                                try {
                                    pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                                } catch (PackageManager.NameNotFoundException e) {
                                    e.printStackTrace();
                                }
                                String version = pInfo.versionName;



                                if (part4.contentEquals(version)) {

                                    if (!part1[0].contentEquals("")) {

                                        for (int i = 0; i < part1.length; i++) {
                                            String[] temp = part1[i].split("\\[#\\]");
                                            IntroScreenItem ai = new IntroScreenItem(
                                                    temp.length > 0 ? temp[0] : "", temp.length > 1 ? temp[1] : "",
                                                    temp.length > 2 ? temp[2] : "", temp.length > 3 ? temp[3] : "");
                                            results.add(ai);
                                        }
                                        introScreenItemCallback.onSuccess(results);

                                    }

                                    //return "true";
                                } else {
                                    introScreenItemCallback.onUpdate();
                                    //return "version";
                                }
                            } else {
                                if (!part3.contentEquals("")) {

                                    introScreenItemCallback.onRepair();
                                    //return "repair";
                                } else {
                                    introScreenItemCallback.onError();
                                    //return "hata";
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            // return "false";
                        }

                    } else {
                        //return "false";
                    }
                }
            });
            return "false";

        }

        protected void onPostExecute(String result) {
            ProgressDialog pd= new ProgressDialog(context);
            pd.setMessage("Lütfen bekleyiniz..");
            pd.show();

            if (pd != null)
                pd.dismiss();
            if (result.contentEquals("true")) {
               // setInfoFragments();
            } else {
                // Kullanıcıya hata hakkında bilgi vermek için kullanılır. Toast mesajı olabilir, AlertDialog olabilir.
            }
        }
    }

    public static class HomeScreenRequest extends AsyncTask<String, Void, String>{
        private Context context;
        private HomeScreenCallback homeScreenCallback;

        public HomeScreenRequest(Context context, HomeScreenCallback homeScreenCallback) {
            this.context = context;
            this.homeScreenCallback = homeScreenCallback;
        }

         ArrayList<HomeCardsItem> results;
         String[] part11;

        @Override
        protected String doInBackground(String... strings) {

            results = new ArrayList<>();

            List<Pair<String, String>> nameValuePairs = new ArrayList<>();

            APP.get1(nameValuePairs, APP.path + "/init_scr.php", new Callback() {
                @Override
                public void onResponse(String response) {

                    String xml = response;
                    if (xml != null && !xml.contentEquals("") && !xml.contentEquals("fail")){
                        try{
                            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                            Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));

                            part11 = APP.base64Decode(APP.getElement(parse, "part11")).split("\\[##\\]");

                            if (!part11[0].contentEquals("")){
                                for (int i = 0; i < part11.length; i++){
                                    String[] temp = part11[i].split("\\[#\\]");
                                    HomeCardsItem ai = new HomeCardsItem (
                                            temp.length > 0 ? temp[0] : "", temp.length > 1 ? temp[1] : "",
                                            temp.length > 2 ? temp[2] : "", temp.length > 3 ? temp[3] : "",
                                            temp.length > 4 ? temp[4] : "");

                                    results.add(ai);
                                }
                                homeScreenCallback.onSuccess(results);
                            } else {
                                homeScreenCallback.onError();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {

                    }
                }
            });

            return "false";
        }
    }

    public static class LoginRequest extends AsyncTask<String, Void, String>{
       private Context context;
       private LoginCallback loginCallback;

       public LoginRequest(Context context, LoginCallback loginCallback){
           this.context = context;
           this.loginCallback = loginCallback;
       }

        @Override
        protected String doInBackground(String... strings) {

            return null;
        }
    }

    public static class NewAccountRequest extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}







