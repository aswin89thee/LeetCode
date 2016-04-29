package org.leetcode;

import java.util.HashMap;
import java.util.Map;

//Time limit exceeded
public class LRUCache {
	int[] lruList;
	Map<Integer,Integer> keyMap;
	int capacity;
	int curCapacity;

	public LRUCache(int capacity) {
		lruList = new int[capacity];
		keyMap = new HashMap<Integer,Integer>();
		this.capacity = capacity;
		curCapacity = 0;
	}

	public int get(int key) {
		Integer val = keyMap.get(key);
		if(val == null) return -1;
		//Key is valid. Lets move it to the top of the list
		int i;
		if(capacity > 1){
			for(i = 0 ; i < lruList.length ; i++){
				if(lruList[i] == key) break;
			}
			for(int j = i; j > 0 ; j--){
				lruList[j] = lruList[j-1];
			}
		}
		lruList[0] = key;
		return val;
	}

	public void set(int key, int value) {
		boolean alreadyPresent = keyMap.containsKey(key);
		int i;
		keyMap.put(key, value);
		if(curCapacity < capacity){
			lruList[curCapacity] = key;
			curCapacity++;
			return;
		}
		if(!alreadyPresent){
			if(capacity > 1){
				keyMap.remove(lruList[lruList.length-1]);
				for(i = capacity-1 ; i > 0 ; i--){
					lruList[i] = lruList[i-1];
				}
			}
			lruList[0] = key;
		}else{
			//already present. Simply move it to the top of the queue
			if(capacity > 1){
				for(i = 0 ; i < lruList.length ; i++){
					if(lruList[i] == key) break;
				}
				for(int j = i; j > 0 ; j--){
					lruList[j] = lruList[j-1];
				}
			}
			lruList[0] = key;
		}
	}

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(3);
		obj.set(1,1);
		obj.set(2,2);
		obj.set(3,3);
		obj.set(4,4);
		obj.get(4);
		obj.get(3);
		obj.get(2);
		obj.get(1);
		obj.set(5,5);
		obj.get(1);
		obj.get(2);
		obj.get(3);
		obj.get(4);
		obj.get(5);
		
	}

}
