package test.activation.lazyb;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class LazyBActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.err.println("LazyBActivator start: " + Thread.currentThread() );
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.err.println("LazyBActivator stop: " + Thread.currentThread() );
	}

}
