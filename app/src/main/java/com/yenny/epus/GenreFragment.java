package com.yenny.epus;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenreFragment extends DialogFragment implements View.OnClickListener{
private Button btnChoose, btnClose;
private RadioGroup rgGenre;
private RadioButton rbFiksi, rbNonfiksi, rbJurnal ;
private OnOptionDialogListener onOptionDialogListener;
public GenreFragment() {
         // Required empty public constructor
        }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
        }
public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genre, container, false);
            btnChoose = (Button)view.findViewById(R.id.btn_choose);
            btnChoose.setOnClickListener(this);
            btnClose = (Button)view.findViewById(R.id.btn_close);
            btnClose.setOnClickListener(this);
            rgGenre = (RadioGroup)view.findViewById(R.id.rg_genre);
            rbFiksi = (RadioButton)view.findViewById(R.id.rb_fiksi);
            rbNonfiksi = (RadioButton)view.findViewById(R.id.rb_non_fiksi);
            rbJurnal = (RadioButton)view.findViewById(R.id.rb_jurnal);
            return view;
        }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgGenre.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1){
                    String coach = null;
                    switch (checkedRadioButtonId){
                        case R.id.rb_fiksi:
                            coach = rbFiksi.getText().toString().trim();
                            Intent intentFiksi = new Intent(getActivity(), ListFiksiBook.class);
                            startActivity(intentFiksi);
                            break;
                        case R.id.rb_non_fiksi:
                            coach = rbNonfiksi.getText().toString().trim();
                            Intent intentNonfiksi = new Intent(getActivity(), ListNonfiksiBook.class);
                            startActivity(intentNonfiksi);
                            break;
                        case R.id.rb_jurnal:
                            coach = rbJurnal.getText().toString().trim();
                            Intent intentJurnal = new Intent(getActivity(), ListJurnal.class);
                            startActivity(intentJurnal);
                            break;
                        }
                        getOnOptionDialogListener().onOptionChoosen(coach);
                        getDialog().cancel();
                    }
                break;
            }
        }
    public interface OnOptionDialogListener{
    void onOptionChoosen(String text);

    }
}


