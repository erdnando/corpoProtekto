package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class frm02 extends AppCompatActivity {


    private final Handler handler = new Handler();

    public interface Callback {
        void onResultReceived(String result, String tag);
    }

    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_frm02);
        setContentView(R.layout.activity_frm02);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setEnabled(true);
        btnIniciar.getBackground().setColorFilter(null);
    }

    public void gotoFrm(View view) {

        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setEnabled(false);
        btnIniciar.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        EditText txtNickname = (EditText) findViewById(R.id.txtNickname);
        EditText txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        RadioButton radioButtonM = (RadioButton) findViewById(R.id.radioButtonM);
        RadioButton radioButtonH = (RadioButton) findViewById(R.id.radioButtonH);



        if (txtNickname.getText().toString().trim().equalsIgnoreCase("")) {
        // No item selected
         Toast.makeText(this, "No ha ingresado un nickname!",Toast.LENGTH_LONG).show();
            btnIniciar.setEnabled(true);
            btnIniciar.getBackground().setColorFilter(null);
         return;
        }

        if (txtCorreo.getText().toString().trim().equalsIgnoreCase("")) {
            // No item selected
            Toast.makeText(this, "No ha ingresado un email!",Toast.LENGTH_LONG).show();
            btnIniciar.setEnabled(true);
            btnIniciar.getBackground().setColorFilter(null);
            return;
        }
        RadioGroup grpRb1 = (RadioGroup)findViewById(R.id.grpRb1);
        int checkedRadioButtonId = grpRb1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
        // No item selected
         Toast.makeText(this, "Seleccione una opcion para el sexo!",Toast.LENGTH_LONG).show();
            btnIniciar.setEnabled(true);
            btnIniciar.getBackground().setColorFilter(null);
         return;
        }





        String tag = view.getTag().toString();
        //generate <code>
        //send email
        callServerForResult(strUUID, txtNickname.getText().toString(),txtCorreo.getText().toString(),"H", tag, new frm02.Callback() {
            public void onResultReceived(String resultado,String tag) {
                //--------------------start-----------------------------------
               // String res= resultado;

                DialogoRegistro cdd=new DialogoRegistro(frm02.this);
                cdd.UUID=strUUID;
                cdd.Tag= tag;// view.getTag().toString();
                cdd.Clave=resultado.replace("OK","").replace("\"","");
                cdd.nickname=((EditText) findViewById(R.id.txtNickname)).getText().toString();
                cdd.show();
                cdd.setCancelable(false);
                cdd.setCanceledOnTouchOutside(false);

                Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
                btnIniciar.setEnabled(true);
                btnIniciar.getBackground().setColorFilter(null);
                //--------------------end-----------------------------------
            }
        });
        /*AlertDialog alertDialog = new AlertDialog.Builder(frm02.this).create();
        alertDialog.setTitle("Alertx");
        alertDialog.setMessage("Alert message to be shownx");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();*/

        /*String frm = view.getTag().toString();

        Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }


    public void callServerForResult(final String strUUID, final String txtNickname,final String txtCorreo,final String sexo,final String tag, final frm02.Callback callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/registra");

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
                    jsonObject.put("nickname", txtNickname);
                    jsonObject.put("mailDestino", txtCorreo);
                    jsonObject.put("sexo", sexo);

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
                                callback.onResultReceived(sb.toString(), tag);
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
