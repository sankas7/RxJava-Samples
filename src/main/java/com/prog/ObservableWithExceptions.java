package com.prog;

import io.reactivex.Observable;

public class ObservableWithExceptions {

	public static void main(String args[]) {

		Observable<Exception> obExp = Observable.error(new Exception("It is a custom exception"));

		obExp.subscribe(System.out::println,
				error -> System.out.println(error.getMessage() + " hascode - " + error.hashCode()));

		obExp.subscribe(System.out::println,
				error -> System.out.println(error.getMessage() + " hascode - " + error.hashCode()));

		Observable<Exception> obExp1 = Observable.error(() -> {
			System.out.println("Exception called");
			return new Exception("It is a new exception");
		});

		obExp1.subscribe(System.out::println,
				error -> System.out.println(error.getMessage() + " hascode - " + error.hashCode()));

		obExp1.subscribe(System.out::println,
				error -> System.out.println(error.getMessage() + " hascode - " + error.hashCode()));

	}
}
