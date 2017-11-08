package dk.mechagk.pythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public class CalculateListener implements View.OnClickListener {
        private EditText editTextA;
        private EditText editTextB;
        private TextView textView;

        public TextView getTextView() {
            return textView;
        }

        public CalculateListener(EditText editTextA, EditText editTextB, TextView textView) {
            this.editTextA = editTextA;
            this.editTextB = editTextB;
            this.textView = textView;
        }

        @Override
        public void onClick(View v) {
            int a = Integer.parseInt(editTextA.getText().toString());
            int b = Integer.parseInt(editTextB.getText().toString());

            double c = Math.pow(a, 2) + Math.pow(b, 2);

            c = Math.sqrt(c);
            textView.setText(String.valueOf(c));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textFieldA = findViewById(R.id.entryA);
        final EditText entryB = findViewById(R.id.entryB);

        final TextView textView = findViewById(R.id.textView);

        final Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.callOnClick();


        calculateButton.setOnClickListener((View v) -> {
            try {
                int a = Integer.parseInt(textFieldA.getText().toString());
                int b = Integer.parseInt(entryB.getText().toString());

                double c = Math.pow(a, 2) + Math.pow(b, 2);

                c = Math.sqrt(c);
                textView.setText(String.valueOf(c));
            }
            catch (NumberFormatException e) {
                textView.setText("Invalid numbers");
            }
        });
    }
}
