
// package com.facultate.Aplicatie1.tests;

// import secondDB.*;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;
// import static org.mockito.Mockito.when;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.Statement;

// import javax.sql.DataSource;

// import org.junit.Before;
// import org.junit.Rule;
// import org.junit.Test;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.mockito.internal.matchers.Any;
// import org.mockito.junit.MockitoJUnit;
// import org.mockito.junit.MockitoRule;

// import conection.ConnectionProvider;
// import conection.PersonBean;
// import conection.PersonDAO;

// //@RunWith(MockitoJUnit.class)
// public class CRUDTest {

// 	@Rule
// 	public MockitoRule rule = MockitoJUnit.rule();

// 	@Mock
// 	DataSource dataSource;

// 	private PersonBean person;

// 	@Before
// 	public void setUp() throws Exception {

// 		person = new PersonBean();
// 		person.setName("George");
// 		person.setEmail("george.mail");

// 		Connection conn = Mockito.mock(Connection.class);
// 		PreparedStatement query = Mockito.mock(PreparedStatement.class);
// 		ResultSet rs = Mockito.mock(ResultSet.class);
// 		ConnectionProvider dataSource = Mockito.mock(ConnectionProvider.class);
// 		MockitoAnnotations.initMocks(this);

// 		Mockito.when(dataSource.getConnection()).thenReturn(conn);
// 		Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(query);
// 		Mockito.when(query.executeQuery()).thenReturn(rs);
// 		Mockito.when(rs.isBeforeFirst()).thenReturn(false);

// 		System.out.println("dsgds");
// 	}

// 	@Test
// 	public void testIt() {
// 		new PersonDAO(dataSource).insertPerson(person);

// 	}

// 	@Test
// 	public void createAndRetrievePerson() throws Exception {
// 		PersonDAO dao = new PersonDAO(dataSource);
// 		dao.insertPerson(person);
// 		PersonBean pBean = dao.findPerson(1);
// 		assertEquals(person, pBean);
// 	}

// }
