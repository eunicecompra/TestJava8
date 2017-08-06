package com.tutorial.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTester {

    public static void main(String args[]) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future<String> future = pool.submit( () -> { //Callable interface
            int cnt = 0;
            for ( int i = 0; i < 1000; i++) {
                cnt++;
                Thread.sleep(3);
            }

            return "Hello world " + cnt + " times!";
        });

        System.out.println("Is future here? " + future.isDone() );

        System.out.print("In the meantime, going round and round inside the while loop" );
        try {
            //Wait for the future
            while (!future.isDone()) {
                System.out.print("." );
                Thread.sleep(100);
            }

            System.out.println("\nAlas, the future is here! " + future.get());
            pool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
