package com.islavstan.ulic.place;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.islavstan.ulic.R;


public class PlaceDialog extends DialogFragment {
    EditText editText;
    TextView title;
    TextView text;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] placeList = {"Вся Украина", "Область", "Город"};
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this.getActivity());
        dialogBuilder.setItems(placeList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int item) {

                if (placeList[item].equals("Вся Украина")) {
                    mListener.onComplete("Вся Украина");
                }

                if (placeList[item].equals("Область")) {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                    LayoutInflater inflater = getActivity().getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.dialog_for_place, null);
                    dialogBuilder.setView(dialogView);

                    dialogBuilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mListener.onComplete(editText.getText().toString().trim());

                        }
                    }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialog.dismiss();
                        }
                    });

                    title = (TextView) dialogView.findViewById(R.id.title);
                    text = (TextView) dialogView.findViewById(R.id.text);
                    editText = (EditText) dialogView.findViewById(R.id.edit_city);
                    title.setText("Область");
                    text.setText("Введите название области");
                    final AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.show();
                    alertDialog.getButton(dialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                    alertDialog.getButton(dialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);

                }



            if (placeList[item].equals("Город")) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_for_place, null);
                dialogBuilder.setView(dialogView);

                dialogBuilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onComplete(editText.getText().toString().trim());

                    }
                }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                    }
                });

                title = (TextView) dialogView.findViewById(R.id.title);
                text = (TextView) dialogView.findViewById(R.id.text);
                editText = (EditText) dialogView.findViewById(R.id.edit_city);
                title.setText("Город");
                text.setText("Введите название города");
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                alertDialog.getButton(dialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                alertDialog.getButton(dialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);

            }


        }




        });
        dialogBuilder.setCancelable(true);

        final AlertDialog dialog = dialogBuilder.create();
        return dialog;

    }


    public interface OnCompleteListener {
        void onComplete(String place);
    }

    private OnCompleteListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnCompleteListener) activity;
        } catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }
}
