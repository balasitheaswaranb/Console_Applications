package com.coures;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class StaffProcess {
	Scanner scanner = new Scanner(System.in);
	private int staffId;
	private String staffName;
	private String staffEmail;
	private int subjectId;
	private ArrayList<String> coursesArrayList;
	private ArrayList<String> studentsArrayList;
	Database database = Database.getInstance();

	public StaffProcess(int staffId, String staffName, int subjectId, String staffEmail) {
		this.staffId = staffId;
		this.staffName = staffName;
		this.subjectId = subjectId;
		this.staffEmail = staffEmail;
	}

	public StaffProcess() {
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String email) {
		this.staffEmail = email;
	}

	public String getStaffName() {
		return staffName;
	}

	public int getStaffId() {
		return staffId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public ArrayList<String> getStudentsArrayList() {
		return studentsArrayList;
	}

	public void setStudentsArrayList(ArrayList<String> students) {
		this.studentsArrayList = students;
	}

	public ArrayList<String> getCoursesArrayList() {
		return coursesArrayList;
	}

	public void setCoursesArrayList(ArrayList<String> courses) {
		this.coursesArrayList = courses;
	}

	public boolean isInDatabase(int staffId) {
		String sql = "select staff_id,staff_name,staff_email,subject_id from staff where staff_id = " + staffId;
		database.resultSet(sql);
		try {
			if (database.resultSet.next()) {
				 this.staffId = database.resultSet.getInt(1);
		            this.staffName = database.resultSet.getString(2);
		            this.staffEmail=database.resultSet.getString(3);
		            this.subjectId=database.resultSet.getInt(4);
				
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return false;
	}

	public void displaySubjects() {
		String sql = "select subject_id,subject_name from subject where staff_id= " + getStaffId();
		database.resultSet(sql);
		try {
			coursesArrayList = new ArrayList<String>();
			while (database.resultSet.next()) {
				coursesArrayList.add("Subject ID: " + database.resultSet.getString(1) + " - " + "Subject Name: "
						+ database.resultSet.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		Iterator<String> iterate = coursesArrayList.iterator();
		while (iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	}

	public void insertStaffIntoDB() {
		String sql = "insert into staff(staff_id,staff_name,staff_email,subject_id) values ( " + getStaffId() + ",'"
				+ getStaffName() + "','" + this.staffEmail + "','" + this.subjectId + "')";
		database.insertIntoDatabase(sql);
	}

	public boolean checkStaff(int subjectId, int staffId) {
		String sql = "select * from staff where staff_id = " + staffId + " and subject_id=" + subjectId;
		database.resultSet(sql);
		try {
			if(database.resultSet.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return false;
	}

	public void displayStudentFromstaff() {
		StudentProcess student = new StudentProcess();
		student.displayStudents(getStaffId());
	}

	public void displayStaffs(int studentId) {
		String sql = "select subject_id from student where student_id=" + studentId;
		database.resultSet(sql);
		try {
			ArrayList<String> staffs = new ArrayList<String>();
			while (database.resultSet.next()) {
				String sql1 = "select staff_id, staff_name,subject_id from staff where subject_id = "
						+ database.resultSet.getString(1);
				database.resultSet(sql1);
				try {
					if (database.resultSet.next()) {
						staffs.add("staff ID: " + database.resultSet.getString(1) + " - " + "staff Name: "
								+ database.resultSet.getString(2) + " - " + "Module ID: "
								+ database.resultSet.getString(3));
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
			Iterator<String> iterate = staffs.iterator();
			while (iterate.hasNext()) {
				System.out.println(iterate.next());
			}
			System.out.println("\n---------------------------------------");
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public void addGrade() {
		System.out.println("---------------------------------------");
		displayStudentFromstaff();
		System.out.println("---------------------------------------");
		try {
			System.out.print("Enter the ID of student which you want to give marks to: ");
			int studentId = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter subject ID of the student: ");
			int subjectId = Integer.parseInt(scanner.nextLine());
			StudentProcess student = new StudentProcess();
			if (student.checkStudent(subjectId, studentId) == true) {
				if (isAssignedByStaff(studentId) == true) {
					if (student.isInDatabase(studentId) == true) {
						System.out.print("Enter the marks you want to give: ");
						int marks = Integer.parseInt(scanner.nextLine());

						String sql = "update student set marks=" + marks + " where student_id=" + studentId
								+ " and subject_id=" + subjectId;
						if (database.insertIntoDatabase(sql))
							System.out.println("Success!! Marks added successfully!!");

					} else {
						System.out.println("Student ID doesn't exists!");
					}
				} else {
					System.out.println("Error!! You can't assign marks to the subject you don't teach!!");
				}
			} else {
				System.out.println("Entered student Id is not studying specified subject!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error! Enter integer type value!");
		}
	}

	public boolean isAssignedByStaff(int studentId) {
		String sql = "select subject_id from student where student_id=" + studentId;
		database.resultSet(sql);
		try {
			while (database.resultSet.next()) {
				if (checkStaff(Integer.parseInt(database.resultSet.getString(1)), getStaffId()) == true) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}
}
