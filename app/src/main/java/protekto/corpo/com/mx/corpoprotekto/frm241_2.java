package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class frm241_2 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm241_2);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        EditText etRespuesta1 = (EditText) findViewById(R.id.etRespuesta1);
        //String CheckEditText1 = etRespuesta1.getText().toString();
        if (etRespuesta1.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP241_21(String.valueOf(etRespuesta1.getText().toString()));
        }

        EditText etRespuesta2 = (EditText) findViewById(R.id.etRespuesta2);
        //String CheckEditText1 = etRespuesta1.getText().toString();
        if (etRespuesta2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP241_22(String.valueOf(etRespuesta2.getText().toString()));
        }

        EditText etRespuesta3 = (EditText) findViewById(R.id.etRespuesta3);
        //String CheckEditText1 = etRespuesta1.getText().toString();
        if (etRespuesta3.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP241_23(String.valueOf(etRespuesta3.getText().toString()));
        }

        EditText etRespuesta4 = (EditText) findViewById(R.id.etRespuesta4);
        //String CheckEditText1 = etRespuesta1.getText().toString();
        if (etRespuesta4.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP241_24(String.valueOf(etRespuesta4.getText().toString()));
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
