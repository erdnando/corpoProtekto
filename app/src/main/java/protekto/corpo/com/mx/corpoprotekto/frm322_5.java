package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class frm322_5 extends AppCompatActivity {


    private String strUUID;
    private String nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm322_5);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        final String frm = view.getTag().toString();
        String reto="3";
        String sesion="1";
        final String xmlPaquete=(
                "<paquete>"+
                        "<pregunta>1</pregunta><respuesta>"+Shared300.getP322_21() +
                        "<pregunta>2</pregunta><respuesta>"+Shared300.getP322_22() +
                        "<pregunta>3</pregunta><respuesta>"+Shared300.getP322_23() +
                        "<pregunta>4</pregunta><respuesta>"+Shared300.getP322_24() +
                        "<pregunta>5</pregunta><respuesta>"+Shared300.getP322_25() +
                        "<pregunta>6</pregunta><respuesta>"+Shared300.getP322_26() +
                        "<pregunta>7</pregunta><respuesta>"+Shared300.getP322_27() +
                        "<pregunta>8</pregunta><respuesta>"+Shared300.getP322_28() +
                        "<pregunta>9</pregunta><respuesta>"+Shared300.getP322_29() +
                        "<pregunta>10</pregunta><respuesta>"+Shared300.getP322_20() +
                        "<pregunta>11</pregunta><respuesta>"+Shared300.getP322_41() +
                        "<pregunta>12</pregunta><respuesta>"+Shared300.getP322_42() +
                        "<pregunta>13</pregunta><respuesta>"+Shared300.getP322_43() +
                        "<pregunta>14</pregunta><respuesta>"+Shared300.getP322_44() +
                        "<pregunta>15</pregunta><respuesta>"+Shared300.getP322_45() +
                        "<pregunta>16</pregunta><respuesta>"+Shared300.getP322_46() +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");

        UtilWS.callServerForResult(strUUID, "MOD3","frm322_5",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
       /* String frm = view.getTag().toString();

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
