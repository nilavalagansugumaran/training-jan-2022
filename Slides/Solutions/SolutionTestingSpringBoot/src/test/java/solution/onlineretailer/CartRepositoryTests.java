package solution.onlineretailer;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTests {

	@Autowired
	CartRepository repository;

	@Test
	public void cartEmptyInitially()	 {
		int actual = repository.getAll().size();
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void addNewItems()	 {

		repository.add(1, 100);
		repository.add(2, 200);
		repository.add(3, 300);

		Map<Integer,Integer> items = repository.getAll();

		assertEquals(3, items.size());
		assertEquals(100, (int)items.get(1));
		assertEquals(200, (int)items.get(2));
		assertEquals(300, (int)items.get(3));
	}
	
	@Test
	public void updateQuantityForExistingItem()	 {

		repository.add(1, 100);
		repository.add(2, 200);
		repository.add(1, 300);

		Map<Integer,Integer> items = repository.getAll();

		assertEquals(2, items.size());
		assertEquals(400, (int)items.get(1));
		assertEquals(200, (int)items.get(2));
	}

	@Test
	public void removeExistingItem()	 {

		repository.add(1, 100);
		repository.add(2, 200);
		repository.add(1, 300);
		repository.remove(1);
		
		Map<Integer,Integer> items = repository.getAll();

		assertEquals(1, items.size());
		assertEquals(200, (int)items.get(2));
	}
}
