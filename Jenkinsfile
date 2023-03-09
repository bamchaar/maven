pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    environment{
    	NEW_VERSION = '1.3.0'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build stage'
                echo "Build version ${NEW_VERSION}"
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