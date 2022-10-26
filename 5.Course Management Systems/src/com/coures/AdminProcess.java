package com.coures;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class AdminProcess {

	Database database = Database.getInstance();
	Scanner scanner = new Scanner(System.in);
	private String adminName;
	private String adminUserName;
	private String adminPassword;
	private ArrayList<String> courseList;

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public void setUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminName() {
		return adminName;
	}

	public boolean adminLogin() {

		System.out.print("Enter username: ");
		String userName = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		System.out.println("---------------------------------------");

		if (isInDatabase(userName) == true) {
			if (validateAdmin(userName, password) == true) {
				return true;
			} else {
				System.out.println("Incorrect password!");
				System.out.println("---------------------------------------");
			}
		} else {
			System.out.println("Username doesn't exist!");
			System.out.println("---------------------------------------");
		}
		return false;
	}

	private boolean validateAdmin(String userName, String password) {
		if (adminUserName.equals(userName)) {
			if (adminPassword.equals(password)) {
				return true;
			}
		}
		return false;
	}

	private boolean isInDatabase(String username) {
		String sql = "select admin_name,admin_username, admin_password from admin where admin_username='" + username
				+ "'";
		database.resultSet(sql);
		try {
			if (database.resultSet.next()) {
				this.adminName = database.resultSet.getString(1);
				this.adminUserName = database.resultSet.getString(2);
				this.adminPassword = database.resultSet.getString(3);
				return true;
			}
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		return false;
	}

	public void cancelCourse() {
		courseStatusFromDb();
		try {
			System.out.print("Enter the ID of course you want to cancel: ");
			int courseId = Integer.parseInt(scanner.nextLine());
			Courses course = new Courses();
			if (course.isInDatabase(courseId) == true) {
				String sql1 = "select status from course where course_id = " + courseId;
				database.resultSet(sql1);
				try {
					while (database.resultSet.next()) {
						if (database.resultSet.getString(1).equals("False")) {
							System.out.println("Course is already cancelled!");
							return;
						}
					}
				} catch (SQLException ex) {
					System.out.println();
					System.out.println("Error: " + ex.getMessage());
				}
				changeCourseStatusFromDB(courseId, "False");
			} else {
				System.out.println("Course ID doesn't exists!!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error!! Enter Integer type value!!");
		}
	}

	private void courseStatusFromDb() {
		String sql = "select course_id, course_name,status from course";
		database.resultSet(sql);
		courseList = new ArrayList<String>();
		try {
			while (database.resultSet.next()) {
				courseList.add(database.resultSet.getString(1) + " - " + database.resultSet.getString(2));
			}
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		System.out.println("--------------------------------------");
		Iterator<String> iterate = courseList.iterator();
		while (iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		System.out.println("--------------------------------------");
	}

	public void resumeCourse() {
		courseStatusFromDb();
		try {
			System.out.print("Enter the ID of course you want to resume: ");
			int courseId = Integer.parseInt(scanner.nextLine());
			Courses course = new Courses();
			if (course.isInDatabase(courseId) == true) {
				String sql1 = "select status from course where course_id =" + courseId;
				database.resultSet(sql1);
				try {
					while (database.resultSet.next()) {
						if (database.resultSet.getString(1).equals("True")) {
							System.out.println("Course is already resumed!");
							return;
						}
					}
				} catch (SQLException ex) {
					System.out.println();
					System.out.println("Error: " + ex.getMessage());
				}
				changeCourseStatusFromDB(courseId, "True");
			} else {
				System.out.println("Error!! Course ID doesn't exists!!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error! Please enter integer type value!!");
		}

	}

	private void changeCourseStatusFromDB(int courseId, String newStatus) {
		String sql = "update course set status='" + newStatus + "' where course_id=" + courseId;
		database.insertIntoDatabase(sql);
	}

	public void addSubject() {
		try {
			Courses course = new Courses();
			course.displayCourses();
			System.out.print("Enter course ID: ");
			int courseId = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter subject Name: ");
			String subjectName = scanner.nextLine();
			System.out.print("Enter subject ID: ");
			int subjectId = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter level of the course: ");
			int level = Integer.parseInt(scanner.nextLine());
			System.out.println();
			Subjects subject = new Subjects();
			if (subject.isInDatabase(subjectId) == false) {
				insertSubjectIntoDb(subjectId, subjectName, courseId, level);
			} else {
				System.out.println("Error!! subject ID already exists!!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error! Enter integer type value!!");
		}
	}

	private void insertSubjectIntoDb(int subjectId, String subjectName, int courseId, int level) {
		String sql = "INSERT into subject (subject_id,subject_name, course_id,level) values (" + subjectId + ",'"
				+ subjectName + "'," + courseId + "," + level + ")";
		database.insertIntoDatabase(sql);
	}

	public void editCourse() {
		Courses course = new Courses();
		course.displayCourses();
		try {
			System.out.print("Enter course ID: ");
			int courseId = Integer.parseInt(scanner.nextLine());
			if (course.isInDatabase(courseId) == true) {
				System.out.print("Enter the new name for the course: ");
				String courseName = scanner.nextLine();
				String sql = "update course set course_name= '" + courseName + "' where course_id=" + courseId;
				database.insertIntoDatabase(sql);
			} else {
				System.out.println("Error!! Course ID doesn't exists!!");
				System.out.println();
			}
		} catch (InputMismatchException ex) {
			System.out.println("Error:" + ex.getMessage());
		}
	}

	public void editSubjects() {
		try {
			Courses course = new Courses();
			course.displayCourses();
			System.out.print("Enter course ID: ");
			int courseId = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter the level of the course: ");
			int level = Integer.parseInt(scanner.nextLine());
			System.out.println();
			course.displaySubjects(courseId, level);
			System.out.print("Enter the Id of subject you want to update: ");
			int subjectId = Integer.parseInt(scanner.nextLine());
			System.out.println();
			Subjects subject = new Subjects();
			if (subject.isInDatabase(subjectId) == true) {
				System.out.print("Enter the new name for the subject: ");
				String subjectName = scanner.nextLine();
				System.out.println();
				String sql = "update subject set subject_name=" + subjectName + " where subject_id=" + subjectId
						+ " and level=" + level;
				database.insertIntoDatabase(sql);
			} else {
				System.out.println("Error!! Subject ID doesn't exists!!");
			}
		} catch (InputMismatchException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public void assignNewStaff() {
		try {
			System.out.print("Enter Staff Name: ");
			String staffName = scanner.nextLine();
			System.out.print("Enter staff ID: ");
			int staffId = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter subject ID: ");
			int subjectId = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter staff email: ");
			String staffEmail = scanner.nextLine();
			System.out.println();

			StaffProcess ins = new StaffProcess(staffId, staffName, subjectId, staffEmail);
			Subjects mo = new Subjects();

			if (mo.isInDatabase(subjectId) == true) {
				if (ins.checkStaff(subjectId, staffId) == false) {
					ins.insertStaffIntoDB();
				} else {
					System.out.println("That staff is already teaching the specified subject!");
				}
				updateStaffOnSubject(subjectId, staffId);
			} else {
				System.out.println("Subject ID doesn't exists!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void assignStaffToCourse() {
		try {
			System.out.println("Enter staff ID:");
			int staffId = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter subject ID:");
			int subjectId = Integer.parseInt(scanner.nextLine());
			StaffProcess staff = new StaffProcess();
			staff.setSubjectId(subjectId);
			if (staff.isInDatabase(staffId) == true) {
				Subjects subject = new Subjects();
				if (subject.isInDatabase(subjectId) == true) {
					if (staff.checkStaff(subjectId, staffId) == false) {
						staff.setSubjectId(subjectId);
						staff.insertStaffIntoDB();
					} else {
						System.out.println("That staff is already teaching specified subject!");
					}
					updateStaffOnSubject(subjectId, staffId);
				} else {
					System.out.println("Subject ID doesn't exist!");
				}
			} else {
				System.out.println("staff ID doesn't exist");
			}
		} catch (InputMismatchException ex) {
			System.out.println("Error! Please enter integer type value!");
		}
	}

	public void updateStaffOnSubject(int subjectId, int staffId) {

		String sql = "update subject set staff_id=" + staffId + " where subject_id=" + subjectId;
		if (database.insertIntoDatabase(sql))
			System.out.println("staff updated successfully on subject!!");
	}

	public void updateStaff() {
		try {
			System.out.print("Enter staff ID: ");
			int staffId = Integer.parseInt(scanner.nextLine());
			StaffProcess staff = new StaffProcess();
			if (staff.isInDatabase(staffId) == true) {
				System.out.print("Enter the new email of the staff: ");
				String staffEmail = scanner.nextLine();
				String sql = "update staff set staff_email='" + staffEmail + "' where staff_id="
						+ staffId;
				if (database.insertIntoDatabase(sql))
					System.out.println("staff updated successfully on staff table!!");
			} else {
				System.out.println("staff ID doesn't exists!!!");
			}
		} catch (InputMismatchException ex) {
			System.out.println("Enter integer type value!!");
		}
	}

	public void resultSlip() {
		try {
			System.out.print("Enter Student ID to make result slip: ");
			int studentId = Integer.parseInt(scanner.nextLine());
			StudentProcess student = new StudentProcess();
			if (student.isInDatabase(studentId) == true) {
				String sql = "select student_id,student_name,subject_id,marks from student where student_id="
						+ studentId;
				database.resultSet(sql);
				ArrayList<String> marksList = new ArrayList<>();
				System.out.println("--------------------------------------");
				System.out.println("           Result Slip                ");
				System.out.println("--------------------------------------");
				int pass = 0;
				int fail = 0;
				try {
					while (database.resultSet.next()) {
						this.adminName = database.resultSet.getString(2);
						if (Integer.parseInt(database.resultSet.getString(4)) > 39) {
							pass++;
							marksList.add("Course ID: " + database.resultSet.getString(3) + "\t" + "Marks: "
									+ database.resultSet.getString(4) + "\t" + "Result: Pass\n");
						} else {
							marksList.add("Course ID:" + database.resultSet.getString(3) + "\t"
									+ database.resultSet.getString(4) + "\t" + "Result: Fail\n");
							fail++;
						}
					}
	                    System.out.println("Student Name: "+student.getStudentName());
	                    System.out.println("Student ID: "+student.getStudentId());
	                    System.out.println();
					System.out.println("--------------------------------------");
					Iterator<String> iterate = marksList.iterator();
					while (iterate.hasNext()) {
						System.out.println(iterate.next());
					}
					System.out.println("--------------------------------------");
					System.out.println();
					if (pass >= fail) {
						System.out.println("Congratulations! You can move to the next level!");
					} else {
						System.out.println("Sorry! You can't move to next level!");
					}
					System.out.println("--------------------------------------");

				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			} else {
				System.out.println("Student ID doesn't exist!!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error! Please enter integer type value!!");
		}
	}
}
