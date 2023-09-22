package io.mohadkamil.jdbc;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends ListCrudRepository<Blog,Long> {
}
