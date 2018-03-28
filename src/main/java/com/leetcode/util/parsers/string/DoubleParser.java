
package com.leetcode.util.parsers.string;

import com.leetcode.util.parsers.Parser;

public class DoubleParser extends Parser<Double, String> {

    @Override
    public Double parse(String val) {
        return Double.parseDouble(val);
    }

}
