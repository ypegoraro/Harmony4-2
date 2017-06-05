package yasmin.harmony.harmony;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ModoGravacao extends AppCompatActivity {

    private Button BotaoGravar;
    private Button BotaoPausar;
    private Button BotaoReproduzir;
    private Button BotaoVoltar;
    private MediaRecorder myAudioRecorder;
    private String outputFile = null;
    ConnectionThreadGravacao connect;
    static TextView statusMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_gravacao);

        connect = new ConnectionThreadGravacao("98:D3:31:90:60:7A");

        connect.start();

        try {
            Thread.sleep(1000);
        } catch (Exception E) {
            E.printStackTrace();
        }

        BotaoGravar = (Button) findViewById(R.id.ButtonGravar);
        BotaoPausar = (Button) findViewById(R.id.ButtonPausar);
        BotaoReproduzir = (Button) findViewById(R.id.ButtonReproduzir);
        BotaoVoltar = (Button) findViewById(R.id.ButtonVoltar);

        statusMessage = (TextView) findViewById(R.id.statusMessage);

        BotaoPausar.setEnabled(false);
        BotaoReproduzir.setEnabled(false);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
        ;

        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);

        myAudioRecorder.setOutputFile(outputFile);


        BotaoGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                BotaoGravar.setEnabled(false);
                BotaoPausar.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });

        BotaoPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    myAudioRecorder.stop();
                }catch(RuntimeException e){
                    e.printStackTrace();
                }
                myAudioRecorder.release();
                myAudioRecorder = null;

                BotaoPausar.setEnabled(false);
                BotaoReproduzir.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Audio recorded successfully", Toast.LENGTH_LONG).show();
            }
        });

        BotaoReproduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer m = new MediaPlayer();

                try {
                    m.setDataSource(outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    m.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                m.start();
                Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();

            }
        });

        BotaoVoltar = (Button) findViewById(R.id.ButtonVoltar);
        BotaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ModoGravacao.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public static Handler handler = new Handler() {

        @Override

        public void handleMessage(Message msg) {


            Bundle bundle = msg.getData();

            byte[] data = bundle.getByteArray("data");

            String dataString = new String(data);


            if (dataString.equals("---N"))

                statusMessage.setText("Ocorreu um erro durante a conexão D:");

            if (dataString.equals("---S"))

                statusMessage.setText("Conectado :D");
        }
    };

}
