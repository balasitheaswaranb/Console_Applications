package com.coures;

import java.sql.SQLException;

public class Subjects {
	Database database = Database.getInstance();
	private String subjectName;
	private int subjectId;

	public String getSubjectName() {
		return subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public boolean isInDatabase(int id) {
		String sql = "select course_id,course_name from course where course_id = " + id;
		database.resultSet(sql);
		try {
			if (database.resultSet.next()) {
				this.subjectId = database.resultSet.getInt(1);
				this.subjectName = database.resultSet.getString(2);
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return false;
	}

	public boolean checkSubjectsInDatabase(int courseID) {
		String sql = "select * from subject where course_id=" + courseID;
		try {
			database.resultSet(sql);
			if (database.resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}

}
