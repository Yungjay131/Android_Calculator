package com.slyworks.calculator;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class dialog extends DialogFragment implements View.OnClickListener{
    private Button btnExit,btnCancel;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_layout, null);

        btnExit = dialogView.findViewById(R.id.btnExit);
        btnCancel  = dialogView.findViewById(R.id.btnCancel);

        builder.setView(dialogView).setMessage("Are you sure you want to exit")
                .setTitle("Confirmation");
        return builder.create();



    }

    @Override
    public void onClick(View view){
        switch(view.getId()){

        }

    }
}
