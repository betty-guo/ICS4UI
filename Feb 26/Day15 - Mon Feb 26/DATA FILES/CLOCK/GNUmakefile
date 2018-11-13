JAVAC =     /usr/local/java/1.0.2/solaris/bin/javac -O
JLIB =      /usr/local/java/1.0.2/solaris/lib/classes.zip

all:
	$(JAVAC) -d classes -classpath classes:$(JLIB) src/*.java

clean:
	rm -rf classes
	mkdir classes
