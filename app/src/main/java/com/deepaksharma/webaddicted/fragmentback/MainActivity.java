
package com.deepaksharma.webaddicted.fragmentback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.deepaksharma.webaddicted.fragmentbackhandler.BackFragmentAppCompatActivity;


public class MainActivity extends BackFragmentAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.standard_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StandardActivity.class));
            }
        });

        findViewById(R.id.viewpager_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
            }
        });

        findViewById(R.id.nested_fragments_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NestedFragementsActivity.class));
            }
        });
    }

}
