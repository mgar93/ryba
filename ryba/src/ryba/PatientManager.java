package ryba;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientManager
{

	private Connection connection;

	private String url = "jdbc:mysql://localhost/ryba";

	private PreparedStatement addPatientStmt;
	private PreparedStatement deleteAllPatientsStmt;
	private PreparedStatement getAllPatientsStmt;
	
	public PatientManager()
	{
		try
		{
			connection = DriverManager.getConnection(url, "ryba", "ryba");
			
			addPatientStmt = connection.prepareStatement
				(
					"INSERT INTO patient (name, lastname, pesel, date, address, tel, mass, size) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
				);
			deleteAllPatientsStmt = connection
					.prepareStatement("DELETE FROM patient");
			getAllPatientsStmt = connection
					.prepareStatement("SELECT id, name, lastname, pesel, date, address, tel, mass, size FROM patient");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	Connection getConnection()
	{
		return connection;
	}

	void clearPatients() {
		try {
			deleteAllPatientsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addPatient(Patient patient) 
	{
		try {
			addPatientStmt.setString(1, patient.getName());
			addPatientStmt.setString(2, patient.getLastname());
			addPatientStmt.setLong(3, patient.getPesel());
			addPatientStmt.setString(4, patient.getDate());
			addPatientStmt.setString(5, patient.getAddress());
			addPatientStmt.setLong(6, patient.getTelephone());
			addPatientStmt.setLong(7, patient.getMass());
			addPatientStmt.setLong(8, patient.getSize());

			addPatientStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Patient> getAllPatients() {
		List<Patient> persons = new ArrayList<Patient>();

		try {
			ResultSet rs = getAllPatientsStmt.executeQuery();

			while (rs.next()) {
				Patient p = new Patient();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("name"));
				p.setLastname(rs.getString("lastname"));
				p.setPesel(rs.getLong("pesel"));
				p.setDate(rs.getString("date"));
				p.setAddress(rs.getString("address"));
				p.setTelephone(rs.getLong("tel"));
				p.setMass(rs.getLong("mass"));
				p.setSize(rs.getLong("size"));
				persons.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}
}
