#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" filegdbapi
    popd
    exit
fi

if [[ $PLATFORM == windows* ]]; then
    download https://dl.bintray.com/pdok/generic/filegdbapi/1.4/windows/FileGDB_API_VS2013_1_4.zip FileGDB_API_VS2013.zip
    mkdir -p $PLATFORM
    cd $PLATFORM
    unzip ../FileGDB_API_VS2013.zip -d FileGDB_API_VS2013
    cd FileGDB_API_VS2013
elif [[ $PLATFORM == macosx* ]]; then
    download https://dl.bintray.com/pdok/generic/filegdbapi/1.4/macos-x86_64/FileGDB_API_1_4-64clang.zip FileGDB_API-64clang.zip
    mkdir -p $PLATFORM
    cd $PLATFORM
    unzip ../FileGDB_API_VS2013.zip
    cd FileGDB_API-64clang
elif [[ $PLATFORM == linux-x86 ]]; then
    download https://dl.bintray.com/pdok/generic/filegdbapi/1.4/linux-x86/FileGDB_API_1_4-32.tar.gz FileGDB_API-32.tar.gz
    mkdir -p $PLATFORM
    cd $PLATFORM
    tar -xzvf ../FileGDB_API-32.tar.gz
    cd FileGDB_API-32
elif [[ $PLATFORM == linux-x86_64 ]]; then
    download https://dl.bintray.com/pdok/generic/filegdbapi/1.4/linux-x86_64/FileGDB_API_1_4-64.tar.gz FileGDB_API-64.tar.gz
    mkdir -p $PLATFORM
    cd $PLATFORM
    tar -xzvf ../FileGDB_API-64.tar.gz
    cd FileGDB_API-64
else
    echo "Warning: Platform \"$PLATFORM\" is not supported"
    # nothing
fi

case $PLATFORM in
    linux-x86)
        cp -r include ..
        cp -r lib ..
        ;;
    linux-x86_64)
        cp -r include ..
        cp -r lib ..
        ;;
    macosx-x86_64)
        cp -r include ..
        cp -r lib ..
        ;;
    windows-x86)
        cp -r include ..
        cp -r lib ..
        mkdir -p ../bin
        cp bin/*.dll ../bin
        ;;
    windows-x86_64)
        cp -r include ..
        cp -r lib64 ..
        mkdir -p ../bin
        cp bin64/*.dll ../bin
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac

cd ../..
