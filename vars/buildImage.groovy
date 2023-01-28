#!/usr/bin/env groovy

def call(String imageName) {
    echo "Making docker Image and Pushing to docker started -- from shared repo"
    withCredentials([usernamePassword(credentialsId: 'docker-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
       sh "docker build -t $imageName ."
       sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
       sh "docker push $imageName"
    }
    echo "Creating Image and Pushing to Docker has finished"
}

