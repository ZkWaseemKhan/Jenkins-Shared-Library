#!/usr/bin/env groovy
package com.example.Docker
def call(String imageName) {
    echo "This global file"
    return new Docker(this).buildDockerImage(imageName)

}