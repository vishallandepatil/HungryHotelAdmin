package com.hungry.hotel.hungryhoteladmin.restaurentmenu.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.utils.PrefManager;

public class FilterDialog extends Dialog implements View.OnClickListener {

    public Activity activity;

    RadioGroup radioGroup;
    ImageView img_close;
    public FilterDialog() {
        super(null);
    }
    public FilterDialog(Activity activity)  {
        super(activity);
        this.activity = activity;
      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.filterdialog);
        bindView();
        btnlistener();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > 1) {
                    Toast.makeText(activity, rb.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public void onClick(View v) {

        Log.e("onClick", "Clicked");

        switch (v.getId()) {

            case R.id.img_close:
                dismiss();
                break;
        }
    }

    private void btnlistener() {
        img_close.setOnClickListener(this);
        radioGroup =  findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

    }
    private void bindView() {
        img_close =  findViewById(R.id.img_close);

    }

}
