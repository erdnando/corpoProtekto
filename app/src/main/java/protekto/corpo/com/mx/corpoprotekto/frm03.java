package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class frm03 extends AppCompatActivity {

    private final Handler handler = new Handler();

    public interface Callback {
        void onResultReceived(String result);
    }


    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm03);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        callServerForResult(strUUID, new frm03.Callback() {
            public void onResultReceived(String result) {
                //--------------------start-----------------------------------
                 String res= result;
                //--------------------end-----------------------------------
            }
        });


    }

    public void callServerForResult(final String strUUID, final frm03.Callback callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/confirma");

                    HttpURLConnection httpURLConnection = null;
                    httpURLConnection = (HttpURLConnection)url.openConnection();

                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.

                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                    httpURLConnection.connect();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("strUUID", strUUID);


                    DataOutputStream wr = null;
                    wr = new DataOutputStream(httpURLConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());
                    wr.flush();
                    wr.close();

                    //-------------
                    int HttpResult =httpURLConnection.getResponseCode();
                    if(HttpResult ==HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                httpURLConnection.getInputStream(),"utf-8"));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        br.close();

                        //output from ws by post
                        // Use a handler to invoke the callback on the main thread
                        handler.post(new Runnable() {
                            public void run() {
                                callback.onResultReceived(sb.toString());
                            }
                        });

                    }else{
                        System.out.println(httpURLConnection.getResponseMessage());
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //----------------------------
            }
        }).start();
        // --------end of code--------------------
    }


    public void gotoFrm(View view) {
        String frm = view.getTag().toString();

        Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            newView.putExtra("nickname", nickname);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
    }
}
