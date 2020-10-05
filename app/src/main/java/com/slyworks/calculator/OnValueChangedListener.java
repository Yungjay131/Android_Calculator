package com.slyworks.calculator;

import android.support.annotation.Nullable;

/**
 * Created by Joshua Sylvanus, 6:18 AM, 10/2/2020.
 */
public interface OnValueChangedListener {
    void onChanged( Integer operation,@Nullable String value);
}
