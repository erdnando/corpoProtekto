package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm301_4 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm301_4);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        final SeekBar mFreqbar1 = (SeekBar) findViewById(R.id.sbPregunta7);
        mFreqbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView)findViewById(R.id.tvDeSeekBarPregunta7);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared300.setP301_4S7(String.valueOf(progress));
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





        final SeekBar mFreqbar2 = (SeekBar) findViewById(R.id.sbPregunta8);
        mFreqbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView)findViewById(R.id.tvDeSeekBarPregunta8);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared300.setP301_4S8(String.valueOf(progress));
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





        final SeekBar mFreqbar3 = (SeekBar) findViewById(R.id.sbPregunta9);
        mFreqbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView)findViewById(R.id.tvDeSeekBarPregunta9);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared300.setP301_4S9(String.valueOf(progress));
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

    }

    public void gotoFrm(View view) {

        SeekBar mFreqbar1 = (SeekBar) findViewById(R.id.sbPregunta7);
        int SeekBarValue1 = mFreqbar1.getProgress();
        if (SeekBarValue1 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 7!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar mFreqbar2 = (SeekBar) findViewById(R.id.sbPregunta8);
        int SeekBarValue2 = mFreqbar2.getProgress();
        if (SeekBarValue2 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 8!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar mFreqbar3 = (SeekBar) findViewById(R.id.sbPregunta9);
        int SeekBarValue3 = mFreqbar3.getProgress();
        if (SeekBarValue3 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 9!", Toast.LENGTH_LONG).show();
            return;
        }



        final String frm = view.getTag().toString();

        String reto="1";
        String sesion="0";


        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared300.getP301_1G1() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared300.getP301_1G2() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared300.getP301_2G1() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared300.getP301_2G2() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared300.getP301_3G1() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared300.getP301_3G2() +"</respuesta>"+
                        "<pregunta>7</pregunta><respuesta>"+Shared300.getP301_4S7() +"</respuesta>"+
                        "<pregunta>8</pregunta><respuesta>"+Shared300.getP301_4S8() +"</respuesta>"+
                        "<pregunta>9</pregunta><respuesta>"+Shared300.getP301_4S9() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD3","frm301_4",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
        /*String frm = view.getTag().toString();

        Intent newView = null;
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
