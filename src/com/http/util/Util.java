package com.http.util;

import com.sun.istack.internal.Nullable;

/**
 * Created by smart on 2017/8/3.
 */
public class Util {
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
