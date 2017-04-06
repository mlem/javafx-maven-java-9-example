# What I have learned today
## 07.04.2017

* OBR
    * It's like maven, there are local and remote repos, you can upload (and probably fetch) those artifacts (bundles)
    * it's possible to load bundles over network/internet
* how to write osgi app with desktop ui
    * see http://felix.apache.org/documentation/tutorials-examples-and-presentations/apache-felix-application-demonstration.html
* starting felix from command line
    * managed to run it, but didn't manage to trigger the Activator for mainUi by importing that bundle over file path
    * see http://felix.apache.org/documentation/subprojects/apache-felix-framework/apache-felix-framework-usage-documentation.html    
* found a very good book online, which handles felix osgi and maven
    * https://books.google.at/books?id=DTsni6F0ZkIC&pg=PT217&lpg=PT217&dq=use+bundles+installed+in+obr&source=bl&ots=GcA6mGgmgf&sig=QD59qRh8oDR72kkh2vpk42j6IlM&hl=de&sa=X&ved=0ahUKEwiN34qGwJDTAhVGQBQKHZKJDkIQ6AEITjAG#v=onepage&q=use%20bundles%20installed%20in%20obr&f=false


## 04.04.2017

* IntelliJ has a really cool SceneBuilder. I guess oracle or my jdk has one too.
* You can specify OSGi Version ranges for your plugins
* Github offers an api to fetch release informations, plenty of urls and download_count!
* JavaFX has a tab pane, where you can add stuff pretty easily
* I've found an easy way to bind hotkeys for pasting (KeyCombination)
    * key propagation, 
    * key consumation (to stop propagate)
* there is an easy way to use the clipBoard content with ClipBoard class
 
* How to embed apache felix into an javaFx app or any app (http://felix.apache.org/documentation/subprojects/apache-felix-framework/apache-felix-framework-launching-and-embedding.html)