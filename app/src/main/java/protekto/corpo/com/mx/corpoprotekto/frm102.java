package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm102 extends AppCompatActivity {


    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm102);
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
                Shared10.setP6(String.valueOf(progress));
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
            RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM1);
            //grpRbM1.check(Integer.parseInt(Shared10.getP5()));
            if(Shared10.getP5().trim().startsWith("La escuela"))
                ((RadioButton)grpRbM1.getChildAt(0)).setChecked(true);
            else if(Shared10.getP5().trim().startsWith("La familia"))
                ((RadioButton)grpRbM1.getChildAt(1)).setChecked(true);
            else
                ((RadioButton)grpRbM1.getChildAt(2)).setChecked(true);

            mFreqbar.setProgress(Integer.parseInt(Shared10.getP6()));
            mFreqbar.post(new Runnable() {
                @Override
                public void run() {
                    mFreqbar.setProgress(Integer.parseInt(Shared10.getP6()));
                }
            });

        }catch(Exception ex){}
        //-----------------------------------
    }

    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P5,P6--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM1);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            //Shared10.setP5(String.valueOf(checkedRadioButtonId));
            RadioButton rdb=(RadioButton)findViewById(checkedRadioButtonId);
            Shared10.setP5(rdb.getText().toString());
        }


        //-------------end valida 2 radioGroup---------P5,P6--------------------


        String frm = view.getTag().toString();

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
