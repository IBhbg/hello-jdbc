package dev.danvega.dao;

import dev.danvega.model.Course;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark extends AbstractBenchmark {

    @Autowired
    private CourseJdbcDAO courseJdbcdao;

    @Autowired
    private Course course;

    @Benchmark
    public void tesTList(){
        courseJdbcdao.list();
    }

    @Benchmark
    public void tesTcreate() {
        course = new Course("Ivan","läser","linkar");
        courseJdbcdao.update(course,1);
    }

    @Benchmark
    public void tesTget() {
    }

    @Benchmark
    public void tesTupdate() {
    }

    @Benchmark
    public void tesTdelete() {
    }
}