pipeline {
    agent any
    tools{
    maven 'mvn-3.9'
    }
    stages {
        stage('Build jar') {
            steps {
				script{
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
				sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
				sh 'docker push tcdmv/mvn-app:java-mvn-2.0'
				}
				}
            }
        }        
    }
}