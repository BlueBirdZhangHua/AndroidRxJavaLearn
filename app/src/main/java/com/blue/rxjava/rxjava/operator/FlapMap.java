package com.blue.rxjava.rxjava.operator;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

/**
 * This demo show how to use flatMap to process single item in array
 */
public class FlapMap {

    public static void run() {
        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();

        Observable.fromArray(students)
                .flatMap(new Function<Student, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(Student student) {
                        return Observable.fromArray(student.courses);
                    }
                })
                .map(new Function<Course, String>() {
                    @Override
                    public String apply(Course course) {
                        return course.name;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        Log.d(DEMO_TAG, "[FlapMap] Consumer accept:" + s);
                    }
                });
    }


    private static class Student {
        Course[] courses;

        public Student() {
            courses = new Course[2];
            courses[0] = new Course("English");
            courses[1] = new Course("Program");
        }
    }

    private static class Course {
        String name;

        public Course(String name) {
            this.name = name;
        }

    }

}
