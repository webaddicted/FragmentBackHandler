package com.deepaksharma.webaddicted.fragmentbackhandler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Deepak Sharma
 */
public class BackFragmentHelper {

    private BackFragmentHelper() {
        // empty private constructor to avoid instantiation
    }

    /**
     * Fire {@link BackFragment#onBackPressed()} event on all {@link BackFragment} fragments in
     * given {@link FragmentActivity}.
     * @param gActivity activity to be scanned for {@link BackFragment} instances
     * @return true if back was handled by some fragment
     */
    public static boolean fireOnBackPressedEvent(FragmentActivity gActivity) {
        List<Fragment> fragmentList = getAllActivityFragments(gActivity);
        return fireOnBackPressedEvent(fragmentList);
    }

    private static List<Fragment> getAllActivityFragments(FragmentActivity gActivity) {
        List<Fragment> fragmentList = gActivity.getSupportFragmentManager().getFragments();

        if(fragmentList != null && fragmentList.size() > 0) {
            List<Fragment> result = new ArrayList<>(fragmentList.size());

            for (Fragment f : fragmentList) {
                if(f != null) {
                    result.add(f);

                    List<Fragment> nestedFragmentList = f.getChildFragmentManager().getFragments();
                    if (nestedFragmentList != null && nestedFragmentList.size() > 0) {
                        result.addAll(nestedFragmentList);
                    }
                }
            }

            return result;
        } else {
            return new ArrayList<>(0);
        }
    }

    private static boolean fireOnBackPressedEvent(List<?> gFragmentList) {

        // find all fragments with back support
        List<BackFragment> backFragmentList = new ArrayList<>(gFragmentList.size());
        for(Object f : gFragmentList) {
            if(f instanceof BackFragment) {
                backFragmentList.add((BackFragment)f);
            }
        }

        // sort fragments by back priority
        Collections.sort(backFragmentList, new Comparator<BackFragment>() {
            @Override
            public int compare(BackFragment lhs, BackFragment rhs) {
                return rhs.getBackPriority() - lhs.getBackPriority();
            }
        });

        // send them onBackPressed event
        boolean handled = false;
        for (BackFragment f: backFragmentList) {
            handled = f.onBackPressed();

            if(handled) {
                break;
            }
        }

        return handled;
    }
}
