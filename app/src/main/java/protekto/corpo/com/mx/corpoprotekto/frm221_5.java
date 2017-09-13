package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class frm221_5 extends AppCompatActivity {

    private String strUUID;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm221_5);
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");
    }

    public void gotoFrm(View view) {

        CheckBox chk1=(CheckBox)findViewById(R.id.chk1);
        CheckBox chk2=(CheckBox)findViewById(R.id.chk2);
        CheckBox chk3=(CheckBox)findViewById(R.id.chk3);
        CheckBox chk4=(CheckBox)findViewById(R.id.chk4);

        CheckBox chk5=(CheckBox)findViewById(R.id.chk5);
        CheckBox chk6=(CheckBox)findViewById(R.id.chk6);
        CheckBox chk7=(CheckBox)findViewById(R.id.chk7);
        CheckBox chk8=(CheckBox)findViewById(R.id.chk8);

        CheckBox chk9=(CheckBox)findViewById(R.id.chk9);
        CheckBox chk10=(CheckBox)findViewById(R.id.chk10);
        CheckBox chk11=(CheckBox)findViewById(R.id.chk11);
        CheckBox chk12=(CheckBox)findViewById(R.id.chk12);

        CheckBox chk13=(CheckBox)findViewById(R.id.chk13);
        CheckBox chk14=(CheckBox)findViewById(R.id.chk14);
        CheckBox chk15=(CheckBox)findViewById(R.id.chk15);
        CheckBox chk16=(CheckBox)findViewById(R.id.chk16);

        CheckBox chk17=(CheckBox)findViewById(R.id.chk17);
        CheckBox chk18=(CheckBox)findViewById(R.id.chk18);
        CheckBox chk19=(CheckBox)findViewById(R.id.chk19);
        CheckBox chk20=(CheckBox)findViewById(R.id.chk20);

        CheckBox chk21=(CheckBox)findViewById(R.id.chk21);
        CheckBox chk22=(CheckBox)findViewById(R.id.chk22);
        CheckBox chk23=(CheckBox)findViewById(R.id.chk23);
        CheckBox chk24=(CheckBox)findViewById(R.id.chk24);



        final String frm = view.getTag().toString();

        String reto="2";
        String sesion="2";
        final String xmlPaquete=(
                "<paquete><pregunta>1</pregunta><respuesta>"+(chk1.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>2</pregunta><respuesta>"+(chk2.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>3</pregunta><respuesta>"+(chk3.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>4</pregunta><respuesta>"+(chk4.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>5</pregunta><respuesta>"+(chk5.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>6</pregunta><respuesta>"+(chk6.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>7</pregunta><respuesta>"+(chk7.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>8</pregunta><respuesta>"+(chk8.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>9</pregunta><respuesta>"+(chk9.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>10</pregunta><respuesta>"+(chk10.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>11</pregunta><respuesta>"+(chk11.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>12</pregunta><respuesta>"+(chk12.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>13</pregunta><respuesta>"+(chk13.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>14</pregunta><respuesta>"+(chk14.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>15</pregunta><respuesta>"+(chk15.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>16</pregunta><respuesta>"+(chk16.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>17</pregunta><respuesta>"+(chk17.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>18</pregunta><respuesta>"+(chk18.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>19</pregunta><respuesta>"+(chk19.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>20</pregunta><respuesta>"+(chk20.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>21</pregunta><respuesta>"+(chk21.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>22</pregunta><respuesta>"+(chk22.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>23</pregunta><respuesta>"+(chk23.isChecked()?"X":"0") +"</respuesta>"+
                        "<pregunta>24</pregunta><respuesta>"+(chk24.isChecked()?"X":"0") +"</respuesta></paquete>").replace("á","a").replace("í","i").replace("ó","o").replace("ú","u").replace("é","e").replace("ñ","n");



        UtilWS.callServerForResult(strUUID, "MOD2","frm221_5",xmlPaquete, frm,reto,sesion, new UtilWS.Callback() {
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
