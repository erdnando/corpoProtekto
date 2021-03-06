package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class frm11 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm11);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        //----------------re set respuestas
        TextView lblTexto0 = (TextView) findViewById(R.id.lblTexto0);
        lblTexto0.setText("¡Qué tal "+nickname+"!");
       /* try {
            RadioGroup grpRbM1 = (RadioGroup) findViewById(R.id.grpRbM1);
            grpRbM1.check(Integer.parseInt(Shared10.getP3()));

            RadioGroup grpRbM2 = (RadioGroup) findViewById(R.id.grpRbM2);
            grpRbM2.check(Integer.parseInt(Shared10.getP4()));
        }catch(Exception ex){}*/
        //-----------------------------------
    }

    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P3,P4--------------------

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
