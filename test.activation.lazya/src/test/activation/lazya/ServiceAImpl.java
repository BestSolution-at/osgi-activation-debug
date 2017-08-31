package test.activation.lazya;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import test.activation.api.ServiceA;

@Component
public class ServiceAImpl implements ServiceA {
	public ServiceAImpl() {
		System.err.println("ServiceAImpl instance: " + Thread.currentThread() );
	}
	
	@Activate
	public void activate() {
		System.err.println( "ServiceAImpl activated: " + Thread.currentThread() );
	}
}
