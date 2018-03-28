
package com.leetcode.util.parsers.string;

import com.leetcode.util.parsers.Parser;

public class IntParser extends Parser<Integer, String> {

    @Override
    public Integer parse(String val) {
        return Integer.parseInt(val);
    }

}