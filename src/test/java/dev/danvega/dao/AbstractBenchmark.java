package dev.danvega.dao;


import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

abstract public class AbstractBenchmark {
    @Test
    void list() throws Exception {
        ConfigBuildBenchMarch();
    }

    @Test
    void create()throws Exception {
        ConfigBuildBenchMarch();
    }

    @Test
    void get() throws Exception {
        ConfigBuildBenchMarch();
    }

    @Test
    void update() throws Exception {
        ConfigBuildBenchMarch();
    }

    void ConfigBuildBenchMarch() throws Exception {
        Options options = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName())
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(0)
                .threads(1)
                .shouldDoGC(true)
                .shouldFailOnError(true)
                .resultFormat(ResultFormatType.JSON)
                .result("/dev/null") // set this to a valid filename if you want reports
                .shouldFailOnError(true)
                .jvmArgs("-server")
                .build();
        new Runner(options).run();
    }
}