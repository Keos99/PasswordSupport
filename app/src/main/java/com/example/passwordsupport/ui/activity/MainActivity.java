package com.example.passwordsupport.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
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
        presenter.pPrepareArraysOfAlphabet(getResources().getStringArray(R.array.russian),
                getResources().getStringArray(R.array.english));
    }

    public void initUI(){
        mResultTextView = findViewById(R.id.result_text);
        mSourceTextView = findViewById(R.id.source_text);
        mCopyButton = findViewById(R.id.button_copy);
        mQuality = findViewById(R.id.quality);
        mQualityTextView = findViewById(R.id.quality_text);
        mUseUppercase = findViewById(R.id.check_uppercase);
        mCopyButton.setEnabled(false);
    }

    public void initListeners(){
        mCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                manager.setPrimaryClip(ClipData.newPlainText(
                        MainActivity.this.getString(R.string.clipboard_title),
                        mResultTextView.getText()
                ));
                toastMakeText(R.string.message_copied);
            }
        });

        mSourceTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mResultTextView.setText(presenter.convert(charSequence));
                mCopyButton.setEnabled(charSequence.length() > 0);
                int quality = presenter.getQuality(charSequence);
                mQuality.setImageLevel(quality * 1000);
                mQualityTextView.setText(getResources().getStringArray(R.array.qualities)[quality]);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void toastMakeText(int stringRes) {
        Toast.makeText(this,stringRes,Toast.LENGTH_LONG).show();
    }
}
