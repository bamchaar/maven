Skip to content
Search or jump to…
Pull requests
Issues
Codespaces
Marketplace
Explore
 
@bamchaar 
bamchaar
/
maven
Public
Fork your own copy of bamchaar/maven
Code
Issues
Pull requests
Projects
Wiki
Security
Insights
Settings
maven/Jenkinsfile
@bamchaar
bamchaar solved conflicts
Latest commit 922372d 3 minutes ago
 History
 1 contributor
109 lines (105 sloc)  2.27 KB

#!/usr/bin/env groovy

@Library('jenkins-shared-repo')

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
    	NEW_VERSION = '2.0'
    }
    stages {
    	stage("init"){
    	steps{
    		script{
    			gv = load "script.groovy"
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
        stage('Build jar') {
                	when{
        		expression{
        			BRANCH_NAME == 'master'
        		}
        	}
            steps {
				script{
				buildJar()
				}
            }
        }
        stage('Build image') {
                	when{
        		expression{
        			BRANCH_NAME == 'master'
        		}
        	}        
            steps {
				script{
				buildImage()
				}
				
            }
        }        
        
        stage('Deploy') {
                	when{
        		expression{
        			BRANCH_NAME == 'master'
        		}
        	}        
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
                	when{
        		expression{
        			BRANCH_NAME == 'master'
        		}
        	}        
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
Footer
© 2023 GitHub, Inc.
Footer navigation
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
maven/Jenkinsfile at master · bamchaar/maven
