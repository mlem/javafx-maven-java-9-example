package at.mlem.framework;

public class MainApp {

    public static void main(String[] args) throws Exception {

        FrameworkLauncher frameworkLauncher = new FrameworkLauncher();
        frameworkLauncher.startOsgiFrameworkAndWaitForStop();
    }
}
