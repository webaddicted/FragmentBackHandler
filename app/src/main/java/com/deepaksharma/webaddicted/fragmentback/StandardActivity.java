
package com.deepaksharma.webaddicted.fragmentback;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.deepaksharma.webaddicted.fragmentbackhandler.BackFragmentAppCompatActivity;

public class StandardActivity extends BackFragmentAppCompatActivity {

    private TextView activityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.second_fragment_container, SecondFragment.newInstance())
                    .commit();
        }

        activityTextView = (TextView) findViewById(R.id.activity_text_view);
    }

    @Override
    public void onBackPressed() {

        // you can override this method to handle back here in certain conditions
        if(TextUtils.isEmpty(activityTextView.getText())) {
            // handle first back button in activity
            activityTextView.setText(R.string.activity_first_back_handled);
        } else if(!onBackPressedWithResult()) { // ask fragments to handle back
            // if fragments no longer care about back, handle it here
            if(TextUtils.equals(activityTextView.getText(),
                    getString(R.string.activity_first_back_handled))) {
                // handle the last back before quiting activity here
                activityTextView.setText(R.string.activity_last_back_handled);
                activityTextView.setTextColor(Color.RED);
                activityTextView.setTypeface(null, Typeface.BOLD);
            } else {
                // fall back to default back behaviour
                super.onBackPressed();
            }
        } else {
            // back was handled by some fragment
        }
    }
}
