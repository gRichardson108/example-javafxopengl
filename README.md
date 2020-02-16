# JavaFX with an OpenGL panel example
This is an example of how to use an OpenGL panel inside of JavaFX by embedding a Swing node and using JOGL.

# Building
Get [maven](https://maven.apache.org/download.cgi) and JDK 13. Run `mvn compile` and maven should pull down the JavaFX and JOGL dependencies.

# Running
You can run the JAR with your JDK `java.exe`, or use the javafx-maven-plugin included in `pom.xml` to start it with `mvn javafx:run`.