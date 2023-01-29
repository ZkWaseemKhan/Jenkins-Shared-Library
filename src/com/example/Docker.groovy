#!/usr/bin/env groovy
package com.example
class Docker implements Serializable {
    def script
    Docker(script) {
        this.script = script
    }
        def buildDockerImage(String imageName) {
        script.echo "Docker build has started"
        script.sh "docker build -t $imageName ."
        script.echo "The build has done that is $imageName"
        }
    //login
    def dockerLogin() {
        script.echo "Docker Login Started"
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"
        script.echo "Successfully Login Docker"
        }

    }
    //push
    def dockerPush(String imageName){
        script.echo "Docker pushing has Started......."
        script.sh "docker push $imageName"
        script.echo "This $imageName Image has Pushed Sucessfully"
    }
}













