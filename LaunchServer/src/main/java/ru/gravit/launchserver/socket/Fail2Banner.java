package ru.gravit.launchserver.socket;

import java.util.HashMap;
import java.util.HashSet;

public class Fail2Banner {
    public static final int MAX_FAILS = 3;
    public static HashSet<String> whitelist = new HashSet<>();
    public static class E
    {
        public E(int fails) {
            this.fails = fails;
        }

        int fails;
    }
    public static HashMap<String, E> map = new HashMap<>();
    public static boolean checkIP(String ip)
    {
        if(!map.containsKey(ip)) map.put(ip,new E(0));
        if(map.get(ip).fails > 3) return false;
        return true;
    }
    public static void fail2(String ip)
    {
        if(whitelist.contains(ip)) return;
        if(!map.containsKey(ip)) map.put(ip,new E(0));
        map.get(ip).fails++;
    }
    static {
        whitelist.add("127.0.0.1");
    }
}
