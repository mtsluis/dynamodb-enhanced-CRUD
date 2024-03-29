package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Course;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class CourseService {

    public static final String COURSE_TABLE_NAME = "Course";

    private DynamoDbTable<Course> courseTable;

    @Inject
    void CourseEnhancedService(DynamoDbEnhancedClient dynamoEnhancedClient) {
        courseTable = dynamoEnhancedClient.table(COURSE_TABLE_NAME, TableSchema.fromBean(Course.class));
    }

    public List<Course> findAll() {
        return courseTable.scan().items().stream().collect(Collectors.toList());
    }

    public List<Course> add(Course course) {
        courseTable.putItem(course);
        return findAll();
    }

    public Course get(String name) {
        Key partitionKey = Key.builder().partitionValue(name).build();
        return courseTable.getItem(partitionKey);
    }
}
