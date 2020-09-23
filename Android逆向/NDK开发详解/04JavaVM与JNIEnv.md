## JNI中的其他类型: 成员域ID和方法ID

JNI类型映射

| Java类型 | 本地类型(Native Type) | 描述                                  |
| :------- | --------------------- | ------------------------------------- |
| boolean  | jboolean              | C/C++无符号8位整数(unsigned char)     |
| byte     | jbyte                 | C/C++带符号的8位整型(char)            |
| char     | jchar                 | C/C++无符号的16位整型(unsigned short) |
| short    | jshort                | C/C++带符号的16位整型(short)          |
| int      | jint                  | C/C++带符号的32位整型(int)            |
| logn     | jlong                 | C/C++带符号的64位整型(long)           |
| float    | jfloat                | C/C++32位浮点型(float)                |
| double   | jdouble               | C/C++64位浮点型(double)               |

Java引用数据类型

| JNI数据类型 | Java数据类型        |
| ----------- | ------------------- |
| jobject     | java.lang.Object    |
| jclass      | java.lang.Class     |
| jstring     | java.lang.String    |
| jthrowable  | java.lang.Throwable |



成员域ID, 成员方法ID

```c++
struct _jfieldID;                       /* opaque structure */
typedef struct _jfieldID* jfieldID;   
struct _jmethodID;                      /* opaque structure */
typedef struct _jmethodID* jmethodID; 
```

