package io.mohadkamil.jdbc;

import org.springframework.data.annotation.Id;

public record Author(@Id Long id, String name){}
