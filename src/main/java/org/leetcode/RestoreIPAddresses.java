package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	
	public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        if(s.equals("") || s == null) return list;
        if(s.length() > 12) return list;
        try{
        	Long.parseLong(s);
        }catch(NumberFormatException e){
        	return list;
        }
        generateIPs(s,4,"",list);
        return list;
    }

	private void generateIPs(String s, int bytesLeft, String prefix, List<String> list) {
		if(bytesLeft == 1){
			//Validate the last byte
			if(s.length() > 3) return;
			if(s.equals("")) return;
			int lastByte = Integer.parseInt(s);
			if(lastByte > 255) return;
			if(s.length() > 2 && lastByte < 100) return;
			if(s.length() > 1 && lastByte < 10) return;
			prefix = prefix + lastByte;
			list.add(prefix);
			return;
		}
		//Bactrack whenever possible
		if(s.length() > bytesLeft*3) return;
		if(s.length() < bytesLeft) return;
		String byte1 = "";
		for(int i = 0 ; i < 3 ; i++){
			byte1 = i < s.length() ? s.substring(0,i+1) : s;
			int byteVal = Integer.parseInt(byte1);
			if(byteVal > 255) continue;
			if(byte1.length() > 1 && byteVal < 10) continue;
			if(byte1.length() > 2 && byteVal < 100) continue;
			String rest = "";
			rest = i < s.length() ? s.substring(i+1) : "";
			String newPrefix = prefix + byte1 + ".";
			generateIPs(rest,bytesLeft-1,newPrefix,list);
		}
	}

	public static void main(String[] args) {
		RestoreIPAddresses obj = new RestoreIPAddresses();
		String ip = "010010";
		List<String> list = obj.restoreIpAddresses(ip);
		for(String str : list){
			System.out.println(str);
		}
	}

}
