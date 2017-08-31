package test.activation.lazya;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class LazyAActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.err.println("LazyAActivator start: " + Thread.currentThread() );
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.err.println("LazyAActivator stop: " + Thread.currentThread() );
	}

}
