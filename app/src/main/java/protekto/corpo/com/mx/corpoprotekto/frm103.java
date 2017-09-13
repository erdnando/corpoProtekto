package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm103 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm103);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        Button btnNext = (Button)findViewById(R.id.btnNext11);
        btnNext.setEnabled(true);
        btnNext.getBackground().setColorFilter(null);

        final SeekBar mFreqbar = (SeekBar) findViewById(R.id.mFreqbar);
        mFreqbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView)findViewById(R.id.lblIndicatorSeek);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared10.setP7(String.valueOf(progress));
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

            mFreqbar.setProgress(Integer.parseInt(Shared10.getP7()));
            mFreqbar.post(new Runnable() {
                @Override
                public void run() {
                    mFreqbar.setProgress(Integer.parseInt(Shared10.getP7()));
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
        Button btnNext = (Button)findViewById(R.id.btnNext11);
        btnNext.setEnabled(false);
        //btnNext.setClickable(false);
        btnNext.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        final String frm = view.getTag().toString();

        String reto="1";
        String sesion="1";
        final String xmlPaquete=("<paquete><pregunta>1</pregunta><respuesta>"+Shared10.getP1().trim() +"</respuesta>"+
                                     "<pregunta>2</pregunta><respuesta>"+Shared10.getP2().trim() +"</respuesta>"+
                                     "<pregunta>3</pregunta><respuesta>"+Shared10.getP3().trim() +"</respuesta>"+
                                     "<pregunta>4</pregunta><respuesta>"+Shared10.getP4().trim() +"</respuesta>"+
                                     "<pregunta>5</pregunta><respuesta>"+Shared10.getP5().trim() +"</respuesta>"+
                                     "<pregunta>6</pregunta><respuesta>"+Shared10.getP6().trim() +"</respuesta>"+
                                     "<pregunta>7</pregunta><respuesta>"+Shared10.getP7().trim() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");



        UtilWS.callServerForResult(strUUID, "MOD1","frm104",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------

                if(resultado.trim().startsWith("Mensaje")){
                    Toast.makeText(getBaseContext(),resultado,Toast.LENGTH_LONG).show();  //makeText(this, resultado,Toast.LENGTH_LONG).show();
                    Button btnNext = (Button)findViewById(R.id.btnNext11);
                    btnNext.setEnabled(true);
                    btnNext.getBackground().setColorFilter(null);

                    return;
                }else {
                    // String res= resultado;
                    Intent newView = null;
                    try {
                        newView = new Intent(getBaseContext(), Class.forName(this.getClass().getPackage().getName() + "." + frm));
                        newView.putExtra("UUID", strUUID);
                        newView.putExtra("nickname", nickname);
                        startActivity(newView);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                //--------------------end-----------------------------------
            }
        });
    }



    public void gotoFrmPrevio(View view) {

        //----------------valida 2 radioGroup---------P7--------------------
        //no validation
        //mod1 1 1
        //-------------end valida 2 radioGroup---------P7--------------------
        Button btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setEnabled(true);
        btnNext.getBackground().setColorFilter(null);

        final String frm = view.getTag().toString();

        Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            newView.putExtra("nickname", nickname);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onBackPressed() {
    }

}
