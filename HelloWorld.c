#include <jni.h>
#include <stdio.h>

JNIEXPORT void JNICALL Java_HelloWorld_printHello(JNIEnv *env, jobject obj)
{

	printf("Im called from C native function\n");
	display1();	

}