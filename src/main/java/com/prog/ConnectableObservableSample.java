package com.prog;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableSample {

	
	public static void main(String args[])
	{
		
		ConnectableObservable<String> connectable=Observable.just("Ram" , "Shyam","Jadhu","Madhu").publish();
		
		connectable.subscribe(item -> System.out.println("Observer1 is "+item));
	
		connectable.connect();
		
		//This will not print as it is hot observable
		connectable.subscribe(item -> System.out.println("Observer2 is "+item));
	}
}
