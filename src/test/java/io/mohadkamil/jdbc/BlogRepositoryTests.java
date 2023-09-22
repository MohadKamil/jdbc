package io.mohadkamil.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BlogRepositoryTests {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    @Rollback(false)
    public void savingSameBlogShouldRewritePosts() {
        var blog = blogRepository.findById(1L).orElseThrow();

        blog.posts().add(new Post(null, "Deploying WPF Application Part 1"));

        blogRepository.save(blog);
    }
}
