package com.example.Library;

import com.example.Library.models.Book;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Book.class)
@MapperScan("com.example.Library.dao")
@SpringBootApplication
public class TestHttpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestHttpApiApplication.class, args);
	}

}
