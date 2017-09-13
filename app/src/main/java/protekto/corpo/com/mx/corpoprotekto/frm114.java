package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class frm114 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    //ImageView fototMejor;
   // private final Handler handler = new Handler();

    /*public interface Callback {
        void onResultReceived(String result);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm114);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        //fototMejor = (ImageView) findViewById(R.id.fototMejor);
        TextView lblEsUnaRealidad = (TextView)findViewById(R.id.lblEsUnaRealidad);
        lblEsUnaRealidad.setText("¡Qué tal "+nickname+"!");
        //----------------re set respuestas

        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida 2 radioGroup---------P5,P6--------------------
        EditText txtComentario=(EditText)findViewById(R.id.txtComentario);


        if(txtComentario.getText().toString().length()<5){
            Toast.makeText(this, "El comentario debe ser de 5 a 250 caracteres!",Toast.LENGTH_LONG).show();
            return;
        }
        final String frm = view.getTag().toString();

        //final String strUUID, final String modulo,final String pantalla,final String comentario,
        UtilWS.callServerForComentarios(strUUID,"frm114",txtComentario.getText().toString().replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n"), new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                Intent newView = null;
                try {
                    newView = new Intent(getBaseContext(), Class.forName(this.getClass().getPackage().getName() +"."+ frm ));
                    newView.putExtra("UUID", strUUID);
                    newView.putExtra("nickname", nickname);
                    startActivity(newView);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                //--------------------end-----------------------------------
            }
        });
        //-------------end valida 2 radioGroup---------P5,P6--------------------

        /*Intent newView = null;
        try {
            newView = new Intent(this, Class.forName(getPackageName() +"."+ frm));
            newView.putExtra("UUID", strUUID);
            newView.putExtra("nickname", nickname);
            startActivity(newView);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/




    }


    @Override
    public void onBackPressed() {
    }
}

