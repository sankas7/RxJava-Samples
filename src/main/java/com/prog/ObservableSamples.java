package com.prog;

import java.util.Arrays;


import io.reactivex.Observable;

/**
 * Different ways to create 
 * Observable
 * @author Pramit
 *
 */
public class ObservableSamples  {
	public static void main(String[] args) throws InterruptedException {
		Observable.just(1, 2, 3).subscribe(System.out::println);

		Observable.fromIterable(Arrays.asList("Pramit", "Raja", "Sample Data"))
				.subscribe(item -> System.out.println("Hi From - " + item));
	
	    Observable<Integer> observable = Observable.create(emitter ->
	    {
	    	emitter.onNext(1);
	    	emitter.onNext(2);
	    	emitter.onNext(3);
	    	emitter.onNext(4);
	    	emitter.onNext(5);
	    	emitter.onNext(null);
	    	emitter.onComplete();
	    });
	    
	    observable.subscribe(item -> System.out.println(item),
	    		error -> System.out.println("Custom error : " +error.getLocalizedMessage()),
	    		() -> System.out.println("Completed "));
	    
	}
}
