# Span Test - League points distribution
Code thas receives from command line a file path, tries to open the file and read the content, with that content, split the string using the comma as delimiter, and after that split the game name and the points over every match.

Points assignment are distributed following the next rules:
* A draw (tie) is worth 1 point.
* A win is worth 3 points. 
* A loss is worth 0 points.
* If two or more teams have the same number of points, they should have the same rank and be
  printed in alphabetical order.

## Contributors:
* **Jorge Canales** - JLP.canales21@gmail.com

### Pre-requisites:

Below technologies are required to run the project.

```
Java 11
```
```
Maven
```

### Used Technologies:

Below technologies are used in this project.

```
Junit 5
```

### How to run:

Located in the project folder, just run the spring boot run command:

* mvn clean install
* java -jar target\SpanTest-1.0-SNAPSHOT.jar

Once the command line app is running, will ask for a file path, should be something similar to:

* Windows: C:\pathToFile\\FileName.txt
* Linux/Mac: /home/pathToFile/<FileName>.txt