package com.learnings.LearnJPAandHibernate.students;

public class Students {
        private Long id;
        private String name;
        private String course_src;

        public Students(Long id, String name, String course_src) {
                this.id = id;
                this.name = name;
                this.course_src = course_src;
        }

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getCourse_src() {
                return course_src;
        }
}
