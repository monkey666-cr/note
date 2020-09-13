#include <jni.h>
#include <string>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_refelect_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    jclass TestJclass = env->FindClass("com/example/refelect/Test");
    jfieldID publicStaticField_jfieldID = env->GetStaticFieldID(TestJclass, "publicStaticField",
                                                                "Ljava/lang/String;");
    jstring publicStaticField_content = (jstring) env->GetStaticObjectField(TestJclass,
                                                                            publicStaticField_jfieldID);
    const char *content_ptr = env->GetStringUTFChars(publicStaticField_content, nullptr);
//    int __android_log_print(int prio, const char* tag, const char* fmt, ...)
    __android_log_print(4, "kanxue->jni", "jni->%s", content_ptr);

    return env->NewStringUTF(hello.c_str());
}
