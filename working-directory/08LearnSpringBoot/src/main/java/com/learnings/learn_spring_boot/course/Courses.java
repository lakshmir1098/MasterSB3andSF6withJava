package com.learnings.learn_spring_boot.course;

public class Courses {
        private long id;
        private String subject;
        private String source;

        public Courses(long id, String subject, String source) {
                this.id = id;
                this.subject = subject;
                this.source = source;
        }

        public long getId() {
                return id;
        }

        public String getSubject() {
                return subject;
        }

        public String getSource() {
                return source;
        }

        @Override
        public String toString() {
                return "Courses{" +
                        "id=" + id +
                        ", subject='" + subject + '\'' +
                        ", source='" + source + '\'' +
                        '}';
        }
}
