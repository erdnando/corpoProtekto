package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm153 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm153);
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
                Shared10.setP6R(String.valueOf(progress));


                ImageView imgFaceState = (ImageView)findViewById(R.id.imgFaceState);

                if(progress <= 3)
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

        RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM1);

        try {
            grpRbM1.check(Integer.parseInt(Shared10.getP5R()));

            mFreqbar.setProgress(Integer.parseInt(Shared10.getP6R()));
            mFreqbar.post(new Runnable() {
                @Override
                public void run() {
                    mFreqbar.setProgress(Integer.parseInt(Shared10.getP6R()));
                }
            });

        }catch(Exception ex){}
        //-----------------------------------
        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd1c=(RadioButton)findViewById(R.id.rd1c);
                //rd1c.setTypeface(null, Typeface.BOLD);
                SpannableString content = new SpannableString(rd1c.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd1c.setText(content);
                //rd1c.setEnabled(false);
                //group.setEnabled(false);
                ((RadioButton)findViewById(R.id.rd1a)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd1b)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd1c)).setEnabled(false);
            }
        });

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
            RadioButton rd=(RadioButton)findViewById(checkedRadioButtonId) ;
            Shared10.setP5R(rd.getText().toString());
        }

        //TextView lblIndicatorSeek = (TextView)findViewById(R.id.lblIndicatorSeek);
        //Shared10.setP6(lblIndicatorSeek.getText().toString());

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
