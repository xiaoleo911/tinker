package algorithm.iterator.impl;

import algorithm.iterator.Course;
import algorithm.iterator.ICourseAggregate;
import algorithm.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * author: fupeng
 * time: 2020-07-18 23:36
 */
public class CourseAggregateImpl implements ICourseAggregate {

    private List<Course> list = new ArrayList<>();

    @Override
    public void add(Course course) {
        list.add(course);
    }

    @Override
    public void remove(Course course) {
        list.remove(course);
    }

    @Override
    public Iterator<Course> iterator() {
        return new IteratorImpl<>(list);
    }
}
