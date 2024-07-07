
pipeline {
    agent any

    tools {
        jdk 'Java_JDK'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/martinchichi/bettercollective-challenge.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            parallel {
                stage('Test in Chrome') {
                    steps {
                        script {
                            bat 'mvn test -Dbrowser=chrome'
                        }
                    }
                }
                stage('Test in Firefox') {
                    steps {
                        script {
                            bat 'mvn test -Dbrowser=firefox'
                        }
                    }
                }

            }
        }

        stage('Report') {
            steps {
                cucumber buildStatus: 'NULL',
                         fileIncludePattern: '**/cucumber*.json',
                         jsonReportDirectory: 'target'
            }
        }
    }

    post {
        always {
            archiveArtifacts 'target/**/*'
        }
    }
}
