package conection;

import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection connection;
	static PreparedStatement preparedStatement;
	private DataSource dataSource;

	public PersonDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static int insertPerson(PersonBean personBean) {
		int status = 0;
		try {
			connection = ConnectionProvider.getConnection();
			if (personBean.getName() != null && personBean.getEmail() != null && !personBean.getName().isEmpty()
					&& !personBean.getEmail().isEmpty()) {
				preparedStatement = connection.prepareStatement("insert into person(name,email) values(?,?)",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, personBean.getName());
				preparedStatement.setString(2, personBean.getEmail());
			} else {
				System.out.println("Eroare");
			}
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {

			System.out.println("ERROR, Somethig was wrong");
		}
		return status;
	}

	public static PersonBean findPerson(int idPerson) {
		connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT p FROM person p WHERE idperson = 1");
			ResultSet rs;
			rs = preparedStatement.executeQuery();
			System.out.println(rs.toString());
			if (!rs.next()) {
				return null;
			}
			PersonBean p = new PersonBean();
			p.setIdpersoana(rs.getInt(1));
			System.out.println(p.getIdpersoana());
			p.setName(rs.getString(2));
			p.setEmail(rs.getString(3));
			connection.close();
			System.out.println(p);
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<PersonBean> getAllPersons() {
		connection = ConnectionProvider.getConnection();
		List<PersonBean> personList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT p FROM person p WHERE idperson = idPerson");
			ResultSet rs;
			rs = preparedStatement.executeQuery();

			if (!rs.first()) {
				return null;
			}
			PersonBean p = new PersonBean();
			p.setIdpersoana(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setEmail(rs.getString(3));
			personList.add(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personList;
	}
	
	public static PersonBean adAnElement()
	{
		try {
			PersonBean pBean=new PersonBean();
			connection = ConnectionProvider.getConnection();
				preparedStatement = connection.prepareStatement("insert into person(name,email) values('Mihai','mihai@mail')",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.executeUpdate();
				preparedStatement.setString(2, "Mihai");
				preparedStatement.setString(3, "mihai@mail");
				pBean.setIdpersoana(1);
				pBean.setName("Mihai");
				pBean.setEmail("mihai@mail");
				connection.close();
				return pBean;
			}catch (Exception e) {

			System.out.println("ERROR, Somethig was wrong");
		}
		return null;
	}
	
	public static void deleteAnElement(int id)
	{
		Connection myConnection=ConnectionProvider.getConnection();
		PersonBean personBean=new PersonBean();
		personBean=findPerson(1);
		System.out.println(personBean.toString());
		String query="Delete from person where idperson=?";
		try {
			PreparedStatement preparedStatement=myConnection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			preparedStatement.close();
			myConnection.commit();
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
