package com.revature.practice;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class HumanReadableTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeReadable(33980));
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(0);
		list.add(4);
		list.add(3);
		list.add(3);
		list.add(1);
		
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		//System.out.println(sumConsecutives(list));
	}
	
	public static String makeReadable(int seconds) {
		int timeHours = seconds / 3600;
	    int timeMinutes = (seconds % 3600) / 60;
	    int timeSeconds = seconds % 60;
	    String timeString = String.format("%02d:%02d:%02d", timeHours, timeMinutes, timeSeconds);
	    
	    return timeString;
	  }
	
	public static List<Integer> sumConsecutives(List<Integer> s) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Iterator<Integer> iter = s.iterator();
        
        int value, key, total = 0;
        
        while(iter.hasNext()) {
          key = iter.next();
          if(!map.containsKey(key)) {
            map.put(key, key);
          } else {
            value = map.get(key);
            total = value*2;
            map.put(key, total);
          }
        }
        
        Set<Integer> keys = map.keySet();
        for(Integer i : keys) {
          list.add(map.get(i));
        }
        
        
        return list;
    }

}
