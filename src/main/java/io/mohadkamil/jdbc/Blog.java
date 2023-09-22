package io.mohadkamil.jdbc;

import org.springframework.data.annotation.Id;

import java.util.Set;

public record Blog(@Id Long id, String name, Set<Post> posts){

}

