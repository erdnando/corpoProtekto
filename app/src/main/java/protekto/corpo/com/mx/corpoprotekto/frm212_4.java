package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm212_4 extends AppCompatActivity {

    private String strUUID;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm212_4);

        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        final SeekBar sbPregunta1 = (SeekBar) findViewById(R.id.sbPregunta1);
        sbPregunta1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta1 = (TextView) findViewById(R.id.tvDeSeekBarPregunta1);
                tvDeSeekBarPregunta1.setText(String.valueOf(progress));
                Shared200.setP212_41(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        final SeekBar sbPregunta2 = (SeekBar) findViewById(R.id.sbPregunta2);
        sbPregunta2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta2 = (TextView) findViewById(R.id.tvDeSeekBarPregunta2);
                tvDeSeekBarPregunta2.setText(String.valueOf(progress));
                Shared200.setP212_42(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        final SeekBar sbPregunta3 = (SeekBar) findViewById(R.id.sbPregunta3);
        sbPregunta3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta3 = (TextView) findViewById(R.id.tvDeSeekBarPregunta3);
                tvDeSeekBarPregunta3.setText(String.valueOf(progress));
                Shared200.setP212_43(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void gotoFrm(View view) {

        SeekBar sbPregunta1 = (SeekBar) findViewById(R.id.sbPregunta1);
        int SeekBarValue1 = sbPregunta1.getProgress();
        if (SeekBarValue1 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 1!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar sbPregunta2 = (SeekBar) findViewById(R.id.sbPregunta2);
        int SeekBarValue2 = sbPregunta2.getProgress();
        if (SeekBarValue2 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 2!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar sbPregunta3 = (SeekBar) findViewById(R.id.sbPregunta3);
        int SeekBarValue3 = sbPregunta3.getProgress();
        if (SeekBarValue3 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 3!", Toast.LENGTH_LONG).show();
            return;
        }

        //---------------------------------------------
        String frm = "";//view.getTag().toString();

        if( (Shared200.getP212_41().equalsIgnoreCase("4") || Shared200.getP212_41().equalsIgnoreCase("5") ) &&
                (Shared200.getP212_43().equalsIgnoreCase("4") || Shared200.getP212_43().equalsIgnoreCase("5") ) ){
            frm="frm212_5";

        }else{
            frm="frm212_6";
        }



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

    public void gotoBackFrm(View view) {



        //---------------------------------------------
        String frm = "frm212_3";//view.getTag().toString();



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
