package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class frm212_2b extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm212_2b);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        EditText editText2 = (EditText) findViewById(R.id.editText2);
       // String CheckEditText2 = mFreqbar2.getText().toString();
        if (editText2.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(this, "Ha dejado vacio el campo 1!", Toast.LENGTH_LONG).show();
            return;
        }
        //else {
            //Shared200.setP1(String.valueOf(CheckEditText1));
            //Shared200.setP212_2(editText2.getText().toString());
        //}

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
