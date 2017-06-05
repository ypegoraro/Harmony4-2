package yasmin.harmony.harmony;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ModoAprendizagem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner musica, modos, maos, nivel;
    int mID, nID, modoID, maoID;
    Button inicio;
    private Button BotaoVolta;
    TextView statusMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_aprendizagem);

        musica = (Spinner) findViewById(R.id.musica);
        modos = (Spinner) findViewById(R.id.modo);
        maos = (Spinner) findViewById(R.id.maos);
        nivel = (Spinner) findViewById(R.id.nivel);

        inicio = (Button) findViewById(R.id.ButtonComecar);

        BotaoVolta = (Button) findViewById(R.id.ButtonVoltar);

        statusMessage = (TextView) findViewById(R.id.statusMessage);

        musica.setOnItemSelectedListener(this);
        modos.setOnItemSelectedListener(this);
        maos.setOnItemSelectedListener(this);
        nivel.setOnItemSelectedListener(this);

        List<String> musicas = new ArrayList<String>();
        musicas.add("Für Elise");
        musicas.add("Super Mário");

        List<String> modo = new ArrayList<String>();
        modo.add("Normal");
        modo.add("Com Ritmo");

        List<String> niveis = new ArrayList<String>();
        niveis.add("Fácil");
        niveis.add("Médio");
        niveis.add("Difícil");

        List<String> mao = new ArrayList<String>();
        mao.add("Direita");
        mao.add("Esquerda");
        mao.add("Ambas");

        ArrayAdapter<String> musicaDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, musicas);

        ArrayAdapter<String> modoDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, modo);

        ArrayAdapter<String> niveisDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, niveis);

        ArrayAdapter<String> maoDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mao);

        maoDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        modoDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        niveisDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        musicaDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        musica.setAdapter(musicaDataAdapter);
        modos.setAdapter(modoDataAdapter);
        nivel.setAdapter(niveisDataAdapter);
        maos.setAdapter(maoDataAdapter);

        BotaoVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ModoAprendizagem.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mID == 0 && nID == 0 && modoID == 0 && maoID == 0)
                    statusMessage.setText("Für Elise Normal Fácil Direita");
                else if (mID == 0 && nID == 0 && modoID == 0 && maoID == 1)
                    statusMessage.setText("Für Elise Normal Fácil Esquerda");
                else if (mID == 0 && nID == 0 && modoID == 0 && maoID == 2)
                    statusMessage.setText("Für Elise Normal Fácil Duas Mãos");
                else if (mID == 0 && nID == 0 && modoID == 1 && maoID == 0)
                    statusMessage.setText("Für Elise Com Ritmo Fácil Direita");
                else if (mID == 0 && nID == 0 && modoID == 1 && maoID == 1)
                    statusMessage.setText("Für Elise Com Ritmo Fácil Esquerda");
                else if (mID == 0 && nID == 0 && modoID == 1 && maoID == 2)
                    statusMessage.setText("Für Elise Com Ritmo Fácil Ambas");
                else if (mID == 0 && nID == 1 && modoID == 0 && maoID == 0)
                    statusMessage.setText("Für Elise Normal Médio Direita");
                else if (mID == 0 && nID == 1 && modoID == 0 && maoID == 1)
                    statusMessage.setText("Für Elise Normal Médio Esquerda");
                else if (mID == 0 && nID == 1 && modoID == 0 && maoID == 2)
                    statusMessage.setText("Für Elise Normal Médio Ambas");
                else if (mID == 0 && nID == 1 && modoID == 1 && maoID == 0)
                    statusMessage.setText("Für Elise Com Ritmo Médio Direita");
                else if (mID == 0 && nID == 1 && modoID == 1 && maoID == 1)
                    statusMessage.setText("Für Elise Com Ritmo Médio Esquerda");
                else if (mID == 0 && nID == 1 && modoID == 1 && maoID == 2)
                    statusMessage.setText("Für Elise Com Ritmo Médio Ambas");
                else if (mID == 0 && nID == 2 && modoID == 0 && maoID == 0)
                    statusMessage.setText("Für Elise Normal Difícil Direita");
                else if (mID == 0 && nID == 2 && modoID == 0 && maoID == 1)
                    statusMessage.setText("Für Elise Normal Difícil Esquerda");
                else if (mID == 0 && nID == 2 && modoID == 0 && maoID == 2)
                    statusMessage.setText("Für Elise Normal Difícil Ambas");
                else if (mID == 0 && nID == 2 && modoID == 1 && maoID == 0)
                    statusMessage.setText("Für Elise Com Ritmo Difícil Direita");
                else if (mID == 0 && nID == 2 && modoID == 1 && maoID == 1)
                    statusMessage.setText("Für Elise Com Ritmo Difícil Esquerda");
                else if (mID == 0 && nID == 2 && modoID == 1 && maoID == 2)
                    statusMessage.setText("Für Elise Com Ritmo Difícil Ambas");

                else if (mID == 1 && nID == 0 && modoID == 0 && maoID == 0)
                    statusMessage.setText("Super Mário Normal Fácil Direita");
                else if (mID == 1 && nID == 0 && modoID == 0 && maoID == 1)
                    statusMessage.setText("Super Mário Normal Fácil Esquerda");
                else if (mID == 1 && nID == 0 && modoID == 0 && maoID == 2)
                    statusMessage.setText("Super Mário Normal Fácil Duas Mãos");
                else if (mID == 1 && nID == 0 && modoID == 1 && maoID == 0)
                    statusMessage.setText("Super Mário Com Ritmo Fácil Direita");
                else if (mID == 1 && nID == 0 && modoID == 1 && maoID == 1)
                    statusMessage.setText("Super Mário Com Ritmo Fácil Esquerda");
                else if (mID == 1 && nID == 0 && modoID == 1 && maoID == 2)
                    statusMessage.setText("Super Mário Com Ritmo Fácil Ambas");
                else if (mID == 1 && nID == 1 && modoID == 0 && maoID == 0)
                    statusMessage.setText("Super Mário Normal Médio Direita");
                else if (mID == 1 && nID == 1 && modoID == 0 && maoID == 1)
                    statusMessage.setText("Super Mário Normal Médio Esquerda");
                else if (mID == 1 && nID == 1 && modoID == 0 && maoID == 2)
                    statusMessage.setText("Super Mário Normal Médio Ambas");
                else if (mID == 1 && nID == 1 && modoID == 1 && maoID == 0)
                    statusMessage.setText("Super Mário Com Ritmo Médio Direita");
                else if (mID == 1 && nID == 1 && modoID == 1 && maoID == 1)
                    statusMessage.setText("Super Mário Com Ritmo Médio Esquerda");
                else if (mID == 1 && nID == 1 && modoID == 1 && maoID == 2)
                    statusMessage.setText("Super Mário Com Ritmo Médio Ambas");
                else if (mID == 1 && nID == 2 && modoID == 0 && maoID == 0)
                    statusMessage.setText("Super Mário Normal Difícil Direita");
                else if (mID == 1 && nID == 2 && modoID == 0 && maoID == 1)
                    statusMessage.setText("Super Mário Normal Difícil Esquerda");
                else if (mID == 1 && nID == 2 && modoID == 0 && maoID == 2)
                    statusMessage.setText("Super Mário Normal Difícil Ambas");
                else if (mID == 1 && nID == 2 && modoID == 1 && maoID == 0)
                    statusMessage.setText("Super Mário Com Ritmo Difícil Direita");
                else if (mID == 1 && nID == 2 && modoID == 1 && maoID == 1)
                    statusMessage.setText("Super Mário Com Ritmo Difícil Esquerda");
                else if (mID == 1 && nID == 2 && modoID == 1 && maoID == 2)
                    statusMessage.setText("Super Mário Com Ritmo Difícil Ambas");

            }


        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        switch (parent.getId()){
            case R.id.musica:
                String musica = parent.getItemAtPosition(position).toString();
                if (musica.equals("Für Elise"))
                    mID = 0;
                else if (musica.equals("Super Mário"))
                    mID = 1;
                break;
            case R.id.modo:
                String modo = parent.getItemAtPosition(position).toString();
                if (modo.equals("Normal"))
                    modoID = 0;
                else if (modo.equals("Com Ritmo"))
                    modoID = 1;
                break;
            case R.id.nivel:
                String nivel = parent.getItemAtPosition(position).toString();
                if (nivel.equals("Fácil"))
                    nID = 0;
                else if (nivel.equals("Médio"))
                    nID = 1;
                else if (nivel.equals("Difícil"))
                    nID = 2;
                break;
            case R.id.maos:
                String maos = parent.getItemAtPosition(position).toString();
                if (maos.equals("Direita"))
                    maoID = 0;
                else if (maos.equals("Esquerda"))
                    maoID = 1;
                else if (maos.equals("Ambas"))
                    maoID = 2;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}