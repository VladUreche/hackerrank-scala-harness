Hackerrank Scala Harness
========================

This tool is built out of the frustration that the hackerrank editor does not 
respect the Scala indentation and takes embarrassingly long to compile and run
the code. 

To get quick results in the Scala IDE do:

* clone the harness code:
```
$ git clone https://github.com/VladUreche/hackerrank-scala-harness.git
```

* create a ScalaIDE project:
```
$ cd hackerrank-scala-harness
$ sbt 'eclipse with-source=true'
```

* load the project into the Scala IDE: 
    * from the `File` menu, choose `Import...`
    * from the `General` group, choose `Existing Projects into Workspace`
    * point the Scala IDE to the location of the `hackerrank-scala-harness` directory

* optionally, copy the tests given by hackerrank:
```
$ cd tests
$ mv ~/Downloads/<tests>.zip .
$ unzip *.zip
``` 

* if you copied the tests, you can run them each time you save a file:
```
$ sbt '~test'
...
1. Waiting for source changes... (press enter to interrupt)
```
(now, with each change, your tests will be executed)

I hope you find this useful and please please keep reporting the broken 
indentation to hackerrank! <br/>
Vlad
