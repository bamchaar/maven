def BuildJar(){
    echo 'Build mvnApp application'
    echo "Build version ${NEW_VERSION}"
    sh'mvn package'
}
def BuildImage(){
    echo 'Building Docker image'
	withCredentials([usernamePassword(credentialsId: 'tcdmvPipeLine',passwordVariable: 'PASS' , usernameVariable: 'USER')]){
	sh 'docker build -t tcdmv/mvn-app:java-mvn-2.0 .'
	sh "echo $PASS | docker login -u $USER --password-stdin"
	sh 'docker push tcdmv/mvn-app:java-mvn-2.0'
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
