package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm331_4 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm331_4);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");



        final SeekBar sbPregunta7 = (SeekBar) findViewById(R.id.sbPregunta7);

        sbPregunta7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView lblIndicatorSeek = (TextView) findViewById(R.id.tvDeSeekBarPregunta7);
                lblIndicatorSeek.setText(String.valueOf(progress));
                Shared300.setP331_42(String.valueOf(progress));
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

        RadioGroup grpRbM3IdentAlg = (RadioGroup) findViewById(R.id.grpRbM3IdentAlg);
        int checkedRadioButtonId = grpRbM3IdentAlg.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP331_41( ((RadioButton)findViewById(checkedRadioButtonId)).getText().toString()  );
        }

        SeekBar sbPregunta7 = (SeekBar) findViewById(R.id.sbPregunta7);
        int SeekBarValue1 = sbPregunta7.getProgress();
        if (SeekBarValue1 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!", Toast.LENGTH_LONG).show();
            return;
        }

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        //String CheckEditText2 = mFreqbar2.getText().toString();
        if (editText3.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 3!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP331_43(editText3.getText().toString());
        }

        EditText editText4 = (EditText) findViewById(R.id.editText4);

        if (editText4.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 4!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP331_44(editText4.getText().toString());
        }

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
