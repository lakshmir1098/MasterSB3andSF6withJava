package com.learnings.learn_spring_boot.students;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

        @RequestMapping("/students")

        public List<Students> getStudents(){
                return Arrays.asList(
                        new Students(1L, "Lak", "Udemy"),
                        new Students(2L,"Shami","Udemy"),
                        new Students(3L,"Mani","LinkedIn"),
                        new Students(5L, "Kan", "Youtube")
                );
        }
}
