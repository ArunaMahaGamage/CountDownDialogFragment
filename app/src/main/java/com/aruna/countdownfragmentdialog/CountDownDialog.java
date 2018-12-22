package com.aruna.countdownfragmentdialog;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aruna on 12/21/18.
 */

public class CountDownDialog extends DialogFragment {

    private TextView mCountdownView;

    public CountDownDialog(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countdowntimer_dialog, container);
        mCountdownView = (TextView) view.findViewById(R.id.countdownTimer);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mCountdownView.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                dismiss();
            }
        }.start();
    }
}
