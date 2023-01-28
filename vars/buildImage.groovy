#!/usr/bin/env groovy

def call() {
    echo "Making docker Image and Pushing to docker started -- from shared repo"
    withCredentials([usernamePassword(credentialsId: 'docker-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
       sh "docker build -t waseemkhandocker/java-maven-app-from-idle:3.0 ."
       sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
       sh "docker push waseemkhandocker/java-maven-app-from-idle:3.0"
    }
    echo "Creating Image and Pushing to Docker has finished"
}

