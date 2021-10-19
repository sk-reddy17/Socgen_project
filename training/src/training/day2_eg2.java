package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class day2_eg2 {
	static ArrayList<Double> fun(ArrayList<Integer> list)
	{
		ArrayList<Double> sqrtList = new ArrayList<>();
		for(int i:list) {
			sqrtList.add(Math.sqrt(i));
		}
		ArrayList<Double> Perfect = new ArrayList<>();
		ArrayList<Double> Imperfect = new ArrayList<>();
		for(double i:sqrtList) {
			if(i == (int) i) {
				Perfect.add(i);
			}
			else {
				Imperfect.add(i);
			}
		}
		for(int i=0;i<Imperfect.size();i++) {
			Imperfect.set(i, (Math.floor(Imperfect.get(i)*10))/10);
		}
		
		Collections.sort(Perfect,Collections.reverseOrder());
		Collections.sort(Imperfect,Collections.reverseOrder());
		Perfect.addAll(Imperfect);
		
		return Perfect;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 34, 45, 9, 90,16, 3));
		System.out.println(fun(list));

		
		
	}

}
