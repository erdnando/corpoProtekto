package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class frm150 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    private String respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm150);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
        respuesta = intent.getStringExtra("respuesta");

        //----------------re set respuestas
        TextView lblRespuesta=(TextView)findViewById(R.id.lblRespuesta);
        lblRespuesta.setText(respuesta);
        //-----------------------------------
    }

    public void gotoFrm(View view) {
        //----------------valida -----------------------------
        /*EditText txtComentario=(EditText)findViewById(R.id.txtComentario);


        if(txtComentario.getText().toString().length()<5){
            Toast.makeText(this, "El comentario debe ser de 5 a 250 caracteres!",Toast.LENGTH_LONG).show();
            return;
        }
        */
        final String frm = view.getTag().toString();

        final String reto="4";
        final String sesion="2";
        final String xmlPaquete=(
                        "<paquete><pregunta>1</pregunta><respuesta>"+Shared10.getP1473().trim() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared10.getP1471().trim() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared10.getP1472().trim() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared10.getP1483().trim() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared10.getP1481().trim() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared10.getP1482().trim() +"</respuesta>"+
                        "<pregunta>7</pregunta><respuesta>"+Shared10.getP1493().trim() +"</respuesta>"+
                        "<pregunta>8</pregunta><respuesta>"+Shared10.getP1491().trim() +"</respuesta>"+
                        "<pregunta>9</pregunta><respuesta>"+Shared10.getP1492().trim() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");


        UtilWS.callServerForResult(strUUID, "MOD1","frm150",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
        //-------------end valida----------------------------

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

