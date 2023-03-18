def buildImage() {
    echo 'Building Docker image'
    withCredentials([usernamePassword(credentialsId: 'tcdmvkey', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t tcdmv/my-app:java-mvn-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push tcdmv/my-app:java-mvn-2.0'
    }
}
def buildJar() {
    echo 'Build mvnApp application'
    echo "Build version ${NEW_VERSION}"
    sh'mvn clean package'
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
