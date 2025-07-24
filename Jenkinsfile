pipeline {
  agent any

  stages {
    stage('Build Jar') {
      steps {
         sh "mvn clean package -DskipTests"
      }
    }

    stage('Docker Login') {

    }

    stage('Build Image') {
      steps {
        sh "docker build -t=krisuchotu/selenium ."
      }
    }

    stage('Push Image') {
      environment{
        SERVICE_CREDS = credentials('dokerhub-creds')
      }
      steps {
        sh "docker login -u ${SERVICE_CREDS_USR} -p ${SERVICE_CREDS_PSW}"
        sh "docker push krisuchotu/selenium"
      }
    }
  }
}
