# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html
# 指定CMake的最小版本
cmake_minimum_required(VERSION 3.4.1)

#创建一个静态或者动态库，并提供其关联的源文件路径，开发者可以定义多个库，CMake会自动去构建它们。
#Gradle可以自动将它们打包进APK中。
#第一个参数——native-lib：是库的名称
#第二个参数——SHARED：是库的类别，是动态的还是静态的
#第三个参数——src/main/cpp/native-lib.cpp：是库的源文件的路径
add_library(
        native-lib
        SHARED
        src/main/cpp/native-lib.cpp)

#找到一个预编译的库，并作为一个变量保存起来。
#由于CMake在搜索库路径的时候会包含系统库，并且CMake会检查它自己之前编译的库的名字，
#所以开发者需要保证开发者自行添加的库的名字的独特性。
#第一个参数——log-lib：设置路径变量的名称
#第一个参数—— log：指定NDK库的名子，这样CMake就可以找到这个库
find_library(
        log-lib
        log)

#指定CMake链接到目标库。开发者可以链接多个库，比如开发者可以在此定义库的构建脚本，并且预编译第三方库或者系统库。
#第一个参数——native-lib：指定的目标库
#第一个参数——${log-lib}：将目标库链接到NDK中的日志库，
target_link_libraries(
        native-lib
        ${log-lib})