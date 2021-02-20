package com.prog;

import java.util.Arrays;

import io.reactivex.Observable;

/**
 * Different ways to create Observable
 * 
 * @author Pramit
 *
 */
public class ObservableSamples {

	public static int count = 10;
	public static int start = 1;

	public static void main(String[] args) throws InterruptedException {
		Observable.just(1, 2, 3).subscribe(System.out::println);

		Observable.fromIterable(Arrays.asList("Pramit", "Raja", "Sample Data"))
				.subscribe(item -> System.out.println("Hi From - " + item));

		Observable<Integer> observable = Observable.create(emitter -> {
			emitter.onNext(1);
			emitter.onNext(2);
			emitter.onNext(3);
			emitter.onNext(4);
			emitter.onNext(5);
			emitter.onNext(null);
			emitter.onComplete();
		});

		observable.subscribe(item -> System.out.println(item),
				error -> System.out.println("Custom error : " + error.getLocalizedMessage()),
				() -> System.out.println("Completed "));

		Observable<Object> obs = Observable.empty();
		obs.subscribe(System.out::println, System.out::println, () -> System.out.println("It is done"));

		Observable<Object> obsNever = Observable.never();
		obsNever.subscribe(System.out::println, System.out::println, () -> System.out.println("It is done"));

		Observable<Integer> obsRange = Observable.range(start, count);
		obsRange.subscribe(System.out::println);

		Observable<Integer> obsDefer = Observable.defer(() -> 
		{
		System.out.println("New observable is created with start " + start + " and count " +count);
		return Observable.range(start, count);
		});

		obsDefer.subscribe(item -> System.out.println(" Observale 1 - " + item));

		count = 5;

		obsDefer.subscribe(item -> System.out.println(" Observale 2 - " + item));

	}
}
