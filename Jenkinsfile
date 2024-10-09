pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/techscoopmiranda/Selenium-Repo1.git'
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

