package at.mlem.mainui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

    private static final Logger log = LoggerFactory.getLogger(Activator.class);

    private MainUI mainUI;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        log.info("starting ui");
        mainUI = new MainUI();
        mainUI.launchUI(new String[0]);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        log.info("stopping ui");
    }
}
