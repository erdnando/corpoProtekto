package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class frm222_7 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm222_7);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        final String frm = view.getTag().toString();

        String reto="2";
        String sesion="3";
        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+Shared200.getP222_31() +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+Shared200.getP222_32() +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+Shared200.getP222_41() +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+Shared200.getP222_42() +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+Shared200.getP222_51() +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+Shared200.getP222_52() +"</respuesta>"+
                        "<pregunta>7</pregunta><respuesta>"+Shared200.getP222_61() +"</respuesta>"+
                        "<pregunta>8</pregunta><respuesta>"+Shared200.getP222_62() +"</respuesta>"+
                        "<pregunta>9</pregunta><respuesta>"+Shared200.getP222_63() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD2","frm222_7",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
            public void onResultReceived(String resultado) {
                //--------------------start-----------------------------------
                // String res= resultado;
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

        /*String frm = view.getTag().toString();
        Intent newView = null;
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