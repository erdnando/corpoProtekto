package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm201_4 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm201_4);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        //----------------re set respuestas
        try {
            RadioGroup grpRbM5 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta7);
            grpRbM5.check(Integer.parseInt(Shared200.getP7()));

        }catch(Exception ex){}
        //-----------------------------------

        final SeekBar mFreqbar2 = (SeekBar) findViewById(R.id.sbPregunta8);

        mFreqbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView) findViewById(R.id.tvDeSeekBarPregunta8);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared200.setP201_8(String.valueOf(progress));
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

        mFreqbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView) findViewById(R.id.tvDeSeekBarPregunta9);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared200.setP201_9(String.valueOf(progress));
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
        RadioGroup grpRbM7 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta7);
        int checkedRadioButtonId = grpRbM7.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 7!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP5(String.valueOf(checkedRadioButtonId));
            RadioButton rd = (RadioButton)findViewById(checkedRadioButtonId);
            Shared200.setP201_7(rd.getText().toString());
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


        //------------send to ws-------------------------------------
        final String frm = view.getTag().toString();

        String reto="0";
        String sesion="1";
        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared200.getP201_1().trim() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared200.getP201_2().trim() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared200.getP201_3().trim() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared200.getP201_4().trim() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared200.getP201_5().trim() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared200.getP201_6().trim() +"</respuesta>"+
                        "<pregunta>7</pregunta><respuesta>"+Shared200.getP201_7().trim() +"</respuesta>"+
                        "<pregunta>8</pregunta><respuesta>"+Shared200.getP201_8().trim() +"</respuesta>"+
                        "<pregunta>9</pregunta><respuesta>"+Shared200.getP201_9().trim() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");



        UtilWS.callServerForResult(strUUID, "MOD2","frm201_4",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
        //-----------------------save----------------------
        /*String frm = view.getTag().toString();

        Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onBackPressed() {
    }

}
