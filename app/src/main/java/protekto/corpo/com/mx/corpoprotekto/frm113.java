package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class frm113 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    private String image64="";

    ImageView fototMejor;
    private final Handler handler = new Handler();

    public interface Callback {
        void onResultReceived(String result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm113);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        fototMejor = (ImageView) findViewById(R.id.fototMejor);

        //----------------re set respuestas
        try {
            if(Shared11.getrdF1().equals(true)){
                fototMejor.setImageBitmap(Shared11.getF1());

                /*ByteArrayOutputStream stream=new ByteArrayOutputStream();
                Shared11.getF1().compress(Bitmap.CompressFormat.PNG, 90, stream);
                byte[] image=stream.toByteArray();
                image64 = Base64.encodeToString(image, 0);*/
                image64 = Shared11.getBase64(Shared11.getF1());
            }
            if(Shared11.getrdF2().equals(true)){
                fototMejor.setImageBitmap(Shared11.getF2());
                image64 = Shared11.getBase64(Shared11.getF2());

            }
            if(Shared11.getrdF3().equals(true)){
                fototMejor.setImageBitmap(Shared11.getF3());
                image64 = Shared11.getBase64(Shared11.getF3());
            }
        }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida 2 radioGroup---------P5,P6--------------------
        /*if(Shared11.getrdF1().equals(false) && Shared11.getrdF2().equals(false) &&  Shared11.getrdF3().equals(false)){
            Toast.makeText(this, "No ha seleccionado una foto!",Toast.LENGTH_LONG).show();
            return;
        }*/
        final String frm = view.getTag().toString();
        final String reto="0";
        final String sesion="2";


        fototMejor = (ImageView) findViewById(R.id.fototMejor);



        UtilWS.callServerForResult(strUUID, "MOD1","frm113",image64, frm,reto,sesion, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                Intent newView = null;
                try {
                    newView = new Intent(getBaseContext(), Class.forName(this.getClass().getPackage().getName() +"."+ frm ));
                    newView.putExtra("UUID", strUUID);
                    newView.putExtra("nickname", nickname);
                    startActivity(newView);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                //--------------------end-----------------------------------
            }
        });
        //-------------end valida 2 radioGroup---------P5,P6--------------------

        /*Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            newView.putExtra("nickname", nickname);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }


    @Override
    public void onBackPressed() {
    }
}

