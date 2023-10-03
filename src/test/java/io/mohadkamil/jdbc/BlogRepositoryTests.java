package io.mohadkamil.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.HashSet;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BlogRepositoryTests {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Rollback(false)
    public void savingSameBlogShouldRewritePosts() {
        var blog = blogRepository.findById(1L).orElseThrow();

        blog.posts().add(new Post(null, "Deploying WPF Application Part 1"));

        blogRepository.save(blog);
    }

    @Test
    @Rollback(false)
    public void savingAggregateReferenceShouldStoreTheForeignKey() {
        var author = new Author(null,"Mohammed Kamil");

        author = authorRepository.save(author);
        var posts = new HashSet<Post>();
        posts.add(new Post(null, "Deploying WPF Application Part 1"));
        var blog = new Blog(null,"Kimo's Blog",posts, AggregateReference.to(author.id()) );


        blog = blogRepository.save(blog);
    }
}
