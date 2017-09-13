package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class frm123 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm123);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");


        //TextView txtComenzar=(TextView)findViewById(R.id.txtComenzar);
        //txtComenzar.setText("¡Hola "+nickname +"!");
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


        final String frm = view.getTag().toString();

        final String reto="3";
        final String sesion="2";

        final String xmlPaquete=("<paquete><pregunta>1</pregunta><respuesta>"+Shared11.get122_1().trim() +"</respuesta>"+
                "<pregunta>2</pregunta><respuesta>"+Shared11.get122_2().trim() +"</respuesta>"+
                "<pregunta>3</pregunta><respuesta>"+Shared11.get122_3().trim() +"</respuesta>"+
                "<pregunta>4</pregunta><respuesta>"+Shared11.get122_4().trim() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");


        UtilWS.callServerForResult(strUUID, "MOD1","frm123",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
