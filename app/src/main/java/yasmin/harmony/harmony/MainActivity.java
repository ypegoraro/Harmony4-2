package yasmin.harmony.harmony;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button BotaoModoGravacao;
    private Button BotaoModoAprendizagem;
    static private int soundIDp1, soundIDp2, soundIDp3, soundIDp4, soundIDp5, soundIDp6, soundIDp7, soundIDp8, soundIDp9, soundIDp10,
            soundIDp11, soundIDp12, soundIDp13, soundIDp14, soundIDp15, soundIDp16, soundIDp17, soundIDp18, soundIDp19, soundIDp20, soundIDp21,
            soundIDp22, soundIDp23, soundIDp24, soundIDp25, soundIDp26, soundIDp27, soundIDp28, soundIDp29, soundIDp30, soundIDp31, soundIDp32,
            soundIDp33, soundIDp34, soundIDp35, soundIDp36, soundIDp37, soundIDp38, soundIDp39, soundIDp40, soundIDp41, soundIDp42, soundIDp43,
            soundIDp44, soundIDp45, soundIDp46, soundIDp47, soundIDp48, soundIDp49, soundIDp50, soundIDp51, soundIDp52, soundIDp53, soundIDp54,
            soundIDp55, soundIDp56, soundIDp57, soundIDp58, soundIDp59, soundIDp60;
    // inicio parte editada
    Spinner instrumento;

    int id;

    static SoundPool sp;

    static int counter = 0;

    static boolean plays = false, loaded = false;

    static float actVolume, maxVolume, volume;

    static TextView statusMessage;

    AudioManager audioManager;

    ConnectionThread connect;

//fim parte editada


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIO parte editada YAS
        connect = new ConnectionThread("98:D3:31:90:60:7A");

        connect.start();

        instrumento = (Spinner) findViewById(R.id.spinner);

        instrumento.setOnItemSelectedListener(this);


        try {

            Thread.sleep(1000);

        } catch (Exception E) {

            E.printStackTrace();

        }

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();

        statusMessage = (TextView) findViewById(R.id.statusMessage);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        actVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        volume = actVolume / maxVolume;


        sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {

            @Override

            public void onLoadComplete(SoundPool sp, int sampleId, int status) {

                loaded = true;

            }

        });


        //FIM parte EDITADA


        BotaoModoGravacao = (Button) findViewById(R.id.ButtonGravacao);
        BotaoModoGravacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ModoGravacao.class);
                startActivity(intent);
                finish();
            }
        });

        BotaoModoAprendizagem = (Button) findViewById(R.id.ButtonAprendizagem);
            BotaoModoAprendizagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ModoAprendizagem.class);
                    startActivity(intent);
                    finish();
                }
            });

        List<String> instrumentos = new ArrayList<String>();
        instrumentos.add("Piano");
        instrumentos.add("Acordeon");
        instrumentos.add("Guitarra");
        instrumentos.add("Sax");
        instrumentos.add("Violino");
        instrumentos.add("Xilofone");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instrumentos);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        instrumento.setAdapter(dataAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if (item.equals("Piano")) {
            soundIDp1 = sp.load(this, R.raw.piano1, 1);
            soundIDp2 = sp.load(this, R.raw.piano2, 1);
            soundIDp3 = sp.load(this, R.raw.piano3, 1);
            soundIDp4 = sp.load(this, R.raw.piano4, 1);
            soundIDp5 = sp.load(this, R.raw.piano5, 1);
            soundIDp6 = sp.load(this, R.raw.piano6, 1);
            soundIDp7 = sp.load(this, R.raw.piano7, 1);
            soundIDp8 = sp.load(this, R.raw.piano8, 1);
            soundIDp9 = sp.load(this, R.raw.piano9, 1);
            soundIDp10 = sp.load(this, R.raw.piano10, 1);
            soundIDp11 = sp.load(this, R.raw.piano11, 1);
            soundIDp12 = sp.load(this, R.raw.piano12, 1);
            soundIDp13 = sp.load(this, R.raw.piano13, 1);
            soundIDp14 = sp.load(this, R.raw.piano14, 1);
            soundIDp15 = sp.load(this, R.raw.piano15, 1);
            soundIDp16 = sp.load(this, R.raw.piano16, 1);
            soundIDp17 = sp.load(this, R.raw.piano17, 1);
            soundIDp18 = sp.load(this, R.raw.piano18, 1);
            soundIDp19 = sp.load(this, R.raw.piano19, 1);
            soundIDp20 = sp.load(this, R.raw.piano20, 1);
            soundIDp21 = sp.load(this, R.raw.piano21, 1);
            soundIDp22 = sp.load(this, R.raw.piano22, 1);
            soundIDp23 = sp.load(this, R.raw.piano23, 1);
            soundIDp24 = sp.load(this, R.raw.piano24, 1);
            soundIDp25 = sp.load(this, R.raw.piano25, 1);
            soundIDp26 = sp.load(this, R.raw.piano26, 1);
            soundIDp27 = sp.load(this, R.raw.piano27, 1);
            soundIDp28 = sp.load(this, R.raw.piano28, 1);
            soundIDp29 = sp.load(this, R.raw.piano29, 1);
            soundIDp30 = sp.load(this, R.raw.piano30, 1);
            soundIDp31 = sp.load(this, R.raw.piano31, 1);
            soundIDp32 = sp.load(this, R.raw.piano32, 1);
            soundIDp33 = sp.load(this, R.raw.piano33, 1);
            soundIDp34 = sp.load(this, R.raw.piano34, 1);
            soundIDp35 = sp.load(this, R.raw.piano35, 1);
            soundIDp36 = sp.load(this, R.raw.piano36, 1);
            soundIDp37 = sp.load(this, R.raw.piano37, 1);
            soundIDp38 = sp.load(this, R.raw.piano38, 1);
            soundIDp39 = sp.load(this, R.raw.piano39, 1);
            soundIDp40 = sp.load(this, R.raw.piano40, 1);
            soundIDp41 = sp.load(this, R.raw.piano41, 1);
            soundIDp42 = sp.load(this, R.raw.piano42, 1);
            soundIDp43 = sp.load(this, R.raw.piano43, 1);
            soundIDp44 = sp.load(this, R.raw.piano44, 1);
            soundIDp45 = sp.load(this, R.raw.piano45, 1);
            soundIDp46 = sp.load(this, R.raw.piano46, 1);
            soundIDp47 = sp.load(this, R.raw.piano47, 1);
            soundIDp48 = sp.load(this, R.raw.piano48, 1);
            soundIDp49 = sp.load(this, R.raw.piano49, 1);
            soundIDp50 = sp.load(this, R.raw.piano50, 1);
            soundIDp51 = sp.load(this, R.raw.piano51, 1);
            soundIDp52 = sp.load(this, R.raw.piano52, 1);
            soundIDp53 = sp.load(this, R.raw.piano53, 1);
            soundIDp54 = sp.load(this, R.raw.piano54, 1);
            soundIDp55 = sp.load(this, R.raw.piano55, 1);
            soundIDp56 = sp.load(this, R.raw.piano56, 1);
            soundIDp57 = sp.load(this, R.raw.piano57, 1);
            soundIDp58 = sp.load(this, R.raw.piano58, 1);
            soundIDp59 = sp.load(this, R.raw.piano59, 1);
            soundIDp60 = sp.load(this, R.raw.piano60, 1);
        } else if (item.equals("Acordeon")) {
            soundIDp1 = sp.load(this, R.raw.accordion1, 1);
            soundIDp2 = sp.load(this, R.raw.accordion2, 1);
            soundIDp3 = sp.load(this, R.raw.accordion3, 1);
            soundIDp4 = sp.load(this, R.raw.accordion4, 1);
            soundIDp5 = sp.load(this, R.raw.accordion5, 1);
            soundIDp6 = sp.load(this, R.raw.accordion6, 1);
            soundIDp7 = sp.load(this, R.raw.accordion7, 1);
            soundIDp8 = sp.load(this, R.raw.accordion8, 1);
            soundIDp9 = sp.load(this, R.raw.accordion9, 1);
            soundIDp10 = sp.load(this, R.raw.accordion10, 1);
            soundIDp11 = sp.load(this, R.raw.accordion11, 1);
            soundIDp12 = sp.load(this, R.raw.accordion12, 1);
            soundIDp13 = sp.load(this, R.raw.accordion13, 1);
            soundIDp14 = sp.load(this, R.raw.accordion14, 1);
            soundIDp15 = sp.load(this, R.raw.accordion15, 1);
            soundIDp16 = sp.load(this, R.raw.accordion16, 1);
            soundIDp17 = sp.load(this, R.raw.accordion17, 1);
            soundIDp18 = sp.load(this, R.raw.accordion18, 1);
            soundIDp19 = sp.load(this, R.raw.accordion19, 1);
            soundIDp20 = sp.load(this, R.raw.accordion20, 1);
            soundIDp21 = sp.load(this, R.raw.accordion21, 1);
            soundIDp22 = sp.load(this, R.raw.accordion22, 1);
            soundIDp23 = sp.load(this, R.raw.accordion23, 1);
            soundIDp24 = sp.load(this, R.raw.accordion24, 1);
            soundIDp25 = sp.load(this, R.raw.accordion25, 1);
            soundIDp26 = sp.load(this, R.raw.accordion26, 1);
            soundIDp27 = sp.load(this, R.raw.accordion27, 1);
            soundIDp28 = sp.load(this, R.raw.accordion28, 1);
            soundIDp29 = sp.load(this, R.raw.accordion29, 1);
            soundIDp30 = sp.load(this, R.raw.accordion30, 1);
            soundIDp31 = sp.load(this, R.raw.accordion31, 1);
            soundIDp32 = sp.load(this, R.raw.accordion32, 1);
            soundIDp33 = sp.load(this, R.raw.accordion33, 1);
            soundIDp34 = sp.load(this, R.raw.accordion34, 1);
            soundIDp35 = sp.load(this, R.raw.accordion35, 1);
            soundIDp36 = sp.load(this, R.raw.accordion36, 1);
            soundIDp37 = sp.load(this, R.raw.accordion37, 1);
            soundIDp38 = sp.load(this, R.raw.accordion38, 1);
            soundIDp39 = sp.load(this, R.raw.accordion39, 1);
            soundIDp40 = sp.load(this, R.raw.accordion40, 1);
            soundIDp41 = sp.load(this, R.raw.accordion41, 1);
            soundIDp42 = sp.load(this, R.raw.accordion42, 1);
            soundIDp43 = sp.load(this, R.raw.accordion43, 1);
            soundIDp44 = sp.load(this, R.raw.accordion44, 1);
            soundIDp45 = sp.load(this, R.raw.accordion45, 1);
            soundIDp46 = sp.load(this, R.raw.accordion46, 1);
            soundIDp47 = sp.load(this, R.raw.accordion47, 1);
            soundIDp48 = sp.load(this, R.raw.accordion48, 1);
            soundIDp49 = sp.load(this, R.raw.accordion49, 1);
            soundIDp50 = sp.load(this, R.raw.accordion50, 1);
            soundIDp51 = sp.load(this, R.raw.accordion51, 1);
            soundIDp52 = sp.load(this, R.raw.accordion52, 1);
            soundIDp53 = sp.load(this, R.raw.accordion53, 1);
            soundIDp54 = sp.load(this, R.raw.accordion54, 1);
            soundIDp55 = sp.load(this, R.raw.accordion55, 1);
            soundIDp56 = sp.load(this, R.raw.accordion56, 1);
            soundIDp57 = sp.load(this, R.raw.accordion57, 1);
            soundIDp58 = sp.load(this, R.raw.accordion58, 1);
            soundIDp59 = sp.load(this, R.raw.accordion59, 1);
            soundIDp60 = sp.load(this, R.raw.accordion60, 1);
        } else if (item.equals("Guitarra")) {
            soundIDp1 = sp.load(this, R.raw.guitarra1, 1);
            soundIDp2 = sp.load(this, R.raw.guitarra2, 1);
            soundIDp3 = sp.load(this, R.raw.guitarra3, 1);
            soundIDp4 = sp.load(this, R.raw.guitarra4, 1);
            soundIDp5 = sp.load(this, R.raw.guitarra5, 1);
            soundIDp5 = sp.load(this, R.raw.guitarra6, 1);
            soundIDp7 = sp.load(this, R.raw.guitarra7, 1);
            soundIDp8 = sp.load(this, R.raw.guitarra8, 1);
            soundIDp9 = sp.load(this, R.raw.guitarra9, 1);
            soundIDp10 = sp.load(this, R.raw.guitarra10, 1);
            soundIDp11 = sp.load(this, R.raw.guitarra11, 1);
            soundIDp12 = sp.load(this, R.raw.guitarra12, 1);
            soundIDp13 = sp.load(this, R.raw.guitarra13, 1);
            soundIDp14 = sp.load(this, R.raw.guitarra14, 1);
            soundIDp15 = sp.load(this, R.raw.guitarra15, 1);
            soundIDp16 = sp.load(this, R.raw.guitarra16, 1);
            soundIDp17 = sp.load(this, R.raw.guitarra17, 1);
            soundIDp18 = sp.load(this, R.raw.guitarra18, 1);
            soundIDp19 = sp.load(this, R.raw.guitarra19, 1);
            soundIDp20 = sp.load(this, R.raw.guitarra20, 1);
            soundIDp21 = sp.load(this, R.raw.guitarra21, 1);
            soundIDp22 = sp.load(this, R.raw.guitarra22, 1);
            soundIDp23 = sp.load(this, R.raw.guitarra23, 1);
            soundIDp24 = sp.load(this, R.raw.guitarra24, 1);
            soundIDp25 = sp.load(this, R.raw.guitarra25, 1);
            soundIDp26 = sp.load(this, R.raw.guitarra26, 1);
            soundIDp27 = sp.load(this, R.raw.guitarra27, 1);
            soundIDp28 = sp.load(this, R.raw.guitarra28, 1);
            soundIDp29 = sp.load(this, R.raw.guitarra29, 1);
            soundIDp30 = sp.load(this, R.raw.guitarra30, 1);
            soundIDp31 = sp.load(this, R.raw.guitarra31, 1);
            soundIDp32 = sp.load(this, R.raw.guitarra32, 1);
            soundIDp33 = sp.load(this, R.raw.guitarra33, 1);
            soundIDp34 = sp.load(this, R.raw.guitarra34, 1);
            soundIDp35 = sp.load(this, R.raw.guitarra35, 1);
            soundIDp36 = sp.load(this, R.raw.guitarra36, 1);
            soundIDp37 = sp.load(this, R.raw.guitarra37, 1);
            soundIDp38 = sp.load(this, R.raw.guitarra38, 1);
            soundIDp39 = sp.load(this, R.raw.guitarra39, 1);
            soundIDp40 = sp.load(this, R.raw.guitarra40, 1);
            soundIDp41 = sp.load(this, R.raw.guitarra41, 1);
            soundIDp42 = sp.load(this, R.raw.guitarra42, 1);
            soundIDp43 = sp.load(this, R.raw.guitarra43, 1);
            soundIDp44 = sp.load(this, R.raw.guitarra44, 1);
            soundIDp45 = sp.load(this, R.raw.guitarra45, 1);
            soundIDp46 = sp.load(this, R.raw.guitarra46, 1);
            soundIDp47 = sp.load(this, R.raw.guitarra47, 1);
            soundIDp48 = sp.load(this, R.raw.guitarra48, 1);
            soundIDp49 = sp.load(this, R.raw.guitarra49, 1);
            soundIDp50 = sp.load(this, R.raw.guitarra50, 1);
            soundIDp51 = sp.load(this, R.raw.guitarra51, 1);
            soundIDp52 = sp.load(this, R.raw.guitarra52, 1);
            soundIDp53 = sp.load(this, R.raw.guitarra53, 1);
            soundIDp54 = sp.load(this, R.raw.guitarra54, 1);
            soundIDp55 = sp.load(this, R.raw.guitarra55, 1);
            soundIDp56 = sp.load(this, R.raw.guitarra56, 1);
            soundIDp57 = sp.load(this, R.raw.guitarra57, 1);
            soundIDp58 = sp.load(this, R.raw.guitarra58, 1);
            soundIDp59 = sp.load(this, R.raw.guitarra59, 1);
            soundIDp60 = sp.load(this, R.raw.guitarra60, 1);
        } else if (item.equals("Sax")) {
            soundIDp1 = sp.load(this, R.raw.sax1, 1);
            soundIDp2 = sp.load(this, R.raw.sax2, 1);
            soundIDp3 = sp.load(this, R.raw.sax3, 1);
            soundIDp4 = sp.load(this, R.raw.sax4, 1);
            soundIDp5 = sp.load(this, R.raw.sax5, 1);
            soundIDp5 = sp.load(this, R.raw.sax6, 1);
            soundIDp7 = sp.load(this, R.raw.sax7, 1);
            soundIDp8 = sp.load(this, R.raw.sax8, 1);
            soundIDp9 = sp.load(this, R.raw.sax9, 1);
            soundIDp10 = sp.load(this, R.raw.sax10, 1);
            soundIDp11 = sp.load(this, R.raw.sax11, 1);
            soundIDp12 = sp.load(this, R.raw.sax12, 1);
            soundIDp13 = sp.load(this, R.raw.sax13, 1);
            soundIDp14 = sp.load(this, R.raw.sax14, 1);
            soundIDp15 = sp.load(this, R.raw.sax15, 1);
            soundIDp16 = sp.load(this, R.raw.sax16, 1);
            soundIDp17 = sp.load(this, R.raw.sax17, 1);
            soundIDp18 = sp.load(this, R.raw.sax18, 1);
            soundIDp19 = sp.load(this, R.raw.sax19, 1);
            soundIDp20 = sp.load(this, R.raw.sax20, 1);
            soundIDp21 = sp.load(this, R.raw.sax21, 1);
            soundIDp22 = sp.load(this, R.raw.sax22, 1);
            soundIDp23 = sp.load(this, R.raw.sax23, 1);
            soundIDp24 = sp.load(this, R.raw.sax24, 1);
            soundIDp25 = sp.load(this, R.raw.sax25, 1);
            soundIDp26 = sp.load(this, R.raw.sax26, 1);
            soundIDp27 = sp.load(this, R.raw.sax27, 1);
            soundIDp28 = sp.load(this, R.raw.sax28, 1);
            soundIDp29 = sp.load(this, R.raw.sax29, 1);
            soundIDp30 = sp.load(this, R.raw.sax30, 1);
            soundIDp31 = sp.load(this, R.raw.sax31, 1);
            soundIDp32 = sp.load(this, R.raw.sax32, 1);
            soundIDp33 = sp.load(this, R.raw.sax33, 1);
            soundIDp34 = sp.load(this, R.raw.sax34, 1);
            soundIDp35 = sp.load(this, R.raw.sax35, 1);
            soundIDp36 = sp.load(this, R.raw.sax36, 1);
            soundIDp37 = sp.load(this, R.raw.sax37, 1);
            soundIDp38 = sp.load(this, R.raw.sax38, 1);
            soundIDp39 = sp.load(this, R.raw.sax39, 1);
            soundIDp40 = sp.load(this, R.raw.sax40, 1);
            soundIDp41 = sp.load(this, R.raw.sax41, 1);
            soundIDp42 = sp.load(this, R.raw.sax42, 1);
            soundIDp43 = sp.load(this, R.raw.sax43, 1);
            soundIDp44 = sp.load(this, R.raw.sax44, 1);
            soundIDp45 = sp.load(this, R.raw.sax45, 1);
            soundIDp46 = sp.load(this, R.raw.sax46, 1);
            soundIDp47 = sp.load(this, R.raw.sax47, 1);
            soundIDp48 = sp.load(this, R.raw.sax48, 1);
            soundIDp49 = sp.load(this, R.raw.sax49, 1);
            soundIDp50 = sp.load(this, R.raw.sax50, 1);
            soundIDp51 = sp.load(this, R.raw.sax51, 1);
            soundIDp52 = sp.load(this, R.raw.sax52, 1);
            soundIDp53 = sp.load(this, R.raw.sax53, 1);
            soundIDp54 = sp.load(this, R.raw.sax54, 1);
            soundIDp55 = sp.load(this, R.raw.sax55, 1);
            soundIDp56 = sp.load(this, R.raw.sax56, 1);
            soundIDp57 = sp.load(this, R.raw.sax57, 1);
            soundIDp58 = sp.load(this, R.raw.sax58, 1);
            soundIDp59 = sp.load(this, R.raw.sax59, 1);
            soundIDp60 = sp.load(this, R.raw.sax60, 1);
        } else if (item.equals("Violino")) {
            soundIDp1 = sp.load(this, R.raw.violino1, 1);
            soundIDp2 = sp.load(this, R.raw.violino2, 1);
            soundIDp3 = sp.load(this, R.raw.violino3, 1);
            soundIDp4 = sp.load(this, R.raw.violino4, 1);
            soundIDp5 = sp.load(this, R.raw.violino5, 1);
            soundIDp5 = sp.load(this, R.raw.violino6, 1);
            soundIDp7 = sp.load(this, R.raw.violino7, 1);
            soundIDp8 = sp.load(this, R.raw.violino8, 1);
            soundIDp9 = sp.load(this, R.raw.violino9, 1);
            soundIDp10 = sp.load(this, R.raw.violino10, 1);
            soundIDp11 = sp.load(this, R.raw.violino11, 1);
            soundIDp12 = sp.load(this, R.raw.violino12, 1);
            soundIDp13 = sp.load(this, R.raw.violino13, 1);
            soundIDp14 = sp.load(this, R.raw.violino14, 1);
            soundIDp15 = sp.load(this, R.raw.violino15, 1);
            soundIDp16 = sp.load(this, R.raw.violino16, 1);
            soundIDp17 = sp.load(this, R.raw.violino17, 1);
            soundIDp18 = sp.load(this, R.raw.violino18, 1);
            soundIDp19 = sp.load(this, R.raw.violino19, 1);
            soundIDp20 = sp.load(this, R.raw.violino20, 1);
            soundIDp21 = sp.load(this, R.raw.violino21, 1);
            soundIDp22 = sp.load(this, R.raw.violino22, 1);
            soundIDp23 = sp.load(this, R.raw.violino23, 1);
            soundIDp24 = sp.load(this, R.raw.violino24, 1);
            soundIDp25 = sp.load(this, R.raw.violino25, 1);
            soundIDp26 = sp.load(this, R.raw.violino26, 1);
            soundIDp27 = sp.load(this, R.raw.violino27, 1);
            soundIDp28 = sp.load(this, R.raw.violino28, 1);
            soundIDp29 = sp.load(this, R.raw.violino29, 1);
            soundIDp30 = sp.load(this, R.raw.violino30, 1);
            soundIDp31 = sp.load(this, R.raw.violino31, 1);
            soundIDp32 = sp.load(this, R.raw.violino32, 1);
            soundIDp33 = sp.load(this, R.raw.violino33, 1);
            soundIDp34 = sp.load(this, R.raw.violino34, 1);
            soundIDp35 = sp.load(this, R.raw.violino35, 1);
            soundIDp36 = sp.load(this, R.raw.violino36, 1);
            soundIDp37 = sp.load(this, R.raw.violino37, 1);
            soundIDp38 = sp.load(this, R.raw.violino38, 1);
            soundIDp39 = sp.load(this, R.raw.violino39, 1);
            soundIDp40 = sp.load(this, R.raw.violino40, 1);
            soundIDp41 = sp.load(this, R.raw.violino41, 1);
            soundIDp42 = sp.load(this, R.raw.violino42, 1);
            soundIDp43 = sp.load(this, R.raw.violino43, 1);
            soundIDp44 = sp.load(this, R.raw.violino44, 1);
            soundIDp45 = sp.load(this, R.raw.violino45, 1);
            soundIDp46 = sp.load(this, R.raw.violino46, 1);
            soundIDp47 = sp.load(this, R.raw.violino47, 1);
            soundIDp48 = sp.load(this, R.raw.violino48, 1);
            soundIDp49 = sp.load(this, R.raw.violino49, 1);
            soundIDp50 = sp.load(this, R.raw.violino50, 1);
            soundIDp51 = sp.load(this, R.raw.violino51, 1);
            soundIDp52 = sp.load(this, R.raw.violino52, 1);
            soundIDp53 = sp.load(this, R.raw.violino53, 1);
            soundIDp54 = sp.load(this, R.raw.violino54, 1);
            soundIDp55 = sp.load(this, R.raw.violino55, 1);
            soundIDp56 = sp.load(this, R.raw.violino56, 1);
            soundIDp57 = sp.load(this, R.raw.violino57, 1);
            soundIDp58 = sp.load(this, R.raw.violino58, 1);
            soundIDp59 = sp.load(this, R.raw.violino59, 1);
            soundIDp60 = sp.load(this, R.raw.violino60, 1);
        } else if (item.equals("Xilofone")) {
            soundIDp1 = sp.load(this, R.raw.xylophone1, 1);
            soundIDp2 = sp.load(this, R.raw.xylophone2, 1);
            soundIDp3 = sp.load(this, R.raw.xylophone3, 1);
            soundIDp4 = sp.load(this, R.raw.xylophone4, 1);
            soundIDp5 = sp.load(this, R.raw.xylophone5, 1);
            soundIDp5 = sp.load(this, R.raw.xylophone6, 1);
            soundIDp7 = sp.load(this, R.raw.xylophone7, 1);
            soundIDp8 = sp.load(this, R.raw.xylophone8, 1);
            soundIDp9 = sp.load(this, R.raw.xylophone9, 1);
            soundIDp10 = sp.load(this, R.raw.xylophone10, 1);
            soundIDp11 = sp.load(this, R.raw.xylophone11, 1);
            soundIDp12 = sp.load(this, R.raw.xylophone12, 1);
            soundIDp13 = sp.load(this, R.raw.xylophone13, 1);
            soundIDp14 = sp.load(this, R.raw.xylophone14, 1);
            soundIDp15 = sp.load(this, R.raw.xylophone15, 1);
            soundIDp16 = sp.load(this, R.raw.xylophone16, 1);
            soundIDp17 = sp.load(this, R.raw.xylophone17, 1);
            soundIDp18 = sp.load(this, R.raw.xylophone18, 1);
            soundIDp19 = sp.load(this, R.raw.xylophone19, 1);
            soundIDp20 = sp.load(this, R.raw.xylophone20, 1);
            soundIDp21 = sp.load(this, R.raw.xylophone21, 1);
            soundIDp22 = sp.load(this, R.raw.xylophone22, 1);
            soundIDp23 = sp.load(this, R.raw.xylophone23, 1);
            soundIDp24 = sp.load(this, R.raw.xylophone24, 1);
            soundIDp25 = sp.load(this, R.raw.xylophone25, 1);
            soundIDp26 = sp.load(this, R.raw.xylophone26, 1);
            soundIDp27 = sp.load(this, R.raw.xylophone27, 1);
            soundIDp28 = sp.load(this, R.raw.xylophone28, 1);
            soundIDp29 = sp.load(this, R.raw.xylophone29, 1);
            soundIDp30 = sp.load(this, R.raw.xylophone30, 1);
            soundIDp31 = sp.load(this, R.raw.xylophone31, 1);
            soundIDp32 = sp.load(this, R.raw.xylophone32, 1);
            soundIDp33 = sp.load(this, R.raw.xylophone33, 1);
            soundIDp34 = sp.load(this, R.raw.xylophone34, 1);
            soundIDp35 = sp.load(this, R.raw.xylophone35, 1);
            soundIDp36 = sp.load(this, R.raw.xylophone36, 1);
            soundIDp37 = sp.load(this, R.raw.xylophone37, 1);
            soundIDp38 = sp.load(this, R.raw.xylophone38, 1);
            soundIDp39 = sp.load(this, R.raw.xylophone39, 1);
            soundIDp40 = sp.load(this, R.raw.xylophone40, 1);
            soundIDp41 = sp.load(this, R.raw.xylophone41, 1);
            soundIDp42 = sp.load(this, R.raw.xylophone42, 1);
            soundIDp43 = sp.load(this, R.raw.xylophone43, 1);
            soundIDp44 = sp.load(this, R.raw.xylophone44, 1);
            soundIDp45 = sp.load(this, R.raw.xylophone45, 1);
            soundIDp46 = sp.load(this, R.raw.xylophone46, 1);
            soundIDp47 = sp.load(this, R.raw.xylophone47, 1);
            soundIDp48 = sp.load(this, R.raw.xylophone48, 1);
            soundIDp49 = sp.load(this, R.raw.xylophone49, 1);
            soundIDp50 = sp.load(this, R.raw.xylophone50, 1);
            soundIDp51 = sp.load(this, R.raw.xylophone51, 1);
            soundIDp52 = sp.load(this, R.raw.xylophone52, 1);
            soundIDp53 = sp.load(this, R.raw.xylophone53, 1);
            soundIDp54 = sp.load(this, R.raw.xylophone54, 1);
            soundIDp55 = sp.load(this, R.raw.xylophone55, 1);
            soundIDp56 = sp.load(this, R.raw.xylophone56, 1);
            soundIDp57 = sp.load(this, R.raw.xylophone57, 1);
            soundIDp58 = sp.load(this, R.raw.xylophone58, 1);
            soundIDp59 = sp.load(this, R.raw.xylophone59, 1);
            soundIDp60 = sp.load(this, R.raw.xylophone60, 1);
        }


        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        id = 1;
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



            /* Esse método é invocado na Activity principal

                sempre que a thread de conexão Bluetooth recebe

                uma mensagem.

             */


            if (dataString.equals("t1")) {
                if (loaded && !plays) {
                    sp.play(soundIDp1, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t2")) {
                if (loaded && !plays) {
                    sp.play(soundIDp2, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t3")) {
                if (loaded && !plays) {
                    sp.play(soundIDp3, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t4")) {
                if (loaded && !plays) {
                    sp.play(soundIDp4, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t5")) {
                if (loaded && !plays) {
                    sp.play(soundIDp5, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t6")) {
                if (loaded && !plays) {
                    sp.play(soundIDp6, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t7")) {
                if (loaded && !plays) {
                    sp.play(soundIDp7, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t8")) {
                if (loaded && !plays) {
                    sp.play(soundIDp8, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t9")) {
                if (loaded && !plays) {
                    sp.play(soundIDp9, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t10")) {
                if (loaded && !plays) {
                    sp.play(soundIDp10, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t11")) {
                if (loaded && !plays) {
                    sp.play(soundIDp11, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t12")) {
                if (loaded && !plays) {
                    sp.play(soundIDp12, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t13")) {
                if (loaded && !plays) {
                    sp.play(soundIDp13, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t14")) {
                if (loaded && !plays) {
                    sp.play(soundIDp14, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t15")) {
                if (loaded && !plays) {
                    sp.play(soundIDp15, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t16")) {
                if (loaded && !plays) {
                    sp.play(soundIDp16, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t17")) {
                if (loaded && !plays) {
                    sp.play(soundIDp17, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t18")) {
                if (loaded && !plays) {
                    sp.play(soundIDp18, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t19")) {
                if (loaded && !plays) {
                    sp.play(soundIDp19, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t20")) {
                if (loaded && !plays) {
                    sp.play(soundIDp20, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t21")) {
                if (loaded && !plays) {
                    sp.play(soundIDp21, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t22")) {
                if (loaded && !plays) {
                    sp.play(soundIDp22, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t23")) {
                if (loaded && !plays) {
                    sp.play(soundIDp23, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t24")) {
                if (loaded && !plays) {
                    sp.play(soundIDp24, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t25")) {
                if (loaded && !plays) {
                    sp.play(soundIDp25, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t26")) {
                if (loaded && !plays) {
                    sp.play(soundIDp26, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t27")) {
                if (loaded && !plays) {
                    sp.play(soundIDp27, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t28")) {
                if (loaded && !plays) {
                    sp.play(soundIDp28, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t29")) {
                if (loaded && !plays) {
                    sp.play(soundIDp29, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t30")) {
                if (loaded && !plays) {
                    sp.play(soundIDp30, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
                //tocou = true;
            } if (dataString.equals("t31")) {
                if (loaded && !plays) {
                    sp.play(soundIDp31, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t32")) {
                if (loaded && !plays) {
                    sp.play(soundIDp32, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t33")) {
                if (loaded && !plays) {
                    sp.play(soundIDp33, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t34")) {
                if (loaded && !plays) {
                    sp.play(soundIDp34, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t35")) {
                if (loaded && !plays) {
                    sp.play(soundIDp35, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t36")) {
                if (loaded && !plays) {
                    sp.play(soundIDp36, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t37")) {
                if (loaded && !plays) {
                    sp.play(soundIDp37, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t38")) {
                if (loaded && !plays) {
                    sp.play(soundIDp38, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t39")) {
                if (loaded && !plays) {
                    sp.play(soundIDp39, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t40")) {
                if (loaded && !plays) {
                    sp.play(soundIDp40, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t41")) {
                if (loaded && !plays) {
                    sp.play(soundIDp41, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t42")) {
                if (loaded && !plays) {
                    sp.play(soundIDp42, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t43")) {
                if (loaded && !plays) {
                    sp.play(soundIDp43, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t44")) {
                if (loaded && !plays) {
                    sp.play(soundIDp44, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t45")) {
                if (loaded && !plays) {
                    sp.play(soundIDp45, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t46")) {
                if (loaded && !plays) {
                    sp.play(soundIDp46, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t47")) {
                if (loaded && !plays) {
                    sp.play(soundIDp47, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t48")) {
                if (loaded && !plays) {
                    sp.play(soundIDp48, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t49")) {
                if (loaded && !plays) {
                    sp.play(soundIDp49, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t50")) {
                if (loaded && !plays) {
                    sp.play(soundIDp50, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t50")) {
                if (loaded && !plays) {
                    sp.play(soundIDp50, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t51")) {
                if (loaded && !plays) {
                    sp.play(soundIDp51, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t52")) {
                if (loaded && !plays) {
                    sp.play(soundIDp52, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t53")) {
                if (loaded && !plays) {
                    sp.play(soundIDp53, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t54")) {
                if (loaded && !plays) {
                    sp.play(soundIDp54, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t55")) {
                if (loaded && !plays) {
                    sp.play(soundIDp55, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t56")) {
                if (loaded && !plays) {
                    sp.play(soundIDp56, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            }
            if (dataString.equals("t57")) {
                if (loaded && !plays) {
                    sp.play(soundIDp57, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t58")) {
                if (loaded && !plays) {
                    sp.play(soundIDp58, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t59")) {
                if (loaded && !plays) {
                    sp.play(soundIDp59, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            } if (dataString.equals("t60")) {
                if (loaded && !plays) {
                    sp.play(soundIDp60, volume, volume, 1, 0, 1f);
                    counter = counter++;
                    plays = true;
                }
                plays = false;
            }

        }

    };
}