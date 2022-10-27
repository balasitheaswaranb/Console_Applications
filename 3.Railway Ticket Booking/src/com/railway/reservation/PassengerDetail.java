package com.railway.reservation;

import java.util.Scanner;

public class PassengerDetail {
	Scanner scanner = new Scanner(System.in);
	Passenger passenger = new Passenger();
	static int i = 1;

	public Passenger passengerDetailCollecting() {

		String name, childName;
		int age, childAge;
		Passenger.Gender gender = null, childGender = null;
		Passenger.Berth berthPreference = null;
		System.out.print("Enter passenger's Name                                    : ");
		name = scanner.next();
		passenger.setName(name);
		System.out.print("Enter passenger's Age                                     : ");
		age = scanner.nextInt();
		if (age > 5) {
			passenger.setAge(age);
		} else {
			System.out.println("Age must be greater than 5 for Passenger.");
			return null;
		}
		System.out.print("Enter passenger's Gender as [F or M or O]                 : ");
		String g = scanner.next();
		if (g.equalsIgnoreCase("F") || g.equalsIgnoreCase("M")) {
			if (g.equalsIgnoreCase("F")) {
				gender = Passenger.Gender.FEMALE;
			} else if (g.equalsIgnoreCase("M")) {
				gender = Passenger.Gender.MALE;
			}
			passenger.setGender(gender);
			System.out.println("\tYou travel with your child under 5 or equal old ?");
			System.out.println("\t1. Yes.");
			System.out.println("\t2. No.");
			System.out.println("\t-------------------------------------------------\n");
			System.out.print("\tEnter your choice : ");
			int gChoice = scanner.nextInt();
			if (gChoice == 1) {
				System.out.print("\tEnter your child's Age                : ");
				childAge = scanner.nextInt();
				if (childAge > 0) {
					if (childAge <= 5) {
						System.out.print("\tEnter your child's Name               : ");
						childName = scanner.next();
						System.out.print("\tEnter your child's Gender as [F or M] : ");
						g = scanner.next();
						if (g.equalsIgnoreCase("F")) {
							childGender = Passenger.Gender.FEMALE;
						} else if (g.equalsIgnoreCase("M")) {
							childGender = Passenger.Gender.MALE;
						} else {
							System.out.println("Child gender must be in above mentioned characters.");
							return null;
						}
						passenger.setChildName(childName);
						passenger.setChildAge(childAge);
						passenger.setChildGender(childGender);
						System.out.print("Enter passenger's Berth Preference as [U or M or L or SU] : ");
						String bp = scanner.next();
						if (bp.equalsIgnoreCase("U")) {
							berthPreference = Passenger.Berth.UPPER_BERTH;
						} else if (bp.equalsIgnoreCase("M")) {
							berthPreference = Passenger.Berth.MIDDLE_BERTH;
						} else if (bp.equalsIgnoreCase("L")) {
							berthPreference = Passenger.Berth.LOWER_BERTH;
						} else if (bp.equalsIgnoreCase("SU")) {
							berthPreference = Passenger.Berth.SIDE_UPPER_BERTH;
						} else {
							System.out.println("Berth Preference must be in above mentioned character.");
							return null;
						}
						passenger.pnrNumber = i++;
						passenger.setBerthPreference(berthPreference);
						return passenger;
					} else {
						System.out.println("You Book a Separate Ticket for your Child.");
					}
				} else {
					System.out.println("Age must be greater then 0 and less then or equalt 5 for Child.");
					return null;
				}
			} else if (gChoice == 2) {
				childName = null;
				childAge = 0;
				childGender = null;
				System.out.print("Enter passenger's Berth Preference as [U or M or L or SU] : ");
				String bp = scanner.next();
				if (bp.equalsIgnoreCase("U")) {
					berthPreference = Passenger.Berth.UPPER_BERTH;
				} else if (bp.equalsIgnoreCase("M")) {
					berthPreference = Passenger.Berth.MIDDLE_BERTH;
				} else if (bp.equalsIgnoreCase("L")) {
					berthPreference = Passenger.Berth.LOWER_BERTH;
				} else if (bp.equalsIgnoreCase("SU")) {
					berthPreference = Passenger.Berth.SIDE_UPPER_BERTH;
				} else {
					System.out.println("Berth Preference must be in above mentioned character.");
					return null;
				}
				passenger.pnrNumber = i++;
				passenger.setChildName(childName);
				passenger.setChildAge(childAge);
				passenger.setChildGender(childGender);
				passenger.setBerthPreference(berthPreference);
				return passenger;
			} else {
				System.out.println("Please select the above options only.");
				return null;
			}
		} else if (g.equalsIgnoreCase("O")) {
			gender = Passenger.Gender.OTHERS;
			childName = null;
			childAge = 0;
			childGender = null;
			System.out.print("Enter passenger's Berth Preference as [U or M or L or SU] : ");
			String bp = scanner.next();
			if (bp.equalsIgnoreCase("U")) {
				berthPreference = Passenger.Berth.UPPER_BERTH;
			} else if (bp.equalsIgnoreCase("M")) {
				berthPreference = Passenger.Berth.MIDDLE_BERTH;
			} else if (bp.equalsIgnoreCase("L")) {
				berthPreference = Passenger.Berth.LOWER_BERTH;
			} else if (bp.equalsIgnoreCase("SU")) {
				berthPreference = Passenger.Berth.SIDE_UPPER_BERTH;
			} else {
				System.out.println("Berth Preference must be in above mentioned character.");
				return null;
			}
			passenger.pnrNumber = i++;
			passenger.setGender(childGender);
			passenger.setChildName(childName);
			passenger.setChildAge(childAge);
			passenger.setChildGender(childGender);
			passenger.setBerthPreference(berthPreference);
			return passenger;
		} else {
			System.out.println("Passenger's gender must be in above mentioned charcters.");
			return null;
		}
		return null;
	}
}