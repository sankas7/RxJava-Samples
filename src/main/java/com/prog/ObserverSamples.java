package com.prog;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverSamples {

	
	public static void main(String args[])
	{
		Observable<String> observable=Observable.just("Ram","Shyam", "Anil");
		Observer<String> observer=new Observer<String>()
				{

					@Override
					public void onSubscribe(Disposable d) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onNext(String t) {
						System.out.println("Item is - "+t);
						
					}

					@Override
					public void onError(Throwable e) {
						System.out.println(e.getLocalizedMessage());
						
					}

					@Override
					public void onComplete() {
						System.out.println("Completed");
						
					}
			
				};
				
	observable.subscribe(observer);
	
	}
}
