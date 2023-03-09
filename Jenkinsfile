pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    tools{
    maven 'mvn-3.9'
    }
    environment{
    	NEW_VERSION = '1.3.0'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build stage'
                echo "Build version ${NEW_VERSION}"
                sh 'mvn -v'
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