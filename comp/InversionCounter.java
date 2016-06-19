/* InversionCounter.java */
package comp;

import java.io.*;
import java.util.*;

public class InversionCounter{

	public static long count(Comparable [] items){
		Comparable[] temp = new Comparable[items.length];
		return count(items, temp, 0, items.length-1);
	}

	private static long count(Comparable [] items, Comparable [] temp, int start, int end){
		if (start < end){
			int mid = (start + end)/2;
			long right = count(items, temp, start, mid);
			long left = count(items, temp, mid+1, end);
			long split = mergeCount(items, temp, start, mid+1, end);
			return right + left + split;
		}
		return 0;


	}

	private static long mergeCount(Comparable[] items, Comparable[] temp, int firstPos, int secondPos, int secondEnd){
		int firstEnd = secondPos -1;
		int curr = firstPos;
		int numItems = secondEnd - firstPos + 1;
		int firstLength = secondPos - firstPos;
		long numInversion = 0;
		while(firstPos <= firstEnd && secondPos <= secondEnd){ 
			if (items[firstPos].compareTo(items[secondPos]) <= 0){
				temp[curr] = items[firstPos];
				firstPos++;
			} else{
				temp[curr] = items[secondPos];
				numInversion += firstEnd - firstPos + 1;
				secondPos++;

			}
			curr++;
		}
		while(firstPos <= firstEnd){
			temp[curr] = items[firstPos];
			firstPos++;
			curr++;
		}
		while(secondPos <= secondEnd){
			temp[curr] = items[secondPos];
			curr++;
			secondPos++;
		}
		for (int i = 0; i < numItems; i++){
			items[secondEnd] = temp[secondEnd];
			secondEnd--;
		}
		return numInversion;
	}

	public static void printArray(Comparable[] arr){
		String str = new String();
		for (Comparable c : arr){
			str += c + " ";
		}
		System.out.println(str);
	}

	public static void main(String [] args){
		if (args.length > 0){
			String path = args[0];
			ArrayList<Integer> list = new ArrayList<Integer>();
			try{
				BufferedReader br = new BufferedReader(new FileReader(path));
				String line;
				while((line = br.readLine()) != null){
					list.add(Integer.parseInt(line));
				}
				Integer [] arr = (Integer[])list.toArray(new Integer[list.size()]);
				System.out.println( "Number of inversions: " + count(arr));
			} catch(Exception e){
				e.printStackTrace();
			}
		} else{
			//Integer [] list = {4, 3, 2, 1, 0};
			//Integer [] list = {1,3,5,2,4,6};
			Integer [] list = {1, 0};
			System.out.println(count(list));
		}
	}
}
