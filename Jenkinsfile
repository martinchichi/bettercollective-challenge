pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'Java_JDK', type: 'jdk'
        MAVEN_HOME = tool name: 'Maven', type: 'maven'
        PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/martinchichi/bettercollective-challenge.git'
            }
        }

        stage('Build') {
            steps {
                bat "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Test') {
            steps {
                bat "${MAVEN_HOME}/bin/mvn test"
            }
        }

        stage('Package') {
            steps {
                bat "${MAVEN_HOME}/bin/mvn package"
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            cleanWs()
        }
    }
}
