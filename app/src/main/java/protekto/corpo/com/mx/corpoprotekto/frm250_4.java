package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm250_4 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm250_4);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta7);

        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd1c=(RadioButton)findViewById(R.id.rbM3P5R1);//correcto
                SpannableString content = new SpannableString(rd1c.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd1c.setText(content);
                //rd1c.setEnabled(false);
               // group.setEnabled(false);


                ((RadioButton)findViewById(R.id.rbM3P5R1)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P5R2)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P5R3)).setEnabled(false);

                RadioButton rdChecked=(RadioButton)findViewById(checkedId);
                Shared200.setP250_4G1(rdChecked.getText().toString());
            }
        });

        final SeekBar mFreqbar2 = (SeekBar) findViewById(R.id.sbPregunta8);

        mFreqbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView) findViewById(R.id.tvDeSeekBarPregunta8);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared200.setP250_4S1(String.valueOf(progress));

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

        mFreqbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView) findViewById(R.id.tvDeSeekBarPregunta9);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared200.setP250_4S2(String.valueOf(progress));
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
        RadioGroup grpRbM5 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta7);
        int checkedRadioButtonId = grpRbM5.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
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

        String reto="4";
        String sesion="4";


        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared200.getP250_1G1() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared200.getP250_1G2() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared200.getP250_2G1() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared200.getP250_2G2() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared200.getP250_3G1() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared200.getP250_3G2() +"</respuesta>"+
                        "<pregunta>7</pregunta><respuesta>"+Shared200.getP250_4G1() +"</respuesta>"+
                        "<pregunta>8</pregunta><respuesta>"+Shared200.getP250_4S1() +"</respuesta>"+
                        "<pregunta>9</pregunta><respuesta>"+Shared200.getP250_4S2() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD2","frm250_4",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
        //---------------------------------------------
       /* String frm = view.getTag().toString();

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
