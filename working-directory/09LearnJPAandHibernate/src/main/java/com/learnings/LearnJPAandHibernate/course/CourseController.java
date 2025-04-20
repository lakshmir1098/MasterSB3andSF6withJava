package com.learnings.LearnJPAandHibernate.course;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController
{
        @RequestMapping("/courses")
        public List<Courses> getCourse(){
                return Arrays.asList(
                        new Courses(1, "AWS", "Udemy"),
                        new Courses(2,"Microservice","Udemy"),
                        new Courses(3,"Java","LinkedIn"),
                        new Courses(5, "MySQL", "Youtube")
                );
        }
}
