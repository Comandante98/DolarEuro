package com.dantesoft.dolareuro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.dantesoft.dolareuro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);


        binding.cambioDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.dolaresF.setEnabled(false);
                binding.eurosF.setEnabled(true);
                binding.dolaresF.setText("0");
                binding.cambioEuro.setChecked(false);
            }
        });

        binding.cambioEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.dolaresF.setEnabled(true);
                binding.eurosF.setEnabled(false);
                binding.eurosF.setText("0");
                binding.cambioDolar.setChecked(false);
            }
        });
        binding.bCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.calcCambio(Double.parseDouble(binding.dolaresF.getText().toString()),Double.parseDouble(binding.eurosF.getText().toString()));
            }
        });

        vm.getCambioD().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String d) { binding.dineroC.setText(d);}
        });

        vm.getCambioE().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String e) { binding.dineroC.setText(e);}
        });
    }


}