node{
    def DOCKERHUB_REPO = "arif7866/weather-producer"
    def DOCKER_IMAGE_VERSION = ""

    stage("clean workspace") {
        deleteDir()
    }

    stage("git checkout") {
        checkout scm

        def GIT_COMMIT = sh(returnStdout: true, script: "git rev-parse HEAD").trim().take(7)
        DOCKER_IMAGE_VERSION = "${BUILD_NUMBER}-${GIT_COMMIT}"
    }
   stage('Build Docker Image'){
        sh "docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_VERSION} ."
   }
   stage('Push Docker Image'){
       withDockerRegistry(credentialsId: 'dockerhub') {
                 sh "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_VERSION}"
             }
   }
   stage('Run Container on Server'){
   try{
    sh "docker rm -f WeatherProducer || true "
    sh "docker run --env-file /prop.env -p 8080:8080 -d --name WeatherProducer ${DOCKERHUB_REPO}:${DOCKER_IMAGE_VERSION}"
   }
    catch (e) {
               error "Service update failed"
           }
      }
}