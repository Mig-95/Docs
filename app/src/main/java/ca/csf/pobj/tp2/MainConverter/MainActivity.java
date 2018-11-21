package ca.csf.pobj.tp2.MainConverter;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ca.csf.pobj.tp2.R;
import ca.csf.pobj.tp2.Utils.NumberUtils;
import ca.csf.pobj.tp2.Utils.StringUtils;

public class MainActivity extends AppCompatActivity {

    private View rootView;
    private EditText currentInput;
    private Button confirmButton;
    private TextView currentDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.rootView);
        currentInput = findViewById(R.id.editText);
        currentInput.setFilters(new InputFilter[]{new MinMaxFilter("1", "4999")});
        confirmButton = findViewById(R.id.buttonToRoman);
        currentDisplay = findViewById(R.id.outputTextView);
        isReturnPressedConditions();
        confirmButtonDisableConditions();
    }

    public void onButtonClicked(View view) {
        if (isInputBlank()) {
            showEmptyInputMessage();
        } else {
            currentDisplay.setText(ToRomanNumerals.IntToRomanNumber(inputToInteger()));
        }
        hideKeyboard();
    }

    public void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(
                (null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public Integer inputToInteger() {
        return NumberUtils.toInteger(currentInput.getText().toString());
    }

    private void showEmptyInputMessage() {
        Snackbar.make(rootView, R.string.error_empty_input, Snackbar.LENGTH_SHORT).show();
    }

    private boolean isInputBlank() {
        return StringUtils.isBlank(currentInput.getText().toString());
    }

    private void isReturnPressedConditions() {
        currentInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE) {
                    if (isInputBlank()) {
                        showEmptyInputMessage();
                    } else {
                        currentDisplay.setText(ToRomanNumerals.IntToRomanNumber(inputToInteger()));
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(currentInput.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void confirmButtonDisableConditions() {
        confirmButton.setEnabled(false);
        currentInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().equals("")) {
                    confirmButton.setEnabled(false);
                } else {
                    confirmButton.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    confirmButton.setEnabled(false);
                } else {
                    confirmButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    confirmButton.setEnabled(false);
                } else {
                    confirmButton.setEnabled(true);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("LIFE CYCLE", "ON START");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("LIFE CYCLE", "ON STOP");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("LIFE CYCLE", "ON RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("LIFE CYCLE", "ON PAUSE");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putCharSequence("userInput", (this.currentInput).getText().toString());
        outState.putCharSequence("display", this.currentDisplay.getText().toString());
        super.onSaveInstanceState(outState);

        Log.v("LIFE CYCLE", "ON SAVE");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        this.currentInput.setText(savedInstanceState.getCharSequence("userInput"));
        this.currentDisplay.setText(savedInstanceState.getCharSequence("display"));
        super.onRestoreInstanceState(savedInstanceState);

        Log.v("LIFE CYCLE", "ON RESTORE");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("LIFE CYCLE", "ON DESTROY");
    }

}
