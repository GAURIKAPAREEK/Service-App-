package com.studentease.mygsapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutLogin, layoutServices, layoutFinal;
    ImageView ivPreview;
    TextView tvLocation, tvTotal;
    ProgressBar payProgress;
    Button btnPay, btnDial;
    int baseTotal = 0;
    private static final int REQ_CAM = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutLogin = findViewById(R.id.layoutLogin);
        layoutServices = findViewById(R.id.layoutServices);
        layoutFinal = findViewById(R.id.layoutFinal);
        ivPreview = findViewById(R.id.ivPreview);
        tvLocation = findViewById(R.id.tvLocation);
        tvTotal = findViewById(R.id.tvTotal);
        payProgress = findViewById(R.id.payProgress);
        btnPay = findViewById(R.id.btnPay);
        btnDial = findViewById(R.id.btnDial);

        final EditText etPass = findViewById(R.id.etPass);
        final Spinner spinner = findViewById(R.id.spinnerPro);
        final RadioGroup rg = findViewById(R.id.rgUrgency);

        String[] options = {"Plumber (₹1000)", "Electrician (₹1200)", "Carpenter (₹900)"};
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options));

        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            if (isValid(etPass.getText().toString())) {
                hideKB(v);
                layoutLogin.setVisibility(View.GONE);
                layoutServices.setVisibility(View.VISIBLE);
            } else {
                etPass.setError("Need 8 chars, 1 Uppercase, 1 Number, 1 Special Char");
            }
        });

        findViewById(R.id.btnUpload).setOnClickListener(v -> startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), REQ_CAM));
        findViewById(R.id.btnLocation).setOnClickListener(v -> tvLocation.setText("Location: Delhi NCR (Verified)"));

        findViewById(R.id.btnToFinal).setOnClickListener(v -> {
            baseTotal = (spinner.getSelectedItemPosition() == 0) ? 1000 : (spinner.getSelectedItemPosition() == 1 ? 1200 : 900);
            if (rg.getCheckedRadioButtonId() == R.id.rbExpress) baseTotal += 500;
            tvTotal.setText("₹" + baseTotal);
            layoutServices.setVisibility(View.GONE);
            layoutFinal.setVisibility(View.VISIBLE);
        });

        btnPay.setOnClickListener(v -> {
            int bill = baseTotal;
            if (((CheckBox)findViewById(R.id.cbInsurance)).isChecked()) bill += 100;
            if (((CheckBox)findViewById(R.id.cbParts)).isChecked()) bill += 400;
            tvTotal.setText("₹" + bill);
            btnPay.setVisibility(View.GONE);
            payProgress.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                payProgress.setVisibility(View.GONE);
                Toast.makeText(this, "Transaction Successful!", Toast.LENGTH_SHORT).show();
                btnDial.setVisibility(View.VISIBLE);
            }, 2500);
        });

        btnDial.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:919999999999"))));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CAM && resultCode == RESULT_OK && data != null) {
            ivPreview.setImageBitmap((Bitmap) data.getExtras().get("data"));
            ivPreview.setVisibility(View.VISIBLE);
        }
    }

    private void hideKB(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    private boolean isValid(String p) {
        if (p.length() < 8) return false;
        return Pattern.compile("[A-Z]").matcher(p).find() && Pattern.compile("[0-9]").matcher(p).find() && Pattern.compile("[^a-zA-Z0-9]").matcher(p).find();
    }
}