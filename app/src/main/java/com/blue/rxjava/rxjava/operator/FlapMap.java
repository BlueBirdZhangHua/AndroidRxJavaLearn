package com.blue.rxjava.rxjava.operator;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class FlapMap {

    public static void run(){
        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();


        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {
                Log.e("Deo" , "FlapMap onNext: "+s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable.fromArray(students)
                .flatMap(new Function<Student, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(Student student) throws Exception {
                        return Observable.fromArray(student.courses);
                    }
                })
                .map(new Function<Course, String>() {
                    @Override
                    public String apply(Course course) throws Exception {
                        return course.name;
                    }
                })
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e("Demo" , "Consumer accept:"+s);
            }
        });
    }


    private static class Student{
        Course [] courses;

        public Student() {
            courses = new Course[2];
            courses[0] = new Course("English");
            courses[1] = new Course("Program");
        }
    }

    private static class Course{
        String name;

        public Course(String name) {
            this.name = name;
        }

    }

}
