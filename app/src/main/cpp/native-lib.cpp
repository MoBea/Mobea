#include <jni.h>
#include <string>



extern "C" JNIEXPORT jstring
JNICALL
Java_com_wbapp_mobea_jni_NativeJNI_stringFromJNI
(JNIEnv *env,jobject thiz/* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_wbapp_mobea_jni_NativeJNI_stringFromNameJNI
(JNIEnv *env, jobject thiz, jstring name)
{
    std::string hello = "Hello from MoBea";
    return env->NewStringUTF(hello.c_str());
}