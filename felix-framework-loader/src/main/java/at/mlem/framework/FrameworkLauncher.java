package at.mlem.framework;

import org.apache.felix.main.AutoProcessor;
import org.apache.felix.main.Main;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FrameworkLauncher {

    private static final Logger logger = LoggerFactory.getLogger(FrameworkLauncher.class);
    private static Framework m_fwk = null;

    public void startOsgiFrameworkAndWaitForStop() {
        // Print welcome banner.
        logger.info("Welcome to My Launcher");
        logger.info("======================");
        logger.info("starting osgi");

        try {
            m_fwk = getFrameworkFactory().newFramework(null);
            m_fwk.init();
            AutoProcessor.process(null, m_fwk.getBundleContext());
            m_fwk.start();

            Activator activator = new Activator();
            activator.start(m_fwk.getBundleContext());
            m_fwk.stop();
            System.exit(0);
        } catch (Exception ex) {
            logger.error("Could not create framework", ex);
            System.exit(-1);
        }
    }

    private FrameworkFactory getFrameworkFactory() throws Exception {
        java.net.URL url = Main.class.getClassLoader().getResource(
                "META-INF/services/org.osgi.framework.launch.FrameworkFactory");
        if (url != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                for (String s = br.readLine(); s != null; s = br.readLine()) {
                    s = s.trim();
                    // Try to load first non-empty, non-commented line.
                    if ((s.length() > 0) && (s.charAt(0) != '#')) {
                        return (FrameworkFactory) Class.forName(s).newInstance();
                    }
                }
            }
        }

        throw new Exception("Could not find framework factory.");
    }

}
