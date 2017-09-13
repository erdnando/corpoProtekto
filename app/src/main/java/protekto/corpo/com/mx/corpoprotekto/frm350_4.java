package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm350_4 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm350_4);

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
                Shared300.setP350_17(String.valueOf(progress));

                ImageView image7=(ImageView)findViewById(R.id.imageView7);
                if(progress <= 3)
                    image7.setBackgroundResource(R.drawable.sad);
                else
                    image7.setBackgroundResource(R.drawable.happy);
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
                Shared300.setP350_18(String.valueOf(progress));

                ImageView image8=(ImageView)findViewById(R.id.imageView8);
                if(progress <= 3)
                    image8.setBackgroundResource(R.drawable.sad);
                else
                    image8.setBackgroundResource(R.drawable.happy);
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
                Shared300.setP350_19(String.valueOf(progress));

                ImageView image9=(ImageView)findViewById(R.id.imageView9);
                if(progress <= 3)
                    image9.setBackgroundResource(R.drawable.sad);
                else
                    image9.setBackgroundResource(R.drawable.happy);
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
        } else {
            Shared300.setP350_17(String.valueOf(SeekBarValue1));
        }

        SeekBar mFreqbar2 = (SeekBar) findViewById(R.id.sbPregunta8);
        int SeekBarValue2 = mFreqbar2.getProgress();
        if (SeekBarValue2 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 8!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP350_18(String.valueOf(SeekBarValue2));
        }

        SeekBar mFreqbar3 = (SeekBar) findViewById(R.id.sbPregunta9);
        int SeekBarValue3 = mFreqbar3.getProgress();
        if (SeekBarValue3 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 9!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP350_19(String.valueOf(SeekBarValue3));
        }


        String reto="5";
        String sesion="0";
        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared300.getP350_11()+
                "<paquete><pregunta>2</pregunta><respuesta>"+Shared300.getP350_12()+
                "<paquete><pregunta>3</pregunta><respuesta>"+Shared300.getP350_13()+
                "<paquete><pregunta>4</pregunta><respuesta>"+Shared300.getP350_14()+
                "<paquete><pregunta>5</pregunta><respuesta>"+Shared300.getP350_15()+
                "<paquete><pregunta>6</pregunta><respuesta>"+Shared300.getP350_16()+
                "<paquete><pregunta>7</pregunta><respuesta>"+Shared300.getP350_17()+
                "<paquete><pregunta>8</pregunta><respuesta>"+Shared300.getP350_18()+
                "<paquete><pregunta>9</pregunta><respuesta>"+Shared300.getP350_19()+
                "<paquete><pregunta>10</pregunta><respuesta>Fin</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD3","frm350_4",xmlPaquete, "frm350_5",reto,sesion, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                String res= resultado;

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
