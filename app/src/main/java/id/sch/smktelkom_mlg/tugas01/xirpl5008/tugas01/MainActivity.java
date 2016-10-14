package id.sch.smktelkom_mlg.tugas01.xirpl5008.tugas01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Spinner spkelas;
    RadioGroup rgjk;
    CheckBox cbbc, cbnnt, cbmsk;
    TextView tvhasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        spkelas = (Spinner) findViewById(R.id.spinnerkelas);
        rgjk = (RadioGroup) findViewById(R.id.radiogroupjk);
        cbbc = (CheckBox) findViewById(R.id.checkBoxbaca);
        cbmsk = (CheckBox) findViewById(R.id.checkBoxmsk);
        cbnnt = (CheckBox) findViewById(R.id.checkBoxnnt);
        tvhasil = (TextView) findViewById(R.id.textViewhasil);
        findViewById(R.id.buttonproses).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            StringBuilder builder = new StringBuilder();
            String hasil = null;
            if (rgjk.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgjk.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvhasil.setText("Anda belum mengisi jenis kelamin");
            } else {
                String hobi = "\t Hobi yang dipilih \t\n";
                int startlen = hobi.length();
                if (cbbc.isChecked()) hobi += "\t\t - " + cbbc.getText() + "\n";
                if (cbnnt.isChecked()) hobi += "\t\t - " + cbnnt.getText() + "\n";
                if (cbmsk.isChecked()) hobi += "\t\t - " + cbmsk.getText() + "\n";
                if (hobi.length() == startlen) {
                    tvhasil.setText("Anda belum memilih hobi");
                } else {
                    builder.append("Nama : " + nama + "\n");
                    builder.append("Kelas : ");
                    builder.append(spkelas.getSelectedItem().toString() + "\n");
                    builder.append("Jenis Kelamin : " + hasil + "\n");
                    builder.append(hobi + "\n");
                    tvhasil.setText(builder);
                }

            }

        }
    }


    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;

        } else {
            etNama.setError(null);
        }
        return valid;
    }
}
