pipeline {
       agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout'
                git 'https://github.com/UdemySpring/recipeApp'
            }
        }

          stage('anothe file call') {
                               steps {
                                   echo '##another file call ##'
                                   bat 'C:\\Users\\1024466\\IdeaProjects\\recipeApp\\Jenkins\\Jenkinsfile1'

                               }
                }
    }
}