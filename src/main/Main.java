package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	static PreparedStatement preparedStatement;
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/music_shop",
				"root", "root");
		/*preparedStatement= connection.prepareStatement("create table "
				+ "shop (id int primary key auto_increment,"
				+ "name varchar(40),address varchar(60),id_city int)");
		preparedStatement.execute();*/
		/*preparedStatement = connection.prepareStatement("create table city(id int primary "
				+ "key auto_increment,name varchar(40))");
		preparedStatement.execute();*/
		/*preparedStatement = connection.prepareStatement(" create table guitar( "
				+ "id int primary "
				+ "key auto_increment,name varchar(40),"
				+ " type varchar(40)," 
+"strings int, color varchar(20),price DECIMAL(6,3),id_brend int)");
		preparedStatement.execute();*/
		/*preparedStatement = connection.prepareStatement("create table brend "
				+ "(id int primary key auto_increment,name varchar(40)"
				+ ",country varchar(40))");
		preparedStatement.execute();*/
		/*preparedStatement = connection.prepareStatement("insert into guitar"
				+ "(name,type,strings,color,price) "
				+ "values('Les Paul Special P90','electro',6,'green',25.3),"
				+"('Stratocaster','electro',6,'green',22.43);");
				
		preparedStatement.execute();*/
		/*preparedStatement = connection.prepareStatement("insert into brend"
				+ "(name,country) "
				+ "values('ESP','USA'),"
				+" ('Gibson','USA')");
				
		preparedStatement.execute();
		*/
		/*preparedStatement = connection.prepareStatement("alter table "
				+ "shop add constraint foreign key(id_city)"
				+ " references city (id);");
				
		preparedStatement.execute();
		System.out.println("good");*/
		
		/*preparedStatement = connection.prepareStatement("create table shop_guitar(id_shop int,id_guitar int);");
				
		preparedStatement.execute();
		System.out.println("good");*/
		/*preparedStatement = connection.prepareStatement("alter table shop_guitar "
				+ "add constraint foreign key(id_shop) references shop (id);");
		preparedStatement.execute();
		preparedStatement = connection.prepareStatement("alter table shop_guitar "
				+ "add constraint foreign key(id_guitar) references guitar (id);");
		preparedStatement.execute();
*/		
		/*preparedStatement = connection.prepareStatement("alter table guitar "
				+ "add constraint foreign key(id_brend) references brend (id);");
		preparedStatement.execute();*/
		Statement st = connection.createStatement();
		/*ResultSet resultSet = st.executeQuery("select * from guitar where "
				+ "id = 1");
		while(resultSet.next()){
			System.out.println(resultSet.getString("name")+" "+resultSet.getString("price")+" ");
		}*/
		/*ResultSet resultSet = st.executeQuery("select * from guitar where "
				+ "id = 1");
		while(resultSet.next()){
			System.out.println(resultSet.getString("name"));
		}
		resultSet.close();
		resultSet = st.executeQuery("select * from guitar where "
				+ "price>22.200");
		while(resultSet.next()){
			System.out.println(resultSet.getString("name")+" "+resultSet.getString("price"));
		}
		
		resultSet.close();
		st.close();*/
		/*preparedStatement = connection.prepareStatement("UPDATE `music_shop`.`guitar` "
				+ "SET `id_brend`='1' WHERE `id`='1';  ");
		preparedStatement.executeUpdate();*/
		
		/*ResultSet resultSet = st.executeQuery("select * from guitar where id_brend in "
				+ "(select id from brend where name in(select name from brend where country like('USA'))); ");
				
		while(resultSet.next()){
			System.out.println(resultSet.getString("name"));
		}
	
		resultSet.close();
		// шукаю бренд гітари,який коштує 25.300
		resultSet = st.executeQuery("select * from brend where id in"
				+ "(select id_brend from guitar where price = 25.300)");
		
		while(resultSet.next()){
			System.out.println(resultSet.getString("country")+" "
		+resultSet.getString("name")+" ");
		}
		st.close();*/
		
		
		
		/*preparedStatement = connection.prepareStatement("insert into city"
				+ "(name) "
				+ "values('Lviv'),"
				+" ('Kyiv'),"
				+ "('Odessa')");
				
		preparedStatement.execute();*/
		
	
		/*preparedStatement = connection.prepareStatement("insert into shop"
				+ "(name,address,id_city) "
				+ "values('Trembita', 'Kopernika 25 st.',1),"
				+" ('9 nota','Pr.Svobody 5',3),"
				+ "('LesPaul','Khreshatyk 22',2);");
				
		preparedStatement.execute();*/
		
		/*preparedStatement = connection.prepareStatement("insert into shop_guitar"
				+ "(id_shop,id_guitar) "
				+ "values(1,2),"
				+" (1,1),"
				+ "(2,2);");
				
		preparedStatement.execute();*/
		
		
		ResultSet resultSet = st.executeQuery("select name from shop where id in "
				+ "(select id_shop from "
				+ "shop_guitar where id_guitar in "
				+ "(select id from guitar where   "
				+ "name like('Les Paul Special P90'))); ");
		
		while(resultSet.next()){
			System.out.println(resultSet.getString("name")+" "
				+	resultSet.getString("address")+" ");
		}
		st.close();
		
		
		
		System.out.println("good");
	}

}
