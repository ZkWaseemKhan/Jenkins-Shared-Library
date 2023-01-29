#!/usr/bin/env groovy
package com.example
class Docker implements Serializable {
    def script
    Docker(script) {
        echo "Calling docker class from global 2"
        this.script = script
    }
    def buildDockerImage(String imageName) {
        script.echo "This is from class of Docker"
        script.echo "Making docker Image and Pushing to docker started -- from shared repo"
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"
            script.sh "docker push $imageName"
        }
        script.echo "Creating Image and Pushing to Docker has finished"
    }
}











