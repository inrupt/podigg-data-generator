Podigg Converter RDF
=========================
#### To run this project you have to add these files from the podigg converter into the following directory `src/main/resources/input`

* routes.txt  
* stop_times.txt  
* stops.txt  
* trips.txt

#### You can then open the terminal and run the commands below to generate each of these into their directories

* Convert the .txt files to .ttl files and saves it in `src/main/output/turtle`
* Generate an index page and webpage for each stopID and saves it in `src/main/output/website`

#### This will package the compiled code in to a distributable format such as a JAR.
```shell script
$ mvn package
```
#### To run the JAR package
```shell script
$ java -cp target/PodiggConverterRDF-1.0-SNAPSHOT.jar PodiggConverterRDF
```
## Note 
* The style folder in `src/main/output/website` includes the cascading style sheet for the website.# podigg-data-generator
