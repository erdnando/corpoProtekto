package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class frm152 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm152);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        //----------------re set respuestas
        RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM1);
        RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM2);

        try {
            grpRbM1.check(Integer.parseInt(Shared10.getP3R()));
            grpRbM2.check(Integer.parseInt(Shared10.getP4R()));
        }catch(Exception ex){}
        //-----------------------------------

        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd1b=(RadioButton)findViewById(R.id.rd1b);
                //rd1b.setTypeface(null, Typeface.BOLD);
                SpannableString content = new SpannableString(rd1b.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd1b.setText(content);
                //rd1b.setEnabled(false);
                //group.setEnabled(false);
                ((RadioButton)findViewById(R.id.rd1a)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd1b)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd1c)).setEnabled(false);
            }
        });

        grpRbM2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd2a=(RadioButton)findViewById(R.id.rd2a);
                //rd2a.setTypeface(null,Typeface.BOLD);
                SpannableString content = new SpannableString(rd2a.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd2a.setText(content);
                //rd2a.setEnabled(false);
               // group.setEnabled(false);
                ((RadioButton)findViewById(R.id.rd2a)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd2b)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd2c)).setEnabled(false);
            }
        });

    }

    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P3,P4--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM1);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rd=(RadioButton)findViewById(checkedRadioButtonId) ;
            Shared10.setP3R(rd.getText().toString());
        }

        RadioGroup grpRbM2 = (RadioGroup)findViewById(R.id.grpRbM2);
        int checkedRadioButtonId2 = grpRbM2.getCheckedRadioButtonId();
        if (checkedRadioButtonId2 == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rd=(RadioButton)findViewById(checkedRadioButtonId2) ;
            Shared10.setP4R(rd.getText().toString());
        }
        //-------------end valida 2 radioGroup---------P1,P2--------------------

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
