package ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {
	Connection con = DBConnection.getConnection();

	public void addEmployee(int id, String name) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES(?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.executeUpdate();
		System.out.println("Inserted Successfully");
	}

	public void viewAll() throws SQLException {
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM employee");

		boolean found = false;

		while (rs.next()) {
			System.out.println("Id of employee : " + rs.getInt("id") + "\n Name of Employee " + rs.getString("name"));
		}
		if (!found) {
			System.out.println("No Employees Found");
		}

	}

	public void searchById(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE ID = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println(
					"Id of the Employee" + rs.getInt("id") + "\n Name of the Employee " + rs.getString("name"));
		} else {
			System.err.println("No Employee Found");
		}
	}

	public void updateEmployee(int id, String newName) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE employee SET name = ? WHERE id = ?");
		ps.setString(1, newName);
		ps.setInt(2, id);

		int rs = ps.executeUpdate();
		if (rs > 0) {
			System.out.println("Employee Updated Successfully");
		} else {
			System.err.println("Employee not Found");
		}

	}

	public void deleteEmployee(int id) throws SQLException {

		PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE id = ?");
		ps.setInt(1, id);
		int row = ps.executeUpdate();
		if (row > 0) {
			System.out.println("Employee Deleted Successfully");
		} else {
			System.err.println("Employee Not Found..");
		}
	}

}
