package com.example.thuchanh1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRun, btnClose;
    EditText txtNhap, txtKetqua;

    RadioButton btnSS, btnBS, btnIS;
    boolean isRadioButtonChecked = false;

    private void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void interchangeSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNhap = (EditText) findViewById(R.id.txtNhap);
        txtKetqua = (EditText) findViewById(R.id.txtKetqua);
        btnSS = (RadioButton) findViewById(R.id.btnSS);
        btnBS = (RadioButton) findViewById(R.id.btnBS);
        btnIS = (RadioButton) findViewById(R.id.btnIS);
        btnRun = (Button) findViewById(R.id.btnRun);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);
        btnRun.setOnClickListener(this);
        btnSS.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnIS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String daysonhap = txtNhap.getText().toString();
        if (v instanceof RadioButton)
        {
            txtNhap.setText("");
            txtKetqua.setText("");
            isRadioButtonChecked = true;
        }

        if(daysonhap.isEmpty())
        {
            Toast.makeText(this, "Vui lòng nhập dữ liệu vào txtNhap", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] daysovuanhap = daysonhap.split(" ");
        int[] arr = new int[daysovuanhap.length];

        for (int i = 0; i < daysovuanhap.length; i++) {
            arr[i] = Integer.parseInt(daysovuanhap[i]);
        }

        if (v.getId() == R.id.btnRun) {
            if (!isRadioButtonChecked) {
                Toast.makeText(this, "Vui lòng chọn một phương pháp sắp xếp", Toast.LENGTH_SHORT).show();
                return;
            }
            if (btnSS.isChecked()) {
                selectionSort(arr);
            } else if (btnBS.isChecked()) {
                bubbleSort(arr);
            } else if (btnIS.isChecked()) {
                interchangeSort(arr);
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                result.append(arr[i]).append(" ");
            }
            txtKetqua.setText(result.toString());
        }else if (v.getId() == R.id.btnClose)
        {
            finish();
        }
    }
}