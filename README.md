PoDiGG Converter RDF
=========================
#### To run this project you have to add these files from the podigg converter into the following directory `src/main/resources/input`

* routes.txt  
* stop_times.txt  
* stops.txt  
* trips.txt

#### You can then open a terminal window and run the commands below to convert these PoDiGG-generated files into Turtle, and HTML, in their respective directories.

* Convert the .txt files to .ttl files, and saves it in `src/main/output/turtle`
* Generate an index.html page, and a HTML webpage for each stopID, and saves them in `src/main/output/website`

#### This will package the compiled code into a distributable JAR.

```shell script
$ mvn package
```
#### To run the JAR package
```shell script
$ java -cp target/PodiggConverterRDF-1.0-SNAPSHOT.jar PodiggConverterRDF
```

#### To run from IntelliJ

This project was developed using NetBeans, but to run itin IntelliJ simply open ‘src/javaapplication1’ and right-click -> Run... the file ‘JavaApplication1.java’. You need to move all the PoDiGG-generated ‘*.txt’ files into the ‘./testing/text’ folder (e.g. ‘routes.txt’, ‘stop_times.txt’, etc.).

## Note 

* The style folder in `src/main/output/website` includes the cascading style sheet (CSS) for the website.# podigg-data-generator
