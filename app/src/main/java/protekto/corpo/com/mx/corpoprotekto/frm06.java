package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class frm06 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    private String nextFrm;

    private final Handler handler = new Handler();

    public interface Callback {
        void onResultReceived(String result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm06);

        Shared10.clean();
        Shared11.clean();
        Shared200.clean();
        Shared300.clean();

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");




        TextView lblBienvenidoOtraVez = (TextView) findViewById(R.id.lblBienvenidoOtraVez);

        if(nickname.trim().equalsIgnoreCase("noname")){
            lblBienvenidoOtraVez.setText("Que bueno que sigues, continuemos. ");
        }else {
            lblBienvenidoOtraVez.setText("Bienvenido otra vez " + nickname);
        }

        callServerForResult(strUUID, new frm06.Callback() {
            public void onResultReceived(String result) {
                //--------------------start-----------------------------------
                result=result.replace("\"","");
                String[] separated = result.split("@");
                String currentStep=separated[0];
                nextFrm=separated[1];
                ImageView imgLevel = (ImageView) findViewById(R.id.imgLevel);
                imgLevel.setBackgroundResource(getBaseContext().getResources().getIdentifier(currentStep.trim().toLowerCase(),"drawable", getBaseContext().getPackageName()));
                //--------------------end-----------------------------------
            }
        });
    }

    public void gotoFrm(final View view) {

        try{

           //solo hay q crearle su screen layout a la pantalla q interese mostrarlo
            int id = getResources().getIdentifier(nextFrm+"screen_layout", "layout", getPackageName());

            try{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                setContentView(id);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

            catch(Exception eee){

            }

            Thread background = new Thread() {
                public void run() {
                    try {
                        sleep(5000);
                        finish();

                        Intent newView = null;
                        try {
                            newView = new Intent(getBaseContext(), Class.forName(getClass().getPackage().getName() +"."+ nextFrm));
                            newView.putExtra("UUID", strUUID);
                            newView.putExtra("nickname", nickname);
                            startActivity(newView);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                    }
                }
            };
            background.start();
        }
        catch(Exception ex){

            Intent newView = null;
            try {
                newView = new Intent(getBaseContext(), Class.forName(getClass().getPackage().getName() +"."+ nextFrm));
                newView.putExtra("UUID", strUUID);
                newView.putExtra("nickname", nickname);
                startActivity(newView);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void callServerForResult(final String strUUID, final frm06.Callback callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/getStep");

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

    @Override
    public void onBackPressed() {
    }
}
