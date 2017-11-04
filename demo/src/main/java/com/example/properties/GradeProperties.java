package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hx on 2017/11/4.
 */
@Component
@ConfigurationProperties(prefix = "grade")
public class GradeProperties {

    private String score;

    private String course;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
