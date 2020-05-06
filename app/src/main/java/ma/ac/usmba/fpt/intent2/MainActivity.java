package ma.ac.usmba.fpt.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String joueur1Name, joueur2Name;
    EditText editJoueur1, editJoueur2;
    Button btnJouer;
    public static final String NAME1 = "Name1", NAME2 = "Name2", NBR_MGC = "nbr_mgc", FROM="from";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editJoueur1 = (EditText) findViewById(R.id.joueur_1);
        editJoueur2 = (EditText) findViewById(R.id.joueur_2);
        btnJouer = (Button) findViewById(R.id.btn_jouer);

        btnJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joueur1Name = editJoueur1.getText().toString();
                joueur2Name = editJoueur2.getText().toString();
                Intent intent = new Intent(MainActivity.this, Joueur1Activity.class);
                intent.putExtra(FROM, MainActivity.class.getName());
                intent.putExtra(NAME1, joueur1Name);
                intent.putExtra(NAME2, joueur2Name);
                int nbrMgc = new Random().nextInt(10) + 1;
                Log.d("MainActivity", "" + nbrMgc);
                intent.putExtra(NBR_MGC, nbrMgc);
                startActivity(intent);
            }
        });

    }

}
