CODE_CHANGES = getGitChanges()
pipeline {
    agent any 
    environment {
    NEW_VERSION = '1.3.0'
    } 
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
        when {
        	expression{
        		BRANCH_NAME == 'dev' &&N CODE_CHANGES == true
        	}
        }
            steps {
                echo 'Building application'
                echo "Building version is ${NEW_VERSION}"
            }
        }
        stage('Test') {
                when {
        	expression{
        		BRANCH_NAME == 'dev'
        	}
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
    post{
    	always{
    		//
    	}
    }
}