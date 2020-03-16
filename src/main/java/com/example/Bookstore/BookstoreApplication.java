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
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Adding some categories");
			crepository.save(new Category("Action"));
			crepository.save(new Category("Thriller"));
			
			log.info("adding some students");
			brepository.save(new Book("Norwegian Wood", "Some Guy" , 2012, "987-213", 14.99, crepository.findByName("Action").get(0)));
			brepository.save(new Book("1984", "George Orwell" , 1970, "234-765", 19.99, crepository.findByName("Thriller").get(0)));
			
			
			log.info("adding some users");
			User user1 = new User ("user", "$2y$10$6KYvLLVG1eZCLOkVvJPFAuVinZq2VFe5FDCFLIDJDMY1QBApbR0Wu", "USER", "user@usermail.com");
			User user2 = new User ("admin", "$2y$10$OyBdvve8YR4d9aHKtTTq8eATJbd0xlhDagNlEd4h2rMQXzG2nVAHC", "ADMIN", "admin@usermail.com");
			User user3 = new User ("Geoffrey", "$2y$10$OyBdvve8YR4d9aHKtTTq8eATJbd0xlhDagNlEd4h2rMQXzG2nVAHC", "ADMIN", "admin@usermail.com");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("All books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}			
			
		};
	}

}
