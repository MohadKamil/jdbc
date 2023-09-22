package io.mohadkamil.jdbc;

import org.springframework.data.annotation.Id;

public record Post(@Id Long id, String Title) {

}
