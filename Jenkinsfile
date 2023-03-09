pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    tools{
    maven 'mvn-3.9'
    }
    parameters {
    	choice(name: 'version', choices: ['1.1.0', '1.2.0', '1.3.0', description:'')
    	booleanParam(name: 'executeTest', defaultValue: true, description: '')
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
        	when{
        		expression{
        			params.executeTest
        		}
        	}
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
                echo "Deploying version ${version}"
            }
        }
    }
}