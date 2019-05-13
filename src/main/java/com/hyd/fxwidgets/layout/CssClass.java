package com.hyd.fxwidgets.layout;

import com.hyd.fxwidgets.base.Value;
import java.util.Arrays;
import java.util.List;

public class CssClass extends Value<List<String>> {

    public CssClass(String... values) {
        this(Arrays.asList(values));
    }

    public CssClass(List<String> strings) {
        super(strings);
    }
}
