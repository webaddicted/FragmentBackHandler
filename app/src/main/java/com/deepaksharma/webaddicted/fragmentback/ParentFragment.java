
package com.deepaksharma.webaddicted.fragmentback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepaksharma.webaddicted.fragmentbackhandler.BackFragment;

/**
 * Simple fragment with low priority for back button event.
 */
public class ParentFragment extends Fragment implements BackFragment {

    public ParentFragment() {
        // Required empty public constructor
    }

    public static ParentFragment newInstance() {
        ParentFragment fragment = new ParentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent, container, false);

        if(savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .add(R.id.top_fragment, FirstFragment.newInstance())
                    .add(R.id.bottom_fragment, SecondFragment.newInstance())
                    .commit();
        }

        return view;
    }

    @Override
    public boolean onBackPressed() {
        return false; // we do not consume the event here
    }

    @Override
    public int getBackPriority() {
        return LOW_BACK_PRIORITY;
    }
}
