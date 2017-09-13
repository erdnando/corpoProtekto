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

public class frm243_2 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm243_2);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        TextView lblTexto6= (TextView)findViewById(R.id.lblTexto6);
        EditText etRespuesta6=(EditText)findViewById(R.id.etRespuesta6);

        lblTexto6.setVisibility(View.INVISIBLE);
        etRespuesta6.setVisibility(View.INVISIBLE);

        RadioGroup grpRbM1=(RadioGroup)findViewById(R.id.grpRbM1);
        grpRbM1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButton1a) {
                    //do work when radioButton1 is active
                    TextView lblTexto6= (TextView)findViewById(R.id.lblTexto6);
                    EditText etRespuesta6=(EditText)findViewById(R.id.etRespuesta6);

                    lblTexto6.setVisibility(View.INVISIBLE);
                    etRespuesta6.setVisibility(View.INVISIBLE);
                    Shared200.setP243_2R("1");


                    RadioButton radioButton1a=(RadioButton)findViewById(R.id.radioButton1a) ;
                    Shared200.setP243_25(radioButton1a.getText().toString());

                } else  if (checkedId == R.id.radioButton1b) {
                    //do work when radioButton2 is active
                    TextView lblTexto6= (TextView)findViewById(R.id.lblTexto6);
                    EditText etRespuesta6=(EditText)findViewById(R.id.etRespuesta6);

                    lblTexto6.setVisibility(View.VISIBLE);
                    etRespuesta6.setVisibility(View.VISIBLE);
                    Shared200.setP243_2R("2");

                    RadioButton radioButton1b=(RadioButton)findViewById(R.id.radioButton1b) ;
                    Shared200.setP243_25(radioButton1b.getText().toString());
                }

            }
        });
    }

    public void gotoFrm(View view) {

        EditText mFreqbar1 = (EditText) findViewById(R.id.etRespuesta1);
        String CheckEditText1 = mFreqbar1.getText().toString();
        if (CheckEditText1.matches("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP243_21(String.valueOf(CheckEditText1));
        }

        EditText mFreqbar2 = (EditText) findViewById(R.id.etRespuesta2);
        String CheckEditText2 = mFreqbar2.getText().toString();
        if (CheckEditText2.matches("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 2!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP243_22(String.valueOf(CheckEditText2));
        }

        EditText mFreqbar3 = (EditText) findViewById(R.id.etRespuesta3);
        String CheckEditText3 = mFreqbar3.getText().toString();
        if (CheckEditText3.matches("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 3!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP243_23(String.valueOf(CheckEditText3));
        }

        EditText mFreqbar4 = (EditText) findViewById(R.id.etRespuesta4);
        String CheckEditText4 = mFreqbar4.getText().toString();
        if (CheckEditText4.matches("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 4!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP243_24(String.valueOf(CheckEditText4));
        }

        /*EditText mFreqbar5 = (EditText) findViewById(R.id.etRespuesta5);
        String CheckEditText5 = mFreqbar5.getText().toString();
        if (CheckEditText5.matches("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 5!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP242_25(String.valueOf(CheckEditText5));
        }*/

        if(Shared200.getP243_2R().toString().equalsIgnoreCase("2")) {
            EditText mFreqbar6 = (EditText) findViewById(R.id.etRespuesta6);
            String CheckEditText6 = mFreqbar6.getText().toString();
            if (CheckEditText6.matches("")) {
                Toast.makeText(this, "Escriba en el cuadro de texto 6!", Toast.LENGTH_LONG).show();
                return;
            } else {
                Shared200.setP243_26(String.valueOf(CheckEditText6));
            }
        }else{
            Shared200.setP243_26("NA");
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
