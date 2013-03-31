#!/bin/sh

find -f . | grep "\.java" | while read i
do
iconv -f gbk -t UTF-8 $i > ${i}_UTF8
done
