pipeline {
    environment {
    registry = 'akshayp07/dockerguru'
    registryCredential = 'dockerhub'
  }
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout'
                git 'https://github.com/UdemySpring/recipeApp'
            }
        }
        stage('Build') {
            steps {
                echo 'Clean Build'
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                bat 'mvn test'
            }
        }
        stage('JaCoCo') {
            steps {
                echo 'Code Coverage'
                jacoco()
            }
        }
        stage('Sonar') {
            steps {
                echo 'Sonar Scanner'
                //def scannerHome = tool 'SonarQube Scanner 3.0'
                withSonarQubeEnv('SonarQube Server') {
                    bat 'mvn sonar:sonar'
                }
            }
        }



        stage('create docker image') {
                       steps {
                           echo '## DOCKER IMAGE Crate##'
                           bat 'mvn clean package dockerfile:build'


                       }
        }

        stage('archiving artifacts') {
                            steps {
                                echo 'archiving'
                                archiveArtifacts 'target/springbootapplications-0.0.1-snapshot-docker-info.jar'
                            }
                        }
        stage('images to hub') {
                       steps {
                           echo '## Docker hub push ##'
                           bat 'docker images'
                           script {
      docker.withRegistry( ‘’, registryCredential ) {
        dockerImage.push()
      }
    }
                       }
        }
    }

}