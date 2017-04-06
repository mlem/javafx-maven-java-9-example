# TODO

## Start the JavaFX App through Activator instead of manually calling the class
* currenty we call in the framework activator the mainUI launcher
* it should be started automatically by correctly bundling the javafx bundle
* move the javaFx maven plugin to the framework module??
    * Doublecheck on that. I want an easily starteable app, so EVERY user can start it
    

## Write one plugin as an example
* should be adding following
    * a menu entry (should be done by the core app - provide text)
    * a tab (should be done by the core app - provide text)
    * a pane in tab click (should be done by the core app - provide a pane)
    * a configuration for this plugin (should be done by the core app - provide a pane)
    * optional some storage of the data
    * optional historical view of the data (stepping back)

## Plugin Automatic download
*  Github Release informations 
   * https://developer.github.com/v3/repos/releases/#get-a-single-release 
   * curl -H "Accept: application/vnd.github.v3+json" https://api.github.com/repos/mlem/javafx-with-plugins-example/releases
   
## Automatic Plugin install

* there is a way to listen to new bundles with apache felix file install 
    * http://felix.apache.org/documentation/subprojects/apache-felix-file-install.html
   
  
   
   
## Other stuff
#### OSGi over Annotations:
* http://felix.apache.org/documentation/subprojects/apache-felix-maven-scr-plugin/scr-annotations.html
* http://felix.apache.org/documentation/subprojects/apache-felix-service-component-runtime.html
* https://kishanthan.wordpress.com/2014/03/29/using-annotation-with-osgi-declarative-services/
* http://blog.osoco.de/2016/05/migrating-from-the-apache-felix-scr-annotations-to-the-osgi-declarative-services-annotations/
#### create OSGi Bundles with 
* http://felix.apache.org/documentation/subprojects/apache-felix-maven-bundle-plugin-bnd.html

#### Version ranges with osgi
* http://stackoverflow.com/questions/8353771/osgi-valid-version-ranges
   
#### Release stats from github
* http://www.somsubhra.com/github-release-stats/?username=mlem&repository=javafx-with-plugins-example




## TODO ARCHIVE

## ~~Change indirection~~

* ~~now JavaFX app starts the OSGi Framework.~~
    * ~~we need to indirect this direction: OSGi needs to start and then it should start a bundle with the UI~~
    * ~~see this nice example~~ 
        * ~~http://felix.apache.org/documentation/subprojects/apache-felix-ipojo/apache-felix-ipojo-gettingstarted/ipojo-in-10-minutes.html~~
