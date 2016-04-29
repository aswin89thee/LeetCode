package org.leetcode;


public class RemoveDuplicatesFromSortedArrayII {
	
	public int removeDuplicates(int[] A) {
		if(A.length <= 2 ) return A.length;
		int pos = 0;
		int curCount = 1;
		int i = 0;
		for(i = 1 ; i < A.length ; i++){
			if(A[i] == A[pos]){
				if(curCount < 2){
					curCount++;
					A[++pos] = A[i];
					continue;
				}
				else continue;
			}else{
				if(pos < A.length)
					A[++pos] = A[i];
				curCount = 1;
			}
		}
		if(curCount == 2 && i == A.length){
			A[pos] = A[i-1];
		}
		
		return pos+1;
	}

//	public int removeDuplicates(int[] A) {
//		int totalCount = 1;
//		if(A.length == 0 || A.length == 1) return A.length;
//		int curElement = A[0];
//		int curCount = 1;
//		Map<Integer,Integer> elemMap = new HashMap<Integer,Integer>();
//		elemMap.put(A[0], 1);
//		for(int i = 1 ; i < A.length ; i++){
//			if(A[i] == curElement){
//				if(curCount < 2){
//					curCount++;
//					totalCount++;
//					elemMap.put(A[i], curCount);
//				}
//			}else{
//				curElement = A[i];
//				curCount = 1;
//				totalCount++;
//				elemMap.put(A[i], curCount);
//			}
//		}
//		Set<Integer> keySet = elemMap.keySet();
//		List<Integer> keyList = new ArrayList<Integer>(keySet);
//		Collections.sort(keyList);
//		int j = 0;
//		for(Integer i : keyList){
//			curCount = elemMap.get(i);
//			while(curCount > 0){
//				A[j] = i;
//				j++;
//				curCount--;
//			}
//		}
//		
//		return totalCount;
//	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
		int[] A = {1,1,1,1,2,2,3};
		System.out.println(obj.removeDuplicates(A));
	}

}
