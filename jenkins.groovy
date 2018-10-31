pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                step {
                    git 'https://github.com/UdemySpring/recipeApp.git'
                }
            }
        }
        stage('compile') {
            steps {
                step {
                    bat 'mvn clean install'
                }
            }
        }
        stage('docker image') {
            steps {
                step {
                    bat 'mvn deploy'
                }
            }
        }
    }
}
