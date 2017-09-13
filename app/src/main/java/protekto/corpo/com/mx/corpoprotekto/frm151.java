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

public class frm151 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm151);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //----------------re set respuestas

        RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM1);
        RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM2);

        try {
            grpRbM1.check(Integer.parseInt(Shared10.getP1R()));
            grpRbM2.check(Integer.parseInt(Shared10.getP2R()));
        }catch(Exception ex){}
        //-----------------------------------



        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                      RadioButton rd1c=(RadioButton)findViewById(R.id.rd1c);
                        SpannableString content = new SpannableString(rd1c.getText().toString());
                        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                        rd1c.setText(content);
                        //rd1c.setEnabled(false);
                       // group.setEnabled(false);
                        ((RadioButton)findViewById(R.id.rd1a)).setEnabled(false);
                        ((RadioButton)findViewById(R.id.rd1b)).setEnabled(false);
                        ((RadioButton)findViewById(R.id.rd1c)).setEnabled(false);
                       // rd1c.setTypeface(null,Typeface.BOLD);
                    }
                });

        grpRbM2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd2b=(RadioButton)findViewById(R.id.rd2b);
                //rd2b.setTypeface(null,Typeface.BOLD);
                SpannableString content = new SpannableString(rd2b.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                rd2b.setText(content);
                //rd2b.setEnabled(false);
                //group.setEnabled(false);
                ((RadioButton)findViewById(R.id.rd2a)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd2b)).setEnabled(false);
                ((RadioButton)findViewById(R.id.rd2c)).setEnabled(false);
            }
        });
    }

    public void gotoFrm(View view) {


        //----------------valida 2 radioGroup---------P1,P2--------------------
        RadioGroup grpRbM1 = (RadioGroup)findViewById(R.id.grpRbM1);
        int checkedRadioButtonId = grpRbM1.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            // No item selected
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            RadioButton rd=(RadioButton)findViewById(checkedRadioButtonId) ;
            Shared10.setP1R(rd.getText().toString());
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
            Shared10.setP2R(String.valueOf(rd.getText()));
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
