package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class frm321_6 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm321_6);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        final String frm = view.getTag().toString();

        String reto="2";
        String sesion="2";


        final String xmlPaquete=(
                "<paquete>"+
                        "<pregunta>1</pregunta><respuesta>"+Shared300.getP321_41() +
                        "<pregunta>2</pregunta><respuesta>"+Shared300.getP321_42() +
                        "<pregunta>3</pregunta><respuesta>"+Shared300.getP321_43() +
                        "<pregunta>4</pregunta><respuesta>"+Shared300.getP321_44() +
                        "<pregunta>5</pregunta><respuesta>"+Shared300.getP321_45() +
                        "<pregunta>6</pregunta><respuesta>"+Shared300.getP321_46() +
                        "<pregunta>7</pregunta><respuesta>"+Shared300.getP321_51() +
                        "<pregunta>8</pregunta><respuesta>"+Shared300.getP321_52() +
                        "<pregunta>9</pregunta><respuesta>"+Shared300.getP321_53() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD3","frm321_6",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
