package com.example.listamusical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityListaBandas extends AppCompatActivity {

    ArrayList<String> bandasRelacionadas;
    ArrayList<String> bandasRelacionadasCopia;
    ArrayAdapter<String> arrayAdapter;
    SearchView searchView;
    ListView listView;

    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_bandas);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listViewBandas);

        searchView.setIconified(false);

        // Recupere os estilos musicais selecionados do intent
        ArrayList<String> estilosSelecionados = getIntent().getStringArrayListExtra("estilosSelecionados");

        bandasRelacionadas = new ArrayList<>();
        bandasRelacionadasCopia = new ArrayList<>();

        for (String estilo : estilosSelecionados) {
            if (estilo.equals("Rock")) {
                bandasRelacionadas.add("Metallica");
                bandasRelacionadas.add("Iron Maiden");
                bandasRelacionadas.add("Guns N’ Roses");
            } else if (estilo.equals("POP")) {
                bandasRelacionadas.add("Bruno Mars");
                bandasRelacionadas.add("Adele");
                bandasRelacionadas.add("Maroon 5");
            } else if (estilo.equals("Pagode")) {
                bandasRelacionadas.add("Exalta-Samba");
                bandasRelacionadas.add("Pixote");
                bandasRelacionadas.add("Ferrugem");
            } else if (estilo.equals("Funk")) {
                bandasRelacionadas.add("MC Ryan SP");
                bandasRelacionadas.add("MC Tatizaqui");
                bandasRelacionadas.add("MC Tarapi");
            } else if (estilo.equals("Rap")) {
                bandasRelacionadas.add("Racionais");
                bandasRelacionadas.add("Hungria Hip Hop");
                bandasRelacionadas.add("Tribo da Periferia");
            } else if (estilo.equals("Sertanejo")) {
                bandasRelacionadas.add("Zé Neto e Cristiano");
                bandasRelacionadas.add("Cristiano Araújo");
                bandasRelacionadas.add("Henrique e Juliano");
            }
        }

        btnVoltar = findViewById(R.id.btnv);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Mantenha uma cópia original das bandas relacionadas
        bandasRelacionadasCopia.addAll(bandasRelacionadas);

        // Configure o adapter para a ListView com os dados iniciais
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bandasRelacionadas);
        listView.setAdapter(arrayAdapter);

        // Configure o ouvinte de consulta para o SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fazerBusca(newText);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void fazerBusca(String s) {
        bandasRelacionadas.clear();

        s = s.toLowerCase();

        for (String item : bandasRelacionadasCopia) {
            if (item.toLowerCase().contains(s)) {
                bandasRelacionadas.add(item);
            }
        }

    }
}