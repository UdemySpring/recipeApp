pipeline {
       agent any
    stages {
            stage('master call')
            {
            steps {
                            echo 'Checkout'
                            git 'https://github.com/UdemySpring/recipeApp'
                   }
                        steps {
                            echo 'Clean Build'
                            bat 'mvn clean compile'
                        }


                        steps {
                            echo 'Testing'
                            bat 'mvn test'
                        }


                        steps {
                            echo 'Code Coverage'
                            jacoco()
                        }


                        steps {
                            echo 'Sonar Scanner'

                            withSonarQubeEnv('SonarQube Server') {
                                bat 'mvn sonar:sonar'
                            }
                        }





                                   steps {
                                       echo '## DOCKER IMAGE Crate##'
                                       bat 'mvn clean package dockerfile:build'


                                   }






                                            steps
                                            {
                                            echo 'archiving'
                                            archiveArtifacts 'target/springbootapplications-0.0.1-snapshot-docker-info.jar'
                                             echo 'calling external job'
                                                build job:'MyPipeline', propagate:true, wait:true
                                            }








                                   steps {
                                       echo '## Docker hub push ##'
                                       bat 'docker images'

                                   }
            }


    }

}