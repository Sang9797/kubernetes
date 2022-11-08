pipeline {
    agent any
    stages {
        stage('Clone stage') {
            steps {
                git 'https://github.com/sang9797907/kubernetes.git'
            }
        }
        stage('Build stage') {
            steps {
                    sh 'sudo docker ps'
                withDockerRegistry(credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/') {
                    sh 'docker build -t 191197/spring-batch:v1.0.0 .'
                    sh 'docker push 191197/spring-batch:v1.0.0'
                }
            }
        }
}
}