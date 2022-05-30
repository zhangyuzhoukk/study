package com.example.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class ApplicationTests {
	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		/*获得数据库链接*/
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		/*关闭连接*/
		conn.close();
	}

}
