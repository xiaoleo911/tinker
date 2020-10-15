package algorithm.iterator;

import algorithm.iterator.impl.CourseAggregateImpl;

/**
 * author: fupeng
 * time: 2020-07-18 23:39
 */
public class IteratorDemoTest {

    public static void main(String[] args) {
        CourseAggregateImpl aggregate = new CourseAggregateImpl();

        Course ai = new Course("ai");

        aggregate.add(ai);
        aggregate.add(new Course("设计模式"));
        aggregate.add(new Course("Redis实战"));
        aggregate.add(new Course("深入理解jvm虚拟机"));

        IteratorDemoTest.printIterator(aggregate);

        aggregate.remove(ai);

        System.out.println("================================");

        IteratorDemoTest.printIterator(aggregate);

    }

    private static void printIterator(ICourseAggregate aggregate) {
        Iterator<Course> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            System.out.println("《" + course.getName() + "》");
        }
    }

}
