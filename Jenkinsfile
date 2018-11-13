pipeline {
       agent any
    stages {
            stage('master call')
            {
            steps{
            step {
                                        echo 'Checkout'
                                        git 'https://github.com/UdemySpring/recipeApp'
                               }
                                    step {
                                        echo 'Clean Build'
                                        bat 'mvn clean compile'
                                    }


                                    step {
                                        echo 'Testing'
                                        bat 'mvn test'
                                    }


                                    step {
                                        echo 'Code Coverage'
                                        jacoco()
                                    }


                                    step {
                                        echo 'Sonar Scanner'

                                        withSonarQubeEnv('SonarQube Server') {
                                            bat 'mvn sonar:sonar'
                                        }
                                    }





                                               step {
                                                   echo '## DOCKER IMAGE Crate##'
                                                   bat 'mvn clean package dockerfile:build'


                                               }






                                                        step
                                                        {
                                                        echo 'archiving'
                                                        archiveArtifacts 'target/springbootapplications-0.0.1-snapshot-docker-info.jar'
                                                         echo 'calling external job'
                                                            build job:'MyPipeline', propagate:true, wait:true
                                                        }








                                               step {
                                                   echo '## Docker hub push ##'
                                                   bat 'docker images'

                                               }
            }

            }


    }

}