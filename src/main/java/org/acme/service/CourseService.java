package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Course;
import org.acme.entity.Person;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CourseService {

    public static final String COURSE_TABLE_NAME = "Course";

    private DynamoDbTable<Course> courseTable;

    @Inject
    void courseEnhancedService(DynamoDbEnhancedClient dynamoEnhancedClient) {
        courseTable = dynamoEnhancedClient.table(COURSE_TABLE_NAME, TableSchema.fromBean(Course.class));
    }

    public List<Course> findAll() {
        return courseTable.scan().items().stream().collect(Collectors.toList());
    }

    public List<Course> add(Course course) {
        // This is just an example teacher, in the real usage we could get a Person from another table or we could just send a new Person in the body of the request
        course.setTeacher(new Person(1L, "email@dasd.lol", "John", "Smith", "teacher", "jSmith", LocalDate.parse( "1990-02-12"), 0, "Never St., 123"));

        courseTable.putItem(course);
        return findAll();
    }

    public Course get(String name, Integer edition) {
        Key partitionKey = Key.builder().partitionValue(name).sortValue(edition).build();
        return courseTable.getItem(partitionKey);
    }

    public void delete(String name, Integer edition) {
        Key key = Key.builder().partitionValue(name).sortValue(edition).build();
        courseTable.deleteItem(key);
    }
}
