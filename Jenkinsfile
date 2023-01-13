pipeline {
    agent any
    environment{
        PATH=''
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy Stage'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                echo 'Test Stage'
            }
        }
        stage('Release') {
            steps {
                echo 'Release Stage'
            }
        }
    }
}
