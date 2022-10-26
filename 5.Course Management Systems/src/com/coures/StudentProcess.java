package com.coures;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class StudentProcess {
	Scanner scanner = new Scanner(System.in);
	Database database = Database.getInstance();
	private String studentName;
	private int studentId;

	public String getStudentName() {
		return studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public boolean isInDatabase(int studentId) {
		String sql = "select student_id,student_name from student where student_id =" + studentId;
		database.resultSet(sql);
		try {
			if (database.resultSet.next()) {
				this.studentId= database.resultSet.getInt(1);
	            this.studentName = database.resultSet.getString(2);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void enrollCourse() {
		System.out.println("************************************" + "\n      Student Registration         "
				+ "\n************************************");
		try {
			System.out.print("Enter student ID: ");
			int studentId = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter your name: ");
			String studentName = scanner.nextLine();
			if (isInDatabase(studentId) == true) {
				System.out.println("Student ID already exists!");
				return;
			}
			Courses course = new Courses();
			System.out.println("Available Courses");
			course.displayCourses();
			System.out.print("Enter the course ID you want to enroll: ");
			int courseId = Integer.parseInt(scanner.nextLine());

			if (course.isInDatabase(courseId) == true) {
				Subjects subjects = new Subjects();
				if (subjects.checkSubjectsInDatabase(courseId) == true) {
					System.out.print("Enter the level you want to enroll: ");
					int level = Integer.parseInt(scanner.nextLine());
					if (level == 1 || level == 2 || level == 3) {
						if (level == 3) {
							String sql2 = "select subject_id,subject_name from subject where course_id=" + courseId
									+ " and level=" + level;

							database.resultSet(sql2);
							ArrayList<String> levelThree = new ArrayList<>();
							try {
								while (database.resultSet.next()) {
									levelThree.add("Subject ID: " + database.resultSet.getString(1)
											+ " - Subject Name: " + database.resultSet.getString(2));
								}
								System.out.println("Available Options for Level 3");
								System.out.println("--------------------------------");
								Iterator<String> iterate = levelThree.iterator();
								while (iterate.hasNext()) {
									System.out.println(iterate.next());
								}
								System.out.println("----------------------------------");

								System.out.println();
								System.out.print("Enter ID of your first choice subject: ");
								int choice1 = Integer.parseInt(scanner.nextLine());
								Subjects subject = new Subjects();
								try {

									if (subject.isInDatabase(choice1) == true) {

										System.out.print("Enter ID of your second choice subject: ");
										int choice2 = Integer.parseInt(scanner.nextLine());
										if (subject.isInDatabase(choice2) == true) {
											int[] choices = { choice1, choice2 };
											for (int i = 0; i < 2; i++) {
												String sql3 = "INSERT into student (student_id,student_name,subject_id) values ("
														+ studentId + ",'" + studentName + "'," + choices[i] + ")";
												database.insertIntoDatabase(sql3);
											}
											System.out
													.println("Congratulations!! You have been successfully enrolled!!");

										} else {
											System.out.println("Subject ID doesn't exist!!");
										}
									} else {
										System.out.println("Subject ID doesn't exist!!");
									}
								} catch (NumberFormatException ex) {
									System.out.println("Error! Enter integer type value!!");
								}
							} catch (SQLException e) {
								System.out.println("Error: " + e.getMessage());
							}
						}

						if (level == 1 || level == 2) {
							String sql = "select subject_id  from subject where course_id= " + courseId + " and level="
									+ level;
							database.resultSet(sql);
							try {
								while (database.resultSet.next()) {
									String sql1 = "INSERT into student (student_id,student_name,subject_id) values ("
											+ studentId + ",'" + studentName + "',"
											+ Integer.parseInt(database.resultSet.getString(1)) + ")";
									database.insertIntoDatabase(sql1);
								}
								System.out.println("Congratulations!! You have been successfully enrolled!!");
							} catch (SQLException e) {
								System.out.println();
								System.out.println("Error: " + e.getMessage());
							}
						}
					} else { 
						System.out.println("Level must be 1,2 or 3!!");
					}
				} else {
					System.out.println("Sorry! There is no subjects in that course!");
				}
			} else {
				System.out.println("Course ID doesn't exist!!");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error! Please enter integer type value!!");
		} catch (InputMismatchException ex) {
			System.out.println("Error! Enter integer type value!!");
		}
	}

	public void displayStudents(int id) {
		String sqlQuery = "select subject_id from staff where staff_id=" + id;
		database.resultSet(sqlQuery);
		ArrayList<String> students = new ArrayList<String>();
		try {
			while (database.resultSet.next()) {
				try {
					String sql1 = "select student_id, student_name,subject_id from student where subject_id ="
							+ database.resultSet.getString(1);
					database.resultSet(sql1);
					if (database.resultSet.next()) {
						students.add("Student ID: " + database.resultSet.getString(1) + " - " + "Student Name: "
								+ database.resultSet.getString(2) + " - " + "Module ID: "
								+ database.resultSet.getString(3));
					}
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			Iterator<String> iterate = students.iterator();
			while (iterate.hasNext()) {
				System.out.println(iterate.next());
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public void displayStaffsOnStudent() {
		StaffProcess staff = new StaffProcess();
		staff.displayStaffs(getStudentId());
	}

	public boolean checkStudent(int subjectID, int studentID) {
		String sql = "select * from student where student_id =" + studentID + "and subject_id=" + subjectID;
		database.resultSet(sql);
		try {
			if (database.resultSet.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return false;
	}

}
