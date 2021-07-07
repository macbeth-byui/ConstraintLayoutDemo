package t.macbeth.constraintlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewTreeObserver;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The measured height of the EditText fields is not known immediately.  The Global
        // Layout Listener will notify us when the layout is done and then we can access
        // the measured height.
        ConstraintLayout layout = findViewById(R.id.layout);
        layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                EditText firstName = findViewById(R.id.editTextTextPersonName2);
                EditText lastName = findViewById(R.id.editTextTextPersonName3);

                // MeasuredHeight is in pixels but note that the EditText has padding around
                // the editable space.  Therefore, reduce by 75%
                firstName.setTextSize(TypedValue.COMPLEX_UNIT_PX, Math.round(firstName.getMeasuredHeight()*0.75));
                lastName.setTextSize(TypedValue.COMPLEX_UNIT_PX, Math.round(lastName.getMeasuredHeight()*0.75));

                // Only want to do this once so remove the listener
                layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


    }


}