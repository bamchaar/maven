def BuildApp(){
    echo 'Build stage'
    echo "Build version ${NEW_VERSION}"
    sh 'mvn -v'
}
def TestApp(){
    echo 'Testing stage'
}
def DeliverApp(){
    echo 'Deliver stage' 
    echo "Deploying version ${params.version}"
}
return this