package com.example.passwordsupport.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.passwordsupport.R;
import com.example.passwordsupport.mvp.presenter.MainActivityPresenter;
import com.example.passwordsupport.mvp.view.MainActivityView;

public class MainActivity extends MvpActivity implements MainActivityView {

    private TextView mResultTextView;
    private EditText mSourceTextView;
    private View mCopyButton;
    private ImageView mQuality;
    private TextView mQualityTextView;

    private CompoundButton mUseUppercase;

    @InjectPresenter
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initListeners();
    }

    public void initUI(){
        mResultTextView = findViewById(R.id.result_text);
        mSourceTextView = findViewById(R.id.source_text);
        mCopyButton = findViewById(R.id.button_copy);
        mQuality = findViewById(R.id.quality);
        mQualityTextView = findViewById(R.id.quality_text);
        mUseUppercase = findViewById(R.id.check_uppercase);
    }

    public void initListeners(){
        mCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mSourceTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
