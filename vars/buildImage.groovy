#!/user/bin/env groovy

def call() {
    echo "building the docker image ..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
    sh 'docker build -t ilo2003/testing:jma-2.0 .'
    sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
    sh 'docker push ilo2003/testing:jma-2.0'
    }
}
