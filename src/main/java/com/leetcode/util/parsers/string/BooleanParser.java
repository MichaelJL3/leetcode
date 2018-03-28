
package com.leetcode.util.parsers.string;

import com.leetcode.util.parsers.Parser;

public class BooleanParser extends Parser<Boolean, String> {

    @Override
    public Boolean parse(String val) {
        return Boolean.parseBoolean(val);
    }

}