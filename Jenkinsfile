pipeline {
    agent any 
    
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building application'
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
}