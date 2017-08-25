package pi.test.sample;

import org.junit.Before;
import org.junit.Test;
import pi.test.sample.model.Post;
import pi.test.sample.rest.JsonPlaceholderGateway;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JsonPlaceholderTest {
	
	private JsonPlaceholderGateway jsonPlaceholderGateway;
	
	@Before
	public void setup() {
		jsonPlaceholderGateway = new JsonPlaceholderGateway();	
	}
	
	@Test
	public void testPosts() throws Exception {

		List<Post> posts = jsonPlaceholderGateway.all();
		List<Post> firstUserPosts = posts.stream().filter(it -> it.getUserId() == 1).collect(toList());
		
		assertEquals(100, posts.size());
		assertEquals(10, firstUserPosts.size());
	}
	
	@Test
	public void testSinglePost() throws Exception {
		Post post =  jsonPlaceholderGateway.get(1);

		assertNotNull(post);
		assertEquals(1, post.getId());		
		assertEquals(1, post.getUserId());		
		assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", post.getTitle());		
	}
}
