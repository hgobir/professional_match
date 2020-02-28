package com.fdm.project.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdm.project.models.User;
import com.fdm.project.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	

	@Test
	void testGetValidUserEntries() {
		User u1 = new User();
		u1.setId(1L);
		u1.setUsername("test");
		u1.setPassword("p");
		u1.setName("name");
		u1.setEmail("e");
		u1.setAge(4);
		u1.setInstitute1(1);
		u1.setInstitute2(2);
		u1.setInstitute3(3);
		u1.setInstitute4(4);
		u1.setInstitute5(5);
		
		User u2 = new User();
		u2.setId(2L);
		u2.setUsername("test2");
		u2.setPassword("p2");
		u2.setName("name2");
		u2.setEmail("e2");
		u2.setAge(5);
		u2.setInstitute1(1);
		u2.setInstitute2(2);
		u2.setInstitute3(3);
		u2.setInstitute4(4);
		u2.setInstitute5(5);
		
		User u3 = new User();
		u3.setId(3L);
		u3.setUsername("test");
		u3.setPassword("p");
		u3.setName("name");
		u3.setEmail("e");
		u3.setAge(4);
		u3.setInstitute1(1);
		u3.setInstitute2(2);
		u3.setInstitute3(3);
		u3.setInstitute4(4);
		u3.setInstitute5(5);
		
		User u4 = new User();
		u4.setId(4L);
		u4.setUsername("test2");
		u4.setPassword("p2");
		u4.setName("name2");
		u4.setEmail("e2");
		u4.setAge(5);
		u4.setInstitute1(1);
		u4.setInstitute2(2);
		u4.setInstitute3(3);
		u4.setInstitute4(4);
		u4.setInstitute5(5);
		
		User u5 = new User();
		u5.setId(5L);
		u5.setUsername("test");
		u5.setPassword("p");
		u5.setName("name");
		u5.setEmail("e");
		u5.setAge(4);
		u5.setInstitute1(1);
		u5.setInstitute2(2);
		u5.setInstitute3(3);
		u5.setInstitute4(4);
		u5.setInstitute5(5);
		
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		userList.add(u5);
		
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		
		HashMap<Long, List<Integer>> result = userService.getValidUserEntries();
		assertNotNull(result);
		assertEquals(5, result.size());
	}

}
