pipeline {
    agent any 
    environment {
    NEW_VERSION = '1.3.0'
    } 
    stages {
        stage('Build') {
            steps {
                echo 'Building application'
                echo "Building version is ${NEW_VERSION}"
            }
        }
        stage('Test') {

            steps {
                echo 'Testing application'
            }
            
        }
        stage('Deliver') { 
            steps {
                echo 'Delivering application' 
            }
        }
    
}