def BuildJar(){
    echo 'Build mvnApp application'
    echo "Build version ${NEW_VERSION}"
    sh'mvn package'
}
def BuildImage(){
    echo 'Build Docker image'
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