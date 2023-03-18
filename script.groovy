def buildImage() {
    echo 'Building Docker image'
    withCredentials([usernamePassword(credentialsId: 'bamchaarJenkinsKey', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
		sh 'export DOCKER_HOST=unix:///var/run/docker.sock'
        sh 'docker build -t bamchaar/my-app:java-mvn-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push bamchaar/my-app:java-mvn-2.0'
    }
}
def buildJar() {
    echo 'Build mvnApp application'
    echo "Build version ${NEW_VERSION}"
    sh'mvn package'
}
def TestApp(){
    echo 'Testing stage'
}
def DeployApp(){
    echo 'Deploying stage'
}
def DeliverApp(){
    echo 'Deliver stage' 
    echo "Deploying version ${params.version}"
}
return this
