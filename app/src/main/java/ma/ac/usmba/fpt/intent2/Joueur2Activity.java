package ma.ac.usmba.fpt.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Joueur2Activity extends AppCompatActivity {
    TextView txtJoueurName, txtResultat;
    EditText edtNumber;
    Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur2);

        txtJoueurName = (TextView) findViewById(R.id.txt_name);
        txtResultat = (TextView) findViewById(R.id.txt_resultat);
        edtNumber = (EditText) findViewById(R.id.edt_nmbr);
        btnValider = (Button) findViewById(R.id.btn_valider);

        Intent intent = getIntent();
        txtJoueurName.setText("Joueur 2: " + intent.getStringExtra(MainActivity.NAME2));

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int nbrMgc = getIntent().getIntExtra(MainActivity.NBR_MGC, 0);

                int nbrSaisi = Integer.parseInt(edtNumber.getText().toString());

                if (nbrSaisi == nbrMgc) {
                    txtResultat.setText(getIntent().getStringExtra(MainActivity.NAME2) + " Wins !!!");
                } else {
                    Intent intent = new Intent(Joueur2Activity.this, Joueur1Activity.class);
                    intent.putExtra(MainActivity.NAME1, getIntent().getStringExtra(MainActivity.NAME1));
                    intent.putExtra(MainActivity.NAME2, getIntent().getStringExtra(MainActivity.NAME2));
                    intent.putExtra(MainActivity.NBR_MGC, nbrMgc);
                    startActivity(intent);
                }
            }
        });
    }
}
