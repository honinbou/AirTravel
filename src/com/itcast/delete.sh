#!/bin/sh

find -f . | grep "\.java\.UTF8" | while read i
do
echo $i
rm $i
#iconv -f gbk -t UTF-8 $i > $i.UTF8
done
