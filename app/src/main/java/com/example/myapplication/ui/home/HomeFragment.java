package com.example.myapplication.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsmethoden;
import com.example.myapplication.Rechnungen_ueberarbeitet.Hilfsobjekte.Hilfsobjekt1;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.tVErgebnis1.setVisibility(View.GONE);
        binding.textHome.setVisibility(View.GONE);
        //binding.layoutUnten.setVisibility(View.GONE);

        binding.btnErrechnen.setOnClickListener(view -> {
            //hier programmieren/ methode aufrufen
            try {
                double monatlichesSparen = Double.parseDouble(binding.feldMonatlichesSparen.getText().toString());
                double startkapital = Double.parseDouble(binding.feldStartkapital.getText().toString());
                double zielkapital = Double.parseDouble(binding.feldZielkapital.getText().toString());
                double zinswert = Double.parseDouble(binding.feldZinswert.getText().toString());
                double z = Hilfsmethoden.umwandelnZuGroesserEins(zinswert);
                Hilfsobjekt1 ergebnis = Hilfsmethoden.berechneWieLange(startkapital, zielkapital, monatlichesSparen, z);

                binding.tVErgebnis1.setText("Nach " + ergebnis.jahre + " Jahr(en) wird das Zielkapital erreicht und Sie werden " + ergebnis.endsumme +
                        " Euro angespart haben, wenn das Startkapital " + ergebnis.startkapital +
                        " Euro beträgt und monatlich " + ergebnis.monatlichesSparen + " Euro gespart werden.");
                binding.tVErgebnis1.setVisibility(View.VISIBLE);
                View focus = getActivity().getCurrentFocus();
                if (focus != null){
                ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(binding.btnErrechnen.getWindowToken(), 0);
                }
            } catch (NumberFormatException e){
                Toast.makeText(getContext(), "Alle Felder brauchen eine Zahl als Eingabewert.", Toast.LENGTH_LONG).show();

                /*binding.tVErgebnis.setText("Alle Felder brauchen eine Zahl als Eingabewert.");
                binding.tVErgebnis.setVisibility(View.VISIBLE);*/
            }
        });
        //binding.editTextMonatlichesSparen.setText();
        //knopf hinzufügen mit callback, welcher auf eingabefelder gettext macht um methode auszuführen


        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}