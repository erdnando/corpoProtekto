package protekto.corpo.com.mx.corpoprotekto;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by herna on 7/27/2017.
 */

public class DialogoRegistro extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    public String UUID;
    public String Tag;
    public String Clave;
    public String nickname;

    public DialogoRegistro(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogregistro);
        yes = (Button) findViewById(R.id.btn_yes);
        no = (Button) findViewById(R.id.btn_no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        TextView txt_aviso = (TextView)findViewById(R.id.txt_aviso);
        txt_aviso.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:

               //----------------------
                String frm = this.Tag;
                this.Clave=this.Clave.replace("\"","");

                EditText txt_Clave= (EditText)findViewById(R.id.txt_Clave);

                TextView txt_aviso = (TextView)findViewById(R.id.txt_aviso);
                txt_aviso.setVisibility(View.INVISIBLE);

                if(txt_Clave.getText().toString().trim().equals(this.Clave.trim())){//ok
                    Intent newView = null;
                    try {
                        newView = new Intent(this.getContext() , Class.forName(this.getClass().getPackage().getName() +"."+ frm));
                        newView.putExtra("UUID", this.UUID);
                        newView.putExtra("nickname",this.nickname);
                        this.getContext().startActivity(newView);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    c.finish();
                    break;
                }else{
                    //---------------cve incorrecta------------------------
                    //TextView txt_aviso = (TextView)findViewById(R.id.txt_aviso);
                    txt_aviso.setVisibility(View.VISIBLE);
                    txt_Clave.setText("");
                    break;
                    //---------------------------------------
                }
                //--------------------

            case R.id.btn_no:
                deleteUser();
                dismiss();
                break;
            default:
                break;
        }
        //dismiss();
    }








    private final Handler handler = new Handler();

    public interface Callback {
        void onResultReceived(String result);
    }

    private void deleteUser() {

        callServerForResult(this.UUID, new DialogoRegistro.Callback() {
            public void onResultReceived(String result) {
                //--------------------start-----------------------------------
                String res= result;
                //--------------------end-----------------------------------
            }
        });
    }

    public void callServerForResult(final String strUUID, final DialogoRegistro.Callback callback) {

        //inicia codigo call ws by get
        //-------------------------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                //----------------------------
                final StringBuilder sb = new StringBuilder();
                URL url = null; //Enter URL here
                try {
                    url = new URL("http://74.208.98.86/mx.com.corpo.protekto.api/Service1.svc/deleteUser");

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



}
