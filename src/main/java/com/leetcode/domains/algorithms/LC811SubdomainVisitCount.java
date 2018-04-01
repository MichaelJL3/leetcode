
package com.leetcode.domains.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LC811SubdomainVisitCount {

    public static void main(String[] args) {
        System.out.println(new Solution().subdomainVisits(args));
    }

    static class Solution {

        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> domainMap = new HashMap<String,Integer>();
            List<String> domainCount = new ArrayList<String>();
            String[] domains;
            String[] tuple;
            String subdomain;
            Integer existing;
            int count;

            for (String request : cpdomains) {
                tuple = request.split(" ");
                count = Integer.parseInt(tuple[0]);
                domains = tuple[1].split("\\.");
                subdomain = null;

                for (int i = domains.length - 1; i >= 0; --i) {
                    subdomain = (subdomain == null) ? domains[i] : domains[i] + "." + subdomain;
                    existing = domainMap.get(subdomain);
                    domainMap.put(subdomain, count + (existing != null ? existing : 0));
                }
            }

            for (Entry<String, Integer> entry : domainMap.entrySet()) {
                domainCount.add(String.format("%d %s", entry.getValue(), entry.getKey()));
            }

            return domainCount;
        }

    }

}