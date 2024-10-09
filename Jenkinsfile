pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://your-repo-url.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Publish Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
