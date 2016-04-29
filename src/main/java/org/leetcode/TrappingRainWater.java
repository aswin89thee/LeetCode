package org.leetcode;

public class TrappingRainWater {
	
	//Wrong Solution
	public int trap(int[] height) {
		int[] differences = new int[height.length];
		int vol = 0;
		if(height.length == 0 || height.length == 1 || height.length == 2) return vol;
		int i = 0;
		for(i = 0 ; i < height.length ; i++){
			if(i==0){ differences[i] = 0; continue;}
			differences[i] = height[i] - height[i-1];
		}
		int begin = -1, end = -1;
		boolean lookingForBegin = true;
		boolean lookingForEnd = false;
		for(i = 0 ; i < height.length ; i++){
			if(differences[i] < 0){
				if(lookingForBegin){
					begin = i-1;
					lookingForBegin = false;
					continue;
				}else if(i==height.length - 1){
					if(lookingForEnd){
						end = i - 1;
						vol += calculateVol(height,begin,end);
					}
					break;
				}else if(lookingForEnd){
					end = i-1;
					vol += calculateVol(height,begin,end);
					begin = i-1; 
					lookingForEnd = false;
				}
				else{
					continue;
				}
			}else if(differences[i] >= 0){
				//If it is the last height, calculate the trapped vol in the last trough
				if(i == height.length - 1){
					if(!lookingForBegin){
						end = i;
						vol += calculateVol(height,begin,end);
						lookingForBegin = true; lookingForEnd = false;
					}
					if(!lookingForEnd){
						lookingForEnd = true;
					}
				}
				else{
					if(!lookingForBegin)
						lookingForEnd = true;
				}
			}
		}
		
		return vol;
	}

	private int calculateVol(int[] height, int begin, int end) {
		int smallest = height[begin] < height[end] ? height[begin] : height[end];
		int trapped = 0;
		for(int i = begin+1 ; i < end ; i++){
			if(height[i] <= smallest)
				trapped += Math.abs((smallest - height[i]));
		}
		return trapped;
	}

	public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		int vol = obj.trap(heights);
		System.out.println(vol);
	}

}
