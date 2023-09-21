package com.tj.spensa;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tj.spensa.databinding.ActivityAddNewTransactionBinding;
import com.tj.spensa.utils.Helper;

import java.util.Calendar;


public class AddNewTransaction extends BottomSheetDialogFragment {


    public AddNewTransaction(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    ActivityAddNewTransactionBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = ActivityAddNewTransactionBinding.inflate(inflater);

        binding.nuevoFechaInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext());
                datePickerDialog.setOnDateSetListener((datePicker, i, i1, i2)->{
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                    calendar.set(Calendar.MONTH, datePicker.getMonth());
                    calendar.set(Calendar.YEAR, datePicker.getYear());

                    String dateShow = Helper.formatDateString(calendar.getTime());
                    binding.nuevoFechaInput.setText(dateShow);

                });
                datePickerDialog.show();
            }
        });
        //El resto de los binding componentes...........
        binding.nuevoGuardarBtn.setOnClickListener(c ->{
            //guardarTransaccion() crear metodo para guardar en la base de datos.
        });
        return binding.getRoot();
    }

}