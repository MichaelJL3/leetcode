
package com.leetcode.util.parsers.string;

import com.leetcode.util.parsers.Parser;

public class CharParser extends Parser<Character, String> {

    @Override
    public Character parse(String val) {
        return val != null && val.length() > 0 ? val.charAt(0) : null;
    }

}
