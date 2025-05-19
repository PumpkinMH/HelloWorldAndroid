package com.example.helloworld;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class InputAlertDialogFragment extends DialogFragment {
    private EditText inputField;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        inputField = new EditText(requireContext());

        builder.setMessage(R.string.input_alert_title)
                .setPositiveButton("Enter", (dialogInterface, i) -> {
//                    Toast.makeText(requireContext(), getInput(), Toast.LENGTH_SHORT).show();
                    Intent outputIntent = new Intent(requireContext(), DisplayInputActivity.class);
                    outputIntent.putExtra("com.example.helloworld.USER_INPUT", getInput());
                    startActivity(outputIntent);
                })
                .setNegativeButton("Cancel", null)
                .setView(inputField);

        return builder.create();
    }

    private String getInput() {
        if(inputField != null) {
            return inputField.getText().toString();
        } else {
            throw new IllegalStateException("EditText has not been initialized yet");
        }
    }
}
