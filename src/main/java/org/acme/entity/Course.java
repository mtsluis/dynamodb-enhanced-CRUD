package org.acme.entity;


import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;


import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@DynamoDbBean
public class Course {

    public String id;
    public String name;
    public Integer edition;
    public Person teacher;
    public String syllabus;
    public String program;
    public Map<String, String> schedule;
    public BigDecimal price;
    public Integer duration;
    public String location;
    public Integer numberOfApplications;
    public Integer maxNumberOfApplications;


    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbPartitionKey
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDbSortKey
    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(Integer numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }

    public Integer getMaxNumberOfApplications() {
        return maxNumberOfApplications;
    }

    public void setMaxNumberOfApplications(Integer maxNumberOfApplications) {
        this.maxNumberOfApplications = maxNumberOfApplications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(edition, course.edition) && Objects.equals(teacher, course.teacher) && Objects.equals(syllabus, course.syllabus) && Objects.equals(program, course.program) && Objects.equals(schedule, course.schedule) && Objects.equals(price, course.price) && Objects.equals(duration, course.duration) && Objects.equals(location, course.location) && Objects.equals(numberOfApplications, course.numberOfApplications) && Objects.equals(maxNumberOfApplications, course.maxNumberOfApplications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, edition, teacher, syllabus, program, schedule, price, duration, location, numberOfApplications, maxNumberOfApplications);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", edition=" + edition +
                ", teacher=" + teacher +
                ", syllabus='" + syllabus + '\'' +
                ", program='" + program + '\'' +
                ", schedule=" + schedule +
                ", price=" + price +
                ", duration=" + duration +
                ", location='" + location + '\'' +
                ", numberOfApplications=" + numberOfApplications +
                ", maxNumberOfApplications=" + maxNumberOfApplications +
                '}';
    }
}

