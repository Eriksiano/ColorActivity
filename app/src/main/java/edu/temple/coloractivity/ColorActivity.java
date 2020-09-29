package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // allows change of background color
        final View backgroundView = findViewById(R.id.color_activity_layout);

        Spinner spinner = findViewById(R.id.spinner);
        final String[] colors = {"Choose a color", "Red", "Yellow", "Blue", "Green", "Gray",
                "Magenta", "Black", "Cyan", "White"};

        // Using ColorAdapter class
        ColorAdapter adapter = new ColorAdapter(ColorActivity.this, colors);
        spinner.setAdapter(adapter);

        // creating listener for our spinner.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Except "Choose a color" option which is option 0, changing color for rest of the options.
                if(i!=0) {
                    // adapterView contains the text view of the spinner whose color we are changing.
                    TextView colorTextView = adapterView.findViewById(R.id.color_text_view);
                    colorTextView.setBackgroundColor(Color.WHITE);
                    // backgroundView color is changed by parsing the simple color strings in the below
                    backgroundView.setBackgroundColor(Color.parseColor(colors[i]));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // needed to be implemented
            }

        });
    }
}






