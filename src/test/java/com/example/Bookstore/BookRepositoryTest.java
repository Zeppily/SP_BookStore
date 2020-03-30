package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@Test
	public void findByTitleReturnsBook() {
		List<Book> books = repository.findByTitle("1984");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("1984");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("The bible", "Supposedly God", 1200, "1", 6.66, crepository.findByName("Action").get(0));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBook() {
		repository.delete(repository.findByTitle("1984").get(0));
		List<Book> books = repository.findByTitle("1984");
		assertThat(books).hasSize(0);
	}

}
