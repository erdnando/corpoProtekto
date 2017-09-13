package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm350_1 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm350_1);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta1);
        RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta2);

        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd1c=(RadioButton)findViewById(R.id.rbM3P1R3);//correcto
                SpannableString content = new SpannableString(rd1c.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd1c.setText(content);

                ((RadioButton)findViewById(R.id.rbM3P1R1)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P1R2)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P1R3)).setEnabled(false);

            }
        });

        grpRbM2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd2b=(RadioButton)findViewById(R.id.rbM3P2R2);//correcto
                SpannableString content = new SpannableString(rd2b.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd2b.setText(content);

                ((RadioButton)findViewById(R.id.rbM3P2R1)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P2R2)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P2R3)).setEnabled(false);

            }
        });

    }

    public void gotoFrm(View view) {


        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta1);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared300.setP350_11(((RadioButton)findViewById(checkedRadioButtonId)).getText().toString());
        }

        RadioGroup grpRbM2 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta2);
        int checkedRadioButtonId2 = grpRbM2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            Shared300.setP350_12(((RadioButton)findViewById(checkedRadioButtonId2)).getText().toString());
        }
        //-------------end valida 2 radioGroup---------P1,P2--------------------




        //---------------------------------------------
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
