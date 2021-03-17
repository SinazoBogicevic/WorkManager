package android.example.workmanager;


import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.work.ListenableWorker.Result;
import androidx.work.Worker;
import androidx.work.testing.TestWorkerBuilder;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4ClassRunner.class)
public class FirstWorkTest {

    private Context context;
    private Executor executor;

    @Before
    public void setUp(){
        context = ApplicationProvider.getApplicationContext();
        executor = Executors.newSingleThreadExecutor();
    }

    @Test
    public void testFirstWorker(){
        FirstWork worker = TestWorkerBuilder.from(
                context,
                FirstWork.class,
                executor)
                .build();
        Result result = worker.doWork();
        assertThat(result, is(Result.success()));

    }

}