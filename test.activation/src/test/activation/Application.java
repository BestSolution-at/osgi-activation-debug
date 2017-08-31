package test.activation;

import java.util.concurrent.CountDownLatch;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import test.activation.api.ServiceA;
import test.activation.api.ServiceB;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		CountDownLatch l = new CountDownLatch(3);
				
		Thread t = new Thread("Activate A") {
			@Override
			public void run() {
				loadService(ServiceA.class);
				l.countDown();
			}
		};
		t.start();
		
		t = new Thread("Activate B") {
			@Override
			public void run() {
				loadService(ServiceB.class);
				l.countDown();
			}
		};
		t.start();
		
		t = new Thread("Activate C") {
			@Override
			public void run() {
				try {
					Class.forName("test.activation.lazyc.MyAPI");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t.start();

		
		l.await();
		
		return IApplication.EXIT_OK;
	}
	
	private void loadService(Class<?> cl) {
		Bundle bundle = FrameworkUtil.getBundle(Application.class);
		ServiceReference<?> reference = bundle.getBundleContext().getServiceReference(cl);
		System.err.println(bundle.getBundleContext().getService(reference));
	}

	@Override
	public void stop() {
		// nothing to do
	}
}
