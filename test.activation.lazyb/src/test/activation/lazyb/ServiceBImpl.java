package test.activation.lazyb;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import test.activation.api.ServiceB;

@Component
public class ServiceBImpl implements ServiceB {
	public ServiceBImpl() {
		System.err.println("ServiceBImpl instance: " + Thread.currentThread() );
	}
	
	@Activate
	public void activate() {
		System.err.println( "ServiceBImpl activated: " + Thread.currentThread() );
	}
}
