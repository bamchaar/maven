def gv
pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    tools{
    maven 'mvn-3.9'
    }
    parameters {
    	choice(name: 'version', choices: ['1.1.0', '1.2.0', '1.3.0'], description:'')
    	booleanParam(name: 'executeTest', defaultValue: true, description: '')
    }
    environment{
    	NEW_VERSION = '1.3.0'
    }
    stages {
    	stage("init"){
    	steps{
    		script{
    			gv = load "script.groovy"
    		}
    		}
    	}
        stage('Build jar') {
            steps {
				script{
				gv.BuildApp()
				sh'mvn package'
				}
            }
        }
        stage('Build image') {
            steps {
				script{
				echo 'Building Docker image'
				withCredentials([usernamePassword(credentialsId: 'tcpipeline',passwordVariable: 'PASS' , usernameVariable: 'USER')]){
				sh 'docker build -t tcdmv/mvn-app:java-mvn-2.0 .'
				sh "echo $PASS | docker login -u $USER --password-stdin"
				sh 'docker push tcdmv/mvn-app:java-mvn-2.0
				}
				}
            }
        }        
        stage('Test') {
        	when{
        		expression{
        			params.executeTest
        		}
        	}
            steps {
				script{
				gv.TestApp()
				}
            }
            post {
                always {
                    echo 'Post Test stage'
                }
            }
        }
        stage('Deploy') {
        	input{
        		message "Select the environment to deploy"
        		ok "Done"
        		parameters{
        		choice(name: 'environment1', choices: ['dev', 'staging', 'prod'], description:'')
        		choice(name: 'environment2', choices: ['dev', 'staging', 'prod'], description:'')
        		}
        	} 
            steps {
				script{
				gv.DeployApp()
				echo " deploy ${environment1}"
				echo " deploy ${environment2}"
				}
            }
        }
        stage('Deliver') { 
            steps {
				script{
				env.REPO = input message:"Select the repo to deliver to", ok: "Done", parameters:[choice(name: 'environment1', choices: ['DockerHub', 'Nexus', 'AWS-ECR'], description:'')]
				gv.DeliverApp()
				echo "Deliver to ${REPO}"
				}
            }
        }
    }
}