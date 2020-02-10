package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Adding some categories");
			crepository.save(new Category("Action"));
			crepository.save(new Category("Thriller"));
			
			log.info("adding some students");
			brepository.save(new Book("Norwegian Wood", "Some Guy" , 2012, "987-213", 14.99, crepository.findByName("Action").get(0)));
			brepository.save(new Book("1984", "George Orwell" , 1970, "234-765", 19.99, crepository.findByName("Thriller").get(0)));
			
			
			
			
			
			
			
		};
	}

}
