#!/bin/sh

if [ -z "$*" ]; then echo "Please provide a version number, eg 1.0"; exit 0; fi

echo "fetching latest version from git"
git fetch
git rebase

echo "compiling with maven"
mvn clean install

echo "copying war file to deploy folder"
mkdir -p deploy/$1
cp target/*.war deploy/$1
mv deploy/$1/*.war deploy/$1/root.war
