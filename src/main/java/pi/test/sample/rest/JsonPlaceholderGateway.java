package pi.test.sample.rest;

import pi.test.sample.model.Post;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class JsonPlaceholderGateway {
	
	public List<Post> all() {
		return getTarget()
				.path("posts")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Post>>(){});
	}
	
	public Post get(long id) {
		return getTarget()
				.path("posts/" + id)
				.request(MediaType.APPLICATION_JSON)
				.get(Post.class);
	}

	private WebTarget getTarget() {
		Client client = ClientBuilder.newClient();
		return client.target("https://jsonplaceholder.typicode.com");
	}

}
