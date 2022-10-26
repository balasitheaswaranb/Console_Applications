package com.coures;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Courses {
	private int courseId;
	private String courseName;
	private ArrayList<String> courseLists;
	Scanner scanner = new Scanner(System.in);
	Database database = Database.getInstance();

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public ArrayList<String> getCourseLists() {
		return courseLists;
	}

	public void setCourseLists(ArrayList<String> courseLists) {
		this.courseLists = courseLists;
	}

	public void addCourse() {
		try {
			System.out.print("Enter course ID: ");
			int courseId = Integer.parseInt(scanner.nextLine());
			if (isInDatabase(courseId) == false) {
				System.out.print("Enter course Name: ");
				String courseName = scanner.nextLine();
				insertCourseIntoDB(courseId, courseName);
			} else {
				System.out.println("Course ID already exists!!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error! Please enter integer type value!!");
			System.out.println();
		}
	}

	private void insertCourseIntoDB(int courseId, String courseName) {
		String sql = "INSERT into course (course_id, course_name) values (" + courseId + ",'" + courseName + "')";
		if (database.insertIntoDatabase(sql))
			System.out.println("Course added successfully!!!");

	}

	public boolean isInDatabase(int courseId) {
		String sql = "select course_id,course_name from course where course_id = " + courseId;
		database.resultSet(sql);
		try {
			if (database.resultSet.next()) {
				this.courseId = database.resultSet.getInt(1);
				this.courseName = database.resultSet.getString(2);
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return false;
	}

	public void deleteCourse() {
		String sql = "select course_id, course_name from course";
		database.resultSet(sql);
		courseLists = new ArrayList<String>();
		try {
			while (database.resultSet.next()) {
				courseLists.add("Course ID: " + database.resultSet.getString(1) + " - " + "Course Name: "
						+ database.resultSet.getString(2));
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		Iterator<String> iterate = courseLists.iterator();
		while (iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		System.out.println("--------------------------------------");
		try {
			System.out.print("Enter the ID of course you want to delete: ");
			int id = Integer.parseInt(scanner.nextLine());
			if (isInDatabase(id) == true) {
				deleteCourseFromDB(id);
			} else {
				System.out.println("Course ID doesn't exist!!");
			}
		} catch (InputMismatchException ex) {
			System.out.println("Error!! Enter integer type value!!");
		}
	}

	private void deleteCourseFromDB(int courseId) {
		String sql = "delete from course where course_id=" + courseId;
		if (database.insertIntoDatabase(sql)) {
			System.out.println("Course deleted successfully!!");
		} else
			System.out.println("cant be deleted!!");
	}

	public void displayCourses() {
		String sql = "select course_id,course_name from course where status='True'";
		database.resultSet(sql);
		courseLists = new ArrayList<String>();
		try {
			while (database.resultSet.next()) {
				courseLists.add("Course ID: " + database.resultSet.getString(1) + " - Course Name: "
						+ database.resultSet.getString(2));
			}
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		System.out.println("--------------------------------------");
		Iterator<String> iterate = courseLists.iterator();
		while (iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		System.out.println("--------------------------------------");
	}

	public void displaySubjects(int courseId, int level) {
		String sql = "select subject_id,subject_name from subject where course_id=" + courseId + " and level=" + level;
		database.resultSet(sql);
		courseLists = new ArrayList<String>();
		try {
			while (database.resultSet.next()) {
				courseLists.add(database.resultSet.getString(1) + " - " + database.resultSet.getString(2));
			}
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		Iterator<String> iterate = courseLists.iterator();
		while (iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	}
}
