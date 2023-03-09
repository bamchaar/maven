pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build stage'
            }
        }
        stage('Test') {
            steps {
                echo 'Test stage'
            }
            post {
                always {
                    echo 'Post Test stage'
                }
            }
        }
        stage('Deliver') { 
            steps {
                echo 'Deliver stage' 
            }
        }
    }
}