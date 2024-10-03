package com.jah.aplicandoestilos;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgColores;
    RadioButton rbRojo, rbVerde, rbAzul;
    CheckBox cbNegrita, cbCursiva;
    Switch swOscuro, swInformacion;
    TextView lblMostrar, lblOscuro, lblInformacion, lblEstilo, lblColor;
    LinearLayout lyMain;
    ArrayList<String> registros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rgColores = findViewById(R.id.rgColores);
        rbRojo = findViewById(R.id.rbRojo);
        rbVerde = findViewById(R.id.rbVerde);
        rbAzul = findViewById(R.id.rbAzul);
        cbNegrita = findViewById(R.id.cbNegrita);
        cbCursiva = findViewById(R.id.cbCursiva);
        swInformacion = findViewById(R.id.swInformacion);
        swOscuro = findViewById(R.id.swOscuro);
        lblMostrar = findViewById(R.id.lblMostrar);
        lblColor = findViewById(R.id.lblColor);
        lblEstilo = findViewById(R.id.lblEstilo);
        lblInformacion = findViewById(R.id.lblInformacion);
        lblOscuro = findViewById(R.id.lblOsucro);
        lyMain = findViewById(R.id.lyMain);
        registros = new ArrayList<String>();


        rgColores.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            cambiarColor(checkedId, registros);
        });

        cbNegrita.setOnCheckedChangeListener((compoundButton, b) -> {
            cambiarNegrita(b, registros);
        });
        cbCursiva.setOnCheckedChangeListener((compundButton, b) -> {
            cambiarCursiva(b, registros);
        });

        swOscuro.setOnCheckedChangeListener((compoundButton, b) -> {
            cambiarOscuro(b, registros);
        });
        swInformacion.setOnCheckedChangeListener((compoundButton, b) -> {
            mostrarLogs(b, registros);
        });

    }

    private void mostrarLogs(boolean b, ArrayList<String> registros) {
        registros.add("------------------------------------------");
        if (b) {
            for (String registro : registros) {
                Log.i("DAM", registro);
            }
            registros.clear();
        }
    }

    private void cambiarOscuro(boolean b, ArrayList<String> registros) {
        if (b) {
            lyMain.setBackgroundColor(Color.BLACK);
            lblColor.setTextColor(Color.WHITE);
            lblEstilo.setTextColor(Color.WHITE);
            lblInformacion.setTextColor(Color.WHITE);
            lblOscuro.setTextColor(Color.WHITE);
            rbRojo.setTextColor(Color.WHITE);
            rbVerde.setTextColor(Color.WHITE);
            rbAzul.setTextColor(Color.WHITE);
            cbNegrita.setTextColor(Color.WHITE);
            cbCursiva.setTextColor(Color.WHITE);
            registros.add("Modo oscuro activado");
        } else {
            lyMain.setBackgroundColor(Color.WHITE);
            lblColor.setTextColor(Color.BLACK);
            lblEstilo.setTextColor(Color.BLACK);
            lblInformacion.setTextColor(Color.BLACK);
            lblOscuro.setTextColor(Color.BLACK);
            rbRojo.setTextColor(Color.BLACK);
            rbVerde.setTextColor(Color.BLACK);
            rbAzul.setTextColor(Color.BLACK);
            cbNegrita.setTextColor(Color.BLACK);
            cbCursiva.setTextColor(Color.BLACK);
            registros.add("Modo oscuro desactivado");
        }

    }

    private void cambiarCursiva(boolean b, ArrayList<String> registros) {
        int currentStyle = lblMostrar.getTypeface().getStyle();
        if (b) {
            lblMostrar.setTypeface(Typeface.create(lblMostrar.getTypeface(), currentStyle | Typeface.ITALIC));
            registros.add("has cambiado el estilo a cursiva");
        } else {
            lblMostrar.setTypeface(Typeface.create(lblMostrar.getTypeface(), currentStyle & ~Typeface.ITALIC));
            registros.add("has eliminado el estilo cursiva");
        }
    }


    private void cambiarNegrita(boolean b, ArrayList<String> registros) {
        int currentStyle = lblMostrar.getTypeface().getStyle();
        if (b) {
            lblMostrar.setTypeface(Typeface.create(lblMostrar.getTypeface(), currentStyle | Typeface.BOLD));
            registros.add("has cambiado el estilo a negrita");
        } else {
            lblMostrar.setTypeface(Typeface.create(lblMostrar.getTypeface(), currentStyle & ~Typeface.BOLD));
            registros.add("has eliminado el estilo negrita");
        }
    }

    private void cambiarColor(int asignar, ArrayList<String> registros) {
        if (asignar != -1) {
            if (rbRojo.isChecked()) {
                lblMostrar.setTextColor(Color.RED);
                registros.add("Color cambiado a rojo");
            } else if (rbVerde.isChecked()) {
                lblMostrar.setTextColor(Color.GREEN);
                registros.add("Color cambiado a verde");
            } else if (rbAzul.isChecked()) {
                lblMostrar.setTextColor(Color.BLUE);
                registros.add("Color cambiado a azul");
            }

        }
    }
}

