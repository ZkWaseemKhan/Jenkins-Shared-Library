#!/usr/bin/env groovy

def call(String building){
    echo "Building a Jar has Started...."
    sh "mvn package"
    echo "Jar has created"

}