
package com.leetcode.util.parsers.string;

import com.leetcode.util.parsers.Parser;

public class FloatParser extends Parser<Float, String> {

    @Override
    public Float parse(String val) {
        return Float.parseFloat(val);
    }

}
