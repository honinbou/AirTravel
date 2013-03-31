#!/bin/sh

find -f . | grep "\.java_UTF8" | while read i
do
file=$i
oldname=$(echo $file | cut -d '_' -f 1)
echo $file
echo $oldname
mv $file $oldname 
done
