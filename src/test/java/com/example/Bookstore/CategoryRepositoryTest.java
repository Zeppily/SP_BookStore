package com.example.Bookstore;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameReturnsCategory() {
		List<Category> categories = repository.findByName("Action");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Action");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Fiction");
		repository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		repository.delete(repository.findByName("Action").get(0));
		List<Category> categories = repository.findByName("Action");
		assertThat(categories).hasSize(0);
	}
}
