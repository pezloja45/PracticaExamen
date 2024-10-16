package com.pezloja.practicaexamen;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    LinearLayout main;
    TextView str_paises, str_resultado, str_valoracion;
    Spinner sp_cambia;
    RadioGroup rg_paises, rg_ciudades1,rg_ciudades2;
    RadioButton rb_españa, rb_alemania, rb_italia, rb_cambia1, rb_cambia2, rb_cambia3, rb_cambia4, rb_cambia5, rb_cambia6;
    CheckBox cb_negrita, cb_cursiva;
    RatingBar ratBar_valoracion;
    SwitchCompat sw_modoOscuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        str_paises = findViewById(R.id.str_paises);
        str_resultado = findViewById(R.id.str_resultado);
        str_valoracion = findViewById(R.id.str_valoracion);
        sp_cambia = findViewById(R.id.sp_cambia);
        rg_paises = findViewById(R.id.rg_paises);
        rg_ciudades1 = findViewById(R.id.rg_ciudades1);
        rg_ciudades2 = findViewById(R.id.rg_ciudades2);
        rb_españa = findViewById(R.id.rb_españa);
        rb_alemania = findViewById(R.id.rb_alemania);
        rb_italia = findViewById(R.id.rb_italia);
        rb_cambia1 = findViewById(R.id.rb_cambia1);
        rb_cambia2 = findViewById(R.id.rb_cambia2);
        rb_cambia3 = findViewById(R.id.rb_cambia3);
        rb_cambia4 = findViewById(R.id.rb_cambia4);
        rb_cambia5 = findViewById(R.id.rb_cambia5);
        rb_cambia6 = findViewById(R.id.rb_cambia6);
        cb_negrita = findViewById(R.id.cb_negrita);
        cb_cursiva = findViewById(R.id.cb_cursiva);
        ratBar_valoracion = findViewById(R.id.ratBar_valoracion);
        sw_modoOscuro = findViewById(R.id.sw_modoOscuro);

        rb_cambia1.setOnClickListener(view -> {desmarcarGrupo(2);cambiarText();});
        rb_cambia2.setOnClickListener(view -> {desmarcarGrupo(2);cambiarText();});
        rb_cambia3.setOnClickListener(view -> {desmarcarGrupo(2);cambiarText();});
        rb_cambia4.setOnClickListener(view -> {desmarcarGrupo(1);cambiarText();});
        rb_cambia5.setOnClickListener(view -> {desmarcarGrupo(1);cambiarText();});
        rb_cambia6.setOnClickListener(view -> {desmarcarGrupo(1);cambiarText();});

        rg_paises.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                cambiaSpinner();
                cambiarText();
            }
        });

        sp_cambia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cambiarBotones(i);
                cambiarText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        cb_cursiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if (check) {
                    if (cb_negrita.isChecked()) {
                        str_resultado.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        str_resultado.setTypeface(null, Typeface.ITALIC);
                    }
                } else {
                    if (cb_negrita.isChecked()) {
                        str_resultado.setTypeface(null, Typeface.BOLD);
                    } else {
                        str_resultado.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });

        cb_negrita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if (check) {
                    if (cb_cursiva.isChecked()) {
                        str_resultado.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        str_resultado.setTypeface(null, Typeface.BOLD);
                    }
                } else {
                    if (cb_cursiva.isChecked()) {
                        str_resultado.setTypeface(null, Typeface.ITALIC);
                    } else {
                        str_resultado.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });

        ratBar_valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (v < 3) {
                    str_resultado.setTextColor(getResources().getColor(R.color.strMenor2));
                    Toast.makeText(MainActivity.this, "Se ha aplicado la condicion menor a 2", Toast.LENGTH_SHORT).show();
                } else if (v == 3) {
                    str_resultado.setTextColor(getResources().getColor(R.color.strIgual3));
                    Toast.makeText(MainActivity.this, "Se ha aplicado la condicion igual a 3", Toast.LENGTH_LONG).show();
                } else {
                    str_resultado.setTextColor(getResources().getColor(R.color.strMayor3));
                    Toast.makeText(MainActivity.this, "Se ha aplicado la condicion mayor a 3", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sw_modoOscuro.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                modoOscuro();
            } else  {
                modoDesoscuro();
            }
        });
    }

    private void modoOscuro() {
        int textoOscuro = getColor(R.color.textosOscuro);
        main.setBackgroundColor(getColor(R.color.mainOscuro));
        str_paises.setTextColor(textoOscuro);
        str_valoracion.setTextColor(textoOscuro);
        rb_españa.setTextColor(textoOscuro);
        rb_alemania.setTextColor(textoOscuro);
        rb_italia.setTextColor(textoOscuro);
        rb_cambia1.setTextColor(textoOscuro);
        rb_cambia2.setTextColor(textoOscuro);
        rb_cambia3.setTextColor(textoOscuro);
        rb_cambia4.setTextColor(textoOscuro);
        rb_cambia5.setTextColor(textoOscuro);
        rb_cambia6.setTextColor(textoOscuro);
        cb_negrita.setTextColor(textoOscuro);
        cb_cursiva.setTextColor(textoOscuro);
        sp_cambia.setBackgroundColor(textoOscuro);
        sw_modoOscuro.setTextColor(textoOscuro);
        Toast.makeText(this, "Modo'h obscuro aktibado", Toast.LENGTH_SHORT).show();
        Log.i("Oscuro", "Modo oscuro activado");
    }
    private void modoDesoscuro() {
        int textoClaro = getColor(R.color.textosClaro);
        main.setBackgroundColor(getColor(R.color.mainClaro));
        str_paises.setTextColor(textoClaro);
        str_valoracion.setTextColor(textoClaro);
        rb_españa.setTextColor(textoClaro);
        rb_alemania.setTextColor(textoClaro);
        rb_italia.setTextColor(textoClaro);
        rb_cambia1.setTextColor(textoClaro);
        rb_cambia2.setTextColor(textoClaro);
        rb_cambia3.setTextColor(textoClaro);
        rb_cambia4.setTextColor(textoClaro);
        rb_cambia5.setTextColor(textoClaro);
        rb_cambia6.setTextColor(textoClaro);
        cb_negrita.setTextColor(textoClaro);
        cb_cursiva.setTextColor(textoClaro);
        sw_modoOscuro.setTextColor(textoClaro);
        Toast.makeText(this, "Modo'h obskuro desaktibado", Toast.LENGTH_SHORT).show();
        Log.i("Oscuro", "Modo oscuro desactivado");
    }

    private void cambiarText() {
        int selectedId = rg_paises.getCheckedRadioButtonId();
        String seleccionadoTexto = ((RadioButton)findViewById(selectedId)).getText().toString();
        String seleccionadoSpinner = sp_cambia.getItemAtPosition(sp_cambia.getSelectedItemPosition()).toString();
        String seleccionadoCiudad = "";

        if (rb_cambia1.isChecked()) {
            seleccionadoCiudad = rb_cambia1.getText().toString();
        } else if (rb_cambia2.isChecked()) {
            seleccionadoCiudad = rb_cambia2.getText().toString();
        } else if (rb_cambia3.isChecked()) {
            seleccionadoCiudad = rb_cambia3.getText().toString();
        } else if (rb_cambia4.isChecked()) {
            seleccionadoCiudad = rb_cambia4.getText().toString();
        } else if (rb_cambia5.isChecked()) {
            seleccionadoCiudad = rb_cambia5.getText().toString();
        } else if (rb_cambia6.isChecked()) {
            seleccionadoCiudad = rb_cambia6.getText().toString();
        }
        str_resultado.setText(seleccionadoTexto + ", " + seleccionadoSpinner + ", " + seleccionadoCiudad);
    }

    private void desmarcarGrupo(int i) {
        if (i == 1) {
            rb_cambia1.setChecked(false);
            rb_cambia2.setChecked(false);
            rb_cambia3.setChecked(false);
        } else if (i == 2) {
            rb_cambia4.setChecked(false);
            rb_cambia5.setChecked(false);
            rb_cambia6.setChecked(false);
        }
    }

    private void cambiaSpinner() {
        int miArray = 0;
        if (rb_españa.isChecked()) {
            miArray = R.array.sp_españa;
        } else if (rb_alemania.isChecked()) {
            miArray = R.array.sp_alemania;
        } else if (rb_italia.isChecked()) {
            miArray = R.array.sp_italia;
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, miArray, android.R.layout.simple_dropdown_item_1line);
        sp_cambia.setAdapter(adapter);
    }

    private void cambiarBotones(int i) {
        String str1 = "", str2 = "", str3 = "", str4 = "", str5 = "", str6 = "";
        switch (i) {
            case 0:
                if (rb_españa.isChecked()) {
                    str1 = getString(R.string.rb_madridCapital);
                    str2 = getString(R.string.rb_alcalaDeHenares);
                    str3 = getString(R.string.rb_getafe);
                    str4 = getString(R.string.rb_leganes);
                    str5 = getString(R.string.rb_mostoles);
                    str6 = getString(R.string.rb_alcorcon);
                } else if (rb_alemania.isChecked()) {
                    str1 = getString(R.string.rb_munich);
                    str2 = getString(R.string.rb_nuremberg);
                    str3 = getString(R.string.rb_augsburgo);
                    str4 = getString(R.string.rb_ratisbona);
                    str5 = getString(R.string.rb_wurzburgo);
                    str6 = getString(R.string.rb_ingolstadt);
                } else if (rb_italia.isChecked()) {
                    str1 = getString(R.string.rb_romaCapital);
                    str2 = getString(R.string.rb_tivoli);
                    str3 = getString(R.string.rb_frascati);
                    str4 = getString(R.string.rb_civitavecchia);
                    str5 = getString(R.string.rb_castelGandolfo);
                    str6 = getString(R.string.rb_bracciano);
                }
                break;
            case 1:
                if (rb_españa.isChecked()) {
                    str1 = getString(R.string.rb_barcelonaCapital);
                    str2 = getString(R.string.rb_hospitaletDeLlobregat);
                    str3 = getString(R.string.rb_badalona);
                    str4 = getString(R.string.rb_terrassa);
                    str5 = getString(R.string.rb_sabadell);
                    str6 = getString(R.string.rb_manresa);
                } else if (rb_alemania.isChecked()) {
                    str1 = getString(R.string.rb_francfort);
                    str2 = getString(R.string.rb_wiesbaden);
                    str3 = getString(R.string.rb_kassel);
                    str4 = getString(R.string.rb_darmstadt);
                    str5 = getString(R.string.rb_offenbach);
                    str6 = getString(R.string.rb_hanau);
                } else if (rb_italia.isChecked()) {
                    str1 = getString(R.string.rb_milanoCapital);
                    str2 = getString(R.string.rb_sestoSanGiovanni);
                    str3 = getString(R.string.rb_rho);
                    str4 = getString(R.string.rb_ciniselloBalsamo);
                    str5 = getString(R.string.rb_sanDonatoMilanese);
                    str6 = getString(R.string.rb_legnano);
                }
                break;
            case 2:
                if (rb_españa.isChecked()) {
                    str1 = getString(R.string.rb_sevillaCapital);
                    str2 = getString(R.string.rb_dosHermanas);
                    str3 = getString(R.string.rb_alcalaDeGuadaira);
                    str4 = getString(R.string.rb_utrera);
                    str5 = getString(R.string.rb_mairenaDelAljarafe);
                    str6 = getString(R.string.rb_ecija);
                } else if (rb_alemania.isChecked()) {
                    str1 = getString(R.string.rb_dresde);
                    str2 = getString(R.string.rb_leipzig);
                    str3 = getString(R.string.rb_chemnitz);
                    str4 = getString(R.string.rb_zwickau);
                    str5 = getString(R.string.rb_gorlitz);
                    str6 = getString(R.string.rb_plauen);
                } else if (rb_italia.isChecked()) {
                    str1 = getString(R.string.rb_florenciaCapital);
                    str2 = getString(R.string.rb_fiesole);
                    str3 = getString(R.string.rb_empoli);
                    str4 = getString(R.string.rb_pontassieve);
                    str5 = getString(R.string.rb_bagnoARipoli);
                    str6 = getString(R.string.rb_sestoFiorentino);
                }
                break;
        }
        rb_cambia1.setText(str1);
        rb_cambia2.setText(str2);
        rb_cambia3.setText(str3);
        rb_cambia4.setText(str4);
        rb_cambia5.setText(str5);
        rb_cambia6.setText(str6);
    }
}