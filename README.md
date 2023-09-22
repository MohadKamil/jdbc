Till recently (somewhat in the mid of 2022), Spring data JDBC deleted child entities and re-inserted them when persisting an aggregate root, this project was a small experiment to verify if this behavior was updated, I'm happy to annouce that it's actually updated.

This projects seeds a db with a small graph of a blog and a child post, loads the blog from db, adds a new post, and verifys that the original post (with its orignal id) is retained after the insert.

## Things to do
verification is done against a local seeded postgresql db, it would be nice for the test to actually implement the full flow
