# Calling a C funtion from Java Class Using JNI

## Step1:
Create a Java file containing a **native** method call written in c.
```
javac HelloWorld.java
```
Compile that java program for getting the .class
**HelloWorld.java contains "private native" and "System.loadLibrary" keyword which is very important to understand**

## Step2:
Create a JNI-style header file using "javah" for implementing the native method in C.

```
$ javah -jni HelloWorld
```

## Step3:
Implement the "HelloWorld.c" file by taking the JNI prototype from the "HelloWorld.h" file generated 
from Step2.

## Step4:
Compile HelloWorld.c using gcc and create "libHelloWorld.so" file 
```
gcc -c -fPIC HelloWorld.c -o HelloWorld.o
gcc HelloWorld.o -shared -o libHelloWorld.so

```
				OR
```
gcc -shared -o libhello.so -fPIC hello.c
```
**libHelloWorld(class name) is must**

## Step5:
Set the native library path to avoid **java.lang.UnsatisfiedLinkError**
```
LD_LIBRARY_PATH=.
export LD_LIBRARY_PATH

```

## Step6:
Finally run the native class
```
java HelloWorld
```


## Compilation of different c program and integration with JNI


**Generating .o files for different .c**

HelloWorld2.c --> contains display2()
	
	↑

HelloWorld1.c --> contains display1() calling display2() from **HelloWorld2.c**	

	↑

HelloWorld.c  --> JNI C program calling display1(); 

```
gcc -c -fPIC HelloWorld1.c -o HelloWorld1.o
gcc -c -fPIC HelloWorld2.c -o HelloWorld2.o
gcc -c -fPIC HelloWorld.c -o HelloWorld.o
```
**Creating single .o file from different .o**

	HelloWorld1.o 	HelloWorld2.o 	HelloWorld.o
		|				|				|
		|_______________|_______________|
						

						↓

					finalHelloWorld.o
```
ld -r HelloWorld1.o HelloWorld2.o HelloWorld.o -o finalHelloWorld.o
```
**Generating .so file from finalHelloWorld.o**

	finalHelloWorld.o-->libHelloWorld.so		
```
gcc HelloWorld.o -shared -o libHelloWorld.so
```



## [Additional Resources]

[Resource 1](https://stackoverflow.com/questions/5963266/call-c-function-from-java)

[Resource 2](https://ubuntuforums.org/showthread.php?t=1705911)









