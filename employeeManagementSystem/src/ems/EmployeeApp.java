package ems;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeApp {

	public static void main(String[] args) throws SQLException {

		Scanner scan = new Scanner(System.in);
		EmployeeDAO dao = new EmployeeDAO();

		while (true) {
			System.out.println("----Employee Management System");
			System.out.println("1. Add Employee");
			System.out.println("2. view All Employees");
			System.out.println("3. Search Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.println("Choose Option...");

			int choice = scan.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter Id");
				int id = scan.nextInt();

				scan.nextLine();

				System.out.println("Enter Name");
				String name = scan.nextLine();

				dao.addEmployee(id, name);
				break;
			}
			case 2: {
				dao.viewAll();
				break;
			}
			case 3: {
				System.out.println("Enter id");
				int id = scan.nextInt();

				dao.searchById(id);
				break;
			}
			case 4: {
				System.out.println("Enter id ");
				int id = scan.nextInt();

				scan.nextLine();
				System.out.println("Enter Name ");
				String name = scan.nextLine();

				dao.updateEmployee(id, name);
				break;
			}
			case 5: {
				System.out.println("Enter id ");
				int id = scan.nextInt();

				dao.deleteEmployee(id);
				break;
			}
			case 6: {
				System.out.println("Exiting");
				scan.close();
				System.exit(0);
				break;
			}
			default:
				System.out.println("Invalid Option");
				;
			}

		}
	}
}
