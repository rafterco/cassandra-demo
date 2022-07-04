package com.rafterco.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CassandraMain {

    public static void main(String[] args) {
        try (CqlSession cqlSession = CqlSession.builder()
                .withKeyspace("mykeyspace")
                .build()) {

            ResultSet resultSet = cqlSession.execute("SELECT * from student_hobbies");
            for (Row r : resultSet) {
                System.out.println(r.get("student_id", UUID.class));
                System.out.println(r.get("awards", List.class));
                System.out.println(r.get("fav_books", Set.class));
                System.out.println(r.get("favs", Map.class));
            }
        }

    }
}
