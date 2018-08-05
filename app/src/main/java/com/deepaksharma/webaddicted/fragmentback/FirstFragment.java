
package com.deepaksharma.webaddicted.fragmentback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deepaksharma.webaddicted.fragmentbackhandler.BackFragment;



/**
 * Simple fragment with low priority for back button event.
 */
public class FirstFragment extends Fragment implements BackFragment {

    TextView myTextView;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        myTextView = (TextView)view.findViewById(R.id.my_text_view);
        ((TextView)view.findViewById(R.id.header_text_view)).setText(R.string.first_fragment);
        return view;
    }

    @Override
    public boolean onBackPressed() {

        // here should be your own logic
        if(TextUtils.isEmpty(myTextView.getText())) {
            myTextView.setText(getString(R.string.back_handled));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getBackPriority() {
        return LOW_BACK_PRIORITY;
    }
}
