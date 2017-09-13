package protekto.corpo.com.mx.corpoprotekto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class frm223_2 extends AppCompatActivity {
    private String strUUID;
    private String nickname;
    private String seleccionadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm223_2);
        seleccionadas="";
        Intent intent = getIntent();
        strUUID = intent.getStringExtra("UUID");
        nickname = intent.getStringExtra("nickname");

        final SeekBar sbPregunta1 = (SeekBar) findViewById(R.id.sbPregunta1);
        sbPregunta1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta1 = (TextView)findViewById(R.id.tvDeSeekBarPregunta1);
                tvDeSeekBarPregunta1.setText(String.valueOf(progress));
                if(progress>=3){
                    TextView tvPregunta1 = (TextView)findViewById(R.id.tvPregunta1);
                    seleccionadas+="\n-"+tvPregunta1.getText().toString();
                }
                Shared200.setP223_21(String.valueOf(progress));
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
        sbPregunta2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta2 = (TextView)findViewById(R.id.tvDeSeekBarPregunta2);
                tvDeSeekBarPregunta2.setText(String.valueOf(progress));
                if(progress>=3){
                    TextView tvPregunta2 = (TextView)findViewById(R.id.tvPregunta2);
                    seleccionadas+="\n-"+tvPregunta2.getText().toString();
                    //seleccionadas+="\n-"+tvDeSeekBarPregunta2.getText().toString();
                }
                Shared200.setP223_22(String.valueOf(progress));
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
        sbPregunta3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta3 = (TextView)findViewById(R.id.tvDeSeekBarPregunta3);
                tvDeSeekBarPregunta3.setText(String.valueOf(progress));
                if(progress>=3){
                    TextView tvPregunta3 = (TextView)findViewById(R.id.tvPregunta3);
                    seleccionadas+="\n-"+tvPregunta3.getText().toString();
                    //seleccionadas+="\n-"+tvDeSeekBarPregunta3.getText().toString();
                }
                Shared200.setP223_23(String.valueOf(progress));
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



        final SeekBar sbPregunta4 = (SeekBar) findViewById(R.id.sbPregunta4);
        sbPregunta4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta4 = (TextView)findViewById(R.id.tvDeSeekBarPregunta4);
                tvDeSeekBarPregunta4.setText(String.valueOf(progress));
                if(progress>=3){
                   // seleccionadas+="\n-"+tvDeSeekBarPregunta4.getText().toString();
                    TextView tvPregunta1 = (TextView)findViewById(R.id.tvPregunta4);
                    seleccionadas+="\n-"+tvPregunta1.getText().toString();
                }
                Shared200.setP223_24(String.valueOf(progress));
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



        final SeekBar sbPregunta5 = (SeekBar) findViewById(R.id.sbPregunta5);
        sbPregunta5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta5 = (TextView)findViewById(R.id.tvDeSeekBarPregunta5);
                tvDeSeekBarPregunta5.setText(String.valueOf(progress));
                if(progress>=3){
                    //seleccionadas+="\n-"+tvDeSeekBarPregunta5.getText().toString();
                    TextView tvPregunta1 = (TextView)findViewById(R.id.tvPregunta5);
                    seleccionadas+="\n-"+tvPregunta1.getText().toString();
                }
                Shared200.setP223_25(String.valueOf(progress));
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



        final SeekBar sbPregunta6 = (SeekBar) findViewById(R.id.sbPregunta6);
        sbPregunta6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta6 = (TextView)findViewById(R.id.tvDeSeekBarPregunta6);
                tvDeSeekBarPregunta6.setText(String.valueOf(progress));
                if(progress>=3){
                    //seleccionadas+="\n-"+tvDeSeekBarPregunta6.getText().toString();
                    TextView tvPregunta1 = (TextView)findViewById(R.id.tvPregunta6);
                    seleccionadas+="\n-"+tvPregunta1.getText().toString();
                }
                Shared200.setP223_26(String.valueOf(progress));
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



        final SeekBar sbPregunta7 = (SeekBar) findViewById(R.id.sbPregunta7);
        sbPregunta7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta7 = (TextView)findViewById(R.id.tvDeSeekBarPregunta7);
                tvDeSeekBarPregunta7.setText(String.valueOf(progress));
                if(progress>=3){
                    //seleccionadas+="\n-"+tvDeSeekBarPregunta7.getText().toString();
                    TextView tvPregunta1 = (TextView)findViewById(R.id.tvPregunta7);
                    seleccionadas+="\n-"+tvPregunta1.getText().toString();
                }
                Shared200.setP223_27(String.valueOf(progress));
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



        final SeekBar sbPregunta8 = (SeekBar) findViewById(R.id.sbPregunta8);
        sbPregunta8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta8 = (TextView)findViewById(R.id.tvDeSeekBarPregunta8);
                tvDeSeekBarPregunta8.setText(String.valueOf(progress));
                if(progress>=3){
                    //seleccionadas+="\n-"+tvDeSeekBarPregunta8.getText().toString();
                    TextView tvPregunta1 = (TextView)findViewById(R.id.tvPregunta8);
                    seleccionadas+="\n-"+tvPregunta1.getText().toString();
                }
                Shared200.setP223_28(String.valueOf(progress));
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



        final SeekBar sbPregunta9 = (SeekBar) findViewById(R.id.sbPregunta9);
        sbPregunta9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                TextView tvDeSeekBarPregunta9 = (TextView)findViewById(R.id.tvDeSeekBarPregunta9);
                tvDeSeekBarPregunta9.setText(String.valueOf(progress));
                if(progress>=3){
                    //seleccionadas+="\n-"+tvDeSeekBarPregunta9.getText().toString();
                    TextView tvPregunta1 = (TextView)findViewById(R.id.tvPregunta9);
                    seleccionadas+="\n-"+tvPregunta1.getText().toString();
                }
                Shared200.setP223_29(String.valueOf(progress));
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

        SeekBar sbPregunta4 = (SeekBar) findViewById(R.id.sbPregunta4);
        int SeekBarValue4 = sbPregunta4.getProgress();
        if (SeekBarValue4 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 4!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar sbPregunta5 = (SeekBar) findViewById(R.id.sbPregunta5);
        int SeekBarValue5 = sbPregunta5.getProgress();
        if (SeekBarValue5 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 5!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar sbPregunta6 = (SeekBar) findViewById(R.id.sbPregunta6);
        int SeekBarValue6 = sbPregunta6.getProgress();
        if (SeekBarValue6 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 6!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar sbPregunta7 = (SeekBar) findViewById(R.id.sbPregunta7);
        int SeekBarValue7 = sbPregunta7.getProgress();
        if (SeekBarValue7 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 7!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar sbPregunta8 = (SeekBar) findViewById(R.id.sbPregunta8);
        int SeekBarValue8 = sbPregunta8.getProgress();
        if (SeekBarValue8 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 8!", Toast.LENGTH_LONG).show();
            return;
        }

        SeekBar sbPregunta9 = (SeekBar) findViewById(R.id.sbPregunta9);
        int SeekBarValue9 = sbPregunta9.getProgress();
        if (SeekBarValue9 == 0){
            Toast.makeText(this, "Seleccione una opcion valida a la pregunta 9!", Toast.LENGTH_LONG).show();
            return;
        }

        Shared200.setP223_29Sel(seleccionadas);
        //---------------------------------------------
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
