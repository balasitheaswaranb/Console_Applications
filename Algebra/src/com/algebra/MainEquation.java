package com.algebra;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MainEquation {

	public static void main(String[] args) {
		HashMap<String, Integer> Expression = new HashMap<String, Integer>();
		String term1 = "";
		String term2 = "";
		Scanner sc = new Scanner(System.in);
		AlgebricEquation Algebra = new AlgebricEquation();
		System.out.println("Enter the expression");
		String Exp = sc.nextLine();
		Algebra.findSign(Exp);
		String[] arr = new String[1];
		if (Algebra.multiply) {
			arr = Exp.split("[*]");
		}
		if (Algebra.subract || Algebra.add) {
			Character previousCh = '0';
			for (char ch1 : Exp.toCharArray()) {
				if (Algebra.numCheck(ch1) || Algebra.albhabetCheck(ch1) || ch1 == 94) {
					term1 += "" + ch1;

				} else{
					if (previousCh == ')' && ch1 == 45) {
						Algebra.subract = true;
						continue;
					}
					if (term1.length() > 0) {
						Algebra.ExpressionSplit(term1.toCharArray());
						if (Expression.containsKey(Algebra.variable)) {
							int val = Expression.get(Algebra.variable);
							Expression.replace(Algebra.variable, val + Algebra.power);
						} else {
							Expression.put(Algebra.variable, Algebra.power);
						}
						term1 = "";
						if (ch1 == 45) {
							term1 += "" + ch1;
							
						}
						Algebra.power = 1;
						Algebra.variable = "";
						Algebra.powerTemp = 1;
						Algebra.temp = "";
					}
				}
				previousCh = ch1;
			}
		} else{
			for (char ch1 : arr[0].toCharArray()) {
				if (Algebra.numCheck(ch1) || Algebra.albhabetCheck(ch1) || ch1 == 94) {
					term1 += "" + ch1;
				} else {
					if (term1.length() > 0) {
						Algebra.ExpressionSplit(term1.toCharArray());
						Algebra.setTemp(Algebra.power, Algebra.variable);
						for (char ch2 : arr[1].toCharArray()) {
							if (Algebra.numCheck(ch2) || Algebra.albhabetCheck(ch2) || ch2 == 94) {
								term2 += "" + ch2;
							} else {
								if (term2.length() > 0) {
									Algebra.ExpressionSplit(term2.toCharArray());
									Algebra.multiply();
									if (Expression.containsKey(Algebra.variable)) {
										int val = Expression.get(Algebra.variable);
										Expression.replace(Algebra.variable, val + Algebra.power);
									} else {
										Expression.put(Algebra.variable, Algebra.power);
									}
									term2 = "";
									if (ch2 == 45) {
										term2 += "" + ch2;
									}
									Algebra.useTemp(Algebra.powerTemp, Algebra.temp);
								}
							}
						}
						term1 = "";
						if (ch1 == 45) {
							term1 += "" + ch1;
						}
						Algebra.power = 1;
						Algebra.variable = "";
						Algebra.powerTemp = 1;
						Algebra.temp = "";
					}
				}
			}
		}
		Set<String> keys = Expression.keySet();
		for (String str : keys) {
			int val = Expression.get(str);
			if (val != 0) {
				if (val < 0) {
					System.out.print(val + str);
				} else {
					System.out.print("+" + val + str);
				}
			}
		}
		System.out.println();
		sc.close();
	}
	/*Input: (2x+y)*(3x-5y)
	Output: 6x^2-7xy-5y^2

	Input: (2xy+4x^2y)*(2x^2y+6xy)
	Output: 28x^3y^2+8x^4y^2+12x^2y^2

	Input: (2x^2y+3xy^2z-xz^3)*(5xyz+3y^2z-2z)
	Output: 10x3y2z+6x2y3z-4x2yz+15x2y3z2+9xy4z2-6xy2z2-5x2yz4-3xy2z4+2xz4*/
}
                