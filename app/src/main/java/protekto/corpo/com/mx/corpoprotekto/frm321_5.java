package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm321_5 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm321_5);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        TextView lblRespuestas=(TextView)findViewById(R.id.lblRespuestas);
        lblRespuestas.setText(Shared300.getP321_41()+ " y " + Shared300.getP321_42());//respuestas de la pag anterior


    }

    public void gotoFrm(View view) {

        EditText mFreqbar1 = (EditText) findViewById(R.id.editText);
        String CheckEditText1 = mFreqbar1.getText().toString();
        if (CheckEditText1.matches("")) {
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared300.setP321_51(String.valueOf(CheckEditText1));
        }

        RadioGroup grpRbM5 = (RadioGroup) findViewById(R.id.grpRbM3IdentAlg);
        int checkedRadioButtonId = grpRbM5.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!", Toast.LENGTH_LONG).show();
            return;
        }

            EditText mFreqbar2 = (EditText)findViewById(R.id.editText2);
            String CheckEditText2 = mFreqbar2.getText().toString();
            if (CheckEditText2.matches("")) {
                Toast.makeText(this, "Escriba en el cuadro de texto 3!", Toast.LENGTH_LONG).show();
                return;
            } else {
                Shared300.setP321_53(String.valueOf(CheckEditText2));
            }

            String frm = view.getTag().toString();

            Intent newView = null;
            try {
                newView = new Intent(this, Class.forName(getPackageName() + "." + frm));
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
