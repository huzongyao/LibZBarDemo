# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.
# by huzongyao

cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -Wno-multichar -DLIBDIR='c' -DBUILDING_LIBICONV -DBUILDING_LIBCHARSET -DIN_LIBRARY")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds it for you.
# Gradle automatically packages shared libraries with your APK.

set(ICONV_SRCS "libiconv/lib/iconv.c"
              "libiconv/libcharset/lib/localcharset.c"
              "libiconv/lib/relocatable.c")

set(ZBAR_SRCS "zbarjni.c"
            "zbar/img_scanner.c"
            "zbar/decoder.c"
            "zbar/image.c"
            "zbar/symbol.c"
            "zbar/convert.c"
            "zbar/config.c"
            "zbar/scanner.c"
            "zbar/error.c"
            "zbar/refcnt.c"
            "zbar/video.c"
            "zbar/video/null.c"
            "zbar/decoder/code128.c"
            "zbar/decoder/code39.c"
            "zbar/decoder/code93.c"
            "zbar/decoder/codabar.c"
            "zbar/decoder/databar.c"
            "zbar/decoder/ean.c"
            "zbar/decoder/i25.c"
            "zbar/decoder/qr_finder.c"
            "zbar/qrcode/bch15_5.c"
            "zbar/qrcode/binarize.c"
            "zbar/qrcode/isaac.c"
            "zbar/qrcode/qrdec.c"
            "zbar/qrcode/qrdectxt.c"
            "zbar/qrcode/rs.c"
            "zbar/qrcode/util.c")

include_directories("./" "include/" "zbar/"
            "libiconv/include"
            "libiconv/libcharset"
            "libiconv/libcharset/include")

add_library(iconv SHARED ${ICONV_SRCS})
add_library(zbarjni SHARED ${ZBAR_SRCS})

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in the
# build script, prebuilt third-party libraries, or system libraries.
target_link_libraries(zbarjni iconv)
