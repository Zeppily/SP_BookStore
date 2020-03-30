package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void findByUsernameReturnsUser() {
		User user = repository.findByUsername("admin");	
		assertThat(user.getUsername()).isEqualTo("admin");
	}

	@Test
	public void createNewUser() {
		User user = new User ("test", "$2y$10$6KYvLLVG1eZCLOkVvJPFAuVinZq2VFe5FDCFLIDJDMY1QBApbR0Wu", "USER", "mark@usermail.com");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteBook() {
		repository.delete(repository.findByUsername("user"));
		User user = repository.findByUsername("user");
		assertThat(user).isNull();
	}

}
