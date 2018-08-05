
package com.deepaksharma.webaddicted.fragmentbackhandler;

import android.support.v7.app.AppCompatActivity;

public class BackFragmentAppCompatActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        if(!onBackPressedWithResult()) {
            super.onBackPressed();
        }
    }

    /**
     * Enhanced version of {@link #onBackPressed()} with indication if back press was consumed.
     * It does not call default implementation of {@link #onBackPressed()}, you have to call it
     * your self in cases you want standard back behaviour.
     * @return true if back press was handled by some fragment
     */
    public boolean onBackPressedWithResult() {
        return BackFragmentHelper.fireOnBackPressedEvent(this);
    }
}
