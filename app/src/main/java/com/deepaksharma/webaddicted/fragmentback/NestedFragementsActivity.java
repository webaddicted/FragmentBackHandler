
package com.deepaksharma.webaddicted.fragmentback;

import android.os.Bundle;

import com.deepaksharma.webaddicted.fragmentbackhandler.BackFragmentAppCompatActivity;



public class NestedFragementsActivity extends BackFragmentAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nested_fragments);
    }
}
