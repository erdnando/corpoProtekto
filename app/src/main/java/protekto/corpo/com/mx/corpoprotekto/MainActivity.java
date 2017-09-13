package protekto.corpo.com.mx.corpoprotekto;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
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
import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

//import static protekto.corpo.com.mx.corpoprotekto.R.id.imgLevel;

public class MainActivity extends AppCompatActivity {

    //public final static String EXTRA_MESSAGE = "UUID";
    /*private final Handler handler = new Handler();

    public interface Callback {
        void onResultReceived(String result, String strUUID);
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        /*if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }*/


        String modelo = Build.MODEL;
        String SODevice = String.valueOf(Build.VERSION.RELEASE);
        String UniqueDeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        //llamda ws
        UtilWS.callServerForValidaUUID(UniqueDeviceID, modelo, new UtilWS.Callback2Resultados() {
            public void onResultReceived(String frm,String UUID) {
                //--------------------start-----------------------------------
                //controla que vista se carga, dependiendo el estatus del usuario
                //conectar con ws para ver el estatus del usuario
                //en caso de q no exista mostrar opciones de registro
                //en caso contrario mostrar pantalla de su ultimo estatus

                //si es 1a vez lo manda a la frm00
                // si es una posterior manda a frm06
                setDynamicLayout(frm,UUID);


                //--------------------end-----------------------------------
            }
        });




    }





    private void setDynamicLayout(String frm,String UUID) {

        frm=frm.replace("\"","");
        String[] separated = frm.split("@");
        frm=separated[0];
        String nickname=separated[1];
        Intent newView = null;



        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", UUID);
            newView.putExtra("nickname", nickname);

            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
    }

}
