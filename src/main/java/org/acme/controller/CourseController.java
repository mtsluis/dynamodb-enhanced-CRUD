package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Course;
import org.acme.service.CourseService;

import java.util.List;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseController {

    @Inject
    CourseService courseService;

    @GET
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GET
    @Path("{name}/{edition}")
    public Course getSingle(@PathParam("name") String name, @PathParam("edition") Integer edition) {
        return courseService.get(name, edition);
    }

    @POST
    public List<Course> create(Course courseCreateDto) {
        courseService.add(courseCreateDto);
        return findAll();
    }

    @DELETE
    @Path("{name}/{edition}")
    public Response delete(@PathParam("name") String name, @PathParam("edition") Integer edition) {
        courseService.delete(name, edition);
        return Response.ok("Course deleted successfully.").build();
    }
}
