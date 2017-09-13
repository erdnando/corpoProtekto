package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm154 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm154);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        final SeekBar mFreqbar = (SeekBar) findViewById(R.id.mFreqbar);
        mFreqbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView)findViewById(R.id.lblIndicatorSeek);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared10.setP7R(String.valueOf(progress));

                ImageView imgFaceState = (ImageView)findViewById(R.id.imgFaceState);

                if(progress < 3)
                    imgFaceState.setBackgroundResource(R.drawable.sad);
                else
                    imgFaceState.setBackgroundResource(R.drawable.happy);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });


        //----------------re set respuestas
        try {

            mFreqbar.setProgress(Integer.parseInt(Shared10.getP7R()));
            mFreqbar.post(new Runnable() {
                @Override
                public void run() {
                    mFreqbar.setProgress(Integer.parseInt(Shared10.getP7R()));
                }
            });

        }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P7--------------------
        //no validation
        //mod1 1 1
        //-------------end valida 2 radioGroup---------P7--------------------
        final String frm = view.getTag().toString();

        String reto="4";
        String sesion="3";
        final String xmlPaquete=(
                        "<paquete><pregunta>1</pregunta><respuesta>"+Shared10.getP1R().trim() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared10.getP2R().trim() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared10.getP3R().trim() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared10.getP4R().trim() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared10.getP5R().trim() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared10.getP6R().trim() +"</respuesta>"+
                        "<pregunta>7</pregunta><respuesta>"+Shared10.getP7R().trim() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");



        UtilWS.callServerForResult(strUUID, "MOD1","frm154",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                // String res= resultado;
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
