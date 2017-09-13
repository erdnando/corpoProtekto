package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class frm222_6 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm222_6);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        //String CheckEditText1 = mFreqbar1.getText().toString();
        if (editText1.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 1!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP222_61(editText1.getText().toString());
        }

        if (editText2.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 2!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP222_62(editText2.getText().toString());
        }

        if (editText3.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(this, "Escriba en el cuadro de texto 3!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Shared200.setP222_63(editText3.getText().toString());
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
