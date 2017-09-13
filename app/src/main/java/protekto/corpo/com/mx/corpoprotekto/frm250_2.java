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

public class frm250_2 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm250_2);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta3);
        RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM3Pregunta4);

        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd1c=(RadioButton)findViewById(R.id.rbM3P3R3);//correcto
                SpannableString content = new SpannableString(rd1c.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd1c.setText(content);
                //rd1c.setEnabled(false);
                //group.setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P3R1)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P3R2)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P3R3)).setEnabled(false);

                RadioButton rdChecked=(RadioButton)findViewById(checkedId);
                Shared200.setP250_2G1(rdChecked.getText().toString());
            }
        });

        grpRbM2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd2b=(RadioButton)findViewById(R.id.rbM3P4R1);//correcto
                //rd2b.setTypeface(null,Typeface.BOLD);
                SpannableString content = new SpannableString(rd2b.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd2b.setText(content);
                //rd2b.setEnabled(false);
                //group.setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P4R1)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P4R2)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rbM3P4R3)).setEnabled(false);

                RadioButton rdChecked=(RadioButton)findViewById(checkedId);
                Shared200.setP250_2G2(rdChecked.getText().toString());
            }
        });

    }

    public void gotoFrm(View view) {


        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta3);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }


        RadioGroup grpRbM2 = (RadioGroup)findViewById(R.id.grpRbM3Pregunta4);
        int checkedRadioButtonId2 = grpRbM2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!",Toast.LENGTH_LONG).show();
            return;
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
