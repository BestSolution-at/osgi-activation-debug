package test.activation.lazyc;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class LazyCActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.err.println("LazCActivator start: " + Thread.currentThread() );
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.err.println("LazyCActivator stop: " + Thread.currentThread() );
	}

}
