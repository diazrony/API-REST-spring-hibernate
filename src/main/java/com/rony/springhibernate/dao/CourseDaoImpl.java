package com.rony.springhibernate.dao;

import com.rony.springhibernate.model.Course;

import java.util.List;

public class CourseDaoImpl extends AbstractSession implements CourseDao {
    @Override
    public void saveCourse(Course course) {
        getSession().persist(course);
    }

    @Override
    public List<Course> findAllCourse() {
        return getSession().createQuery("from Course ").list();
    }

    @Override
    public void deleteCourseById(Long idCourse) {
        Course course = findCourseById(idCourse);
        if (course != null){
            getSession().delete(course);
        }
    }

    @Override
    public void updateCourse(Course course) {
        getSession().update(course);
    }

    @Override
    public Course findCourseById(Long idCourse) {
        return (Course) getSession().get(Course.class,idCourse);
    }
}
