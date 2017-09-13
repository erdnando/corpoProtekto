package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class frm120 extends AppCompatActivity {


    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm120);


        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        TextView txtComenzar=(TextView)findViewById(R.id.txtComenzar);
        txtComenzar.setText("¡Hola "+nickname +"!");
    }


    public void gotoFrm(View view) {

        //----------------valida 2 radioGroup---------P5,P6--------------------
       /* if(Shared11.getF1()==null){
            Toast.makeText(this, "No ha tomado la primera foto!",Toast.LENGTH_LONG).show();
            return;
        }
        if(Shared11.getF2()==null){
            Toast.makeText(this, "No ha tomado la segunda foto",Toast.LENGTH_LONG).show();
            return;
        }
        if(Shared11.getF3()==null){
            Toast.makeText(this, "No ha tomado la tercera foto",Toast.LENGTH_LONG).show();
            return;
        }*/


        //-------------end valida 2 radioGroup---------P5,P6--------------------


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
