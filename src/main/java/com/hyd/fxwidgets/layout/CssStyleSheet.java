package com.hyd.fxwidgets.layout;

import com.hyd.fxwidgets.base.Value;
import java.util.Arrays;
import java.util.List;

public class CssStyleSheet extends Value<List<String>> {

    public CssStyleSheet(String... strings) {
        this(Arrays.asList(strings));
    }

    public CssStyleSheet(List<String> strings) {
        super(strings);
    }
}
