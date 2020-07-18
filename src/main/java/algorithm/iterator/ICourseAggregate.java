package algorithm.iterator;

/**
 * author: fupeng
 * time: 2020-07-18 23:29
 */
public interface ICourseAggregate {

    void add(Course course);

    void remove(Course course);

    Iterator<Course> iterator();

}
