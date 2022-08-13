package net.guides.springboot.todomanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import net.guides.springboot.todomanagement.model.TestTable;
@SpringBootApplication
public class TodoManagementSpringBoot2Application implements CommandLineRunner{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoManagementSpringBoot2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//Create the database table:
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS TestTable(name VARCHAR(100))");
		
		//Insert a record:
		jdbcTemplate.execute("INSERT INTO TestTable VALUES ('Stella4')");

		//Read records:
		List<TestTable> beers = jdbcTemplate.query("SELECT * FROM TestTable",
				(resultSet, rowNum) -> new TestTable(resultSet.getString("name")));
		
		//Print read records:
		beers.forEach(System.out::println);
	}
}
