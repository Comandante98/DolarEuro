package com.dantesoft.dolareuro;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> cambioD = new MutableLiveData<>();
    private MutableLiveData<String> cambioE = new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context =  application.getApplicationContext();
    }

    public LiveData<String> getCambioD(){return cambioD;}
    public LiveData<String> getCambioE(){return cambioE;}
    public void calcCambio(double dolar, double euro){
        if(dolar == 0 && euro == 0){
            Toast.makeText(context, "No ingreso un valor, intente nuevamente", Toast.LENGTH_LONG).show();
            return;
        }
        if(euro == 0){
            cambioE.setValue(String.valueOf(dolar * 0.93));
        }

        if(dolar == 0){
            cambioD.setValue(String.valueOf(euro * 1.08));
        }
    }
}
