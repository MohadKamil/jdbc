package io.mohadkamil.jdbc;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.Set;

public record Blog(@Id Long id, String name, Set<Post> posts, AggregateReference<Author,Long> blogAuthor){

}

