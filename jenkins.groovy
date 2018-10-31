pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/UdemySpring/recipeApp.git'
            }
        }
        stage('compile') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('docker image') {
            steps {
                bat 'mvn deploy'
            }
        }
    }
}
