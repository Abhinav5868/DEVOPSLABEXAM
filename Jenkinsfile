pipeline {
   agent any
   
   environment {
       DOCKER_CREDENTIALS_ID = 'dckr_pat_42KDt5-1GSG2jJJaomJWRE8Kk1w' // Replace with your Docker ID credentials
       DOCKER_USERNAME = 'abhinav5868'  // Replace with your Docker Hub username
   }
   
   stages {
       stage('Checkout') {
           steps {
               checkout scm
           }
       }
       
       stage('Build') {
           steps {
               sh 'mvn clean package -DskipTests'
           }
       }
       
       stage('Test') {
           steps {
               sh 'mvn test'
           }
       }
       
       stage('Build Docker Image') {
           steps {
               script {
                   docker.build("${DOCKER_USERNAME}/demo-app:latest")
               }
           }
       }
       
       stage('Push Docker Image') {
           steps {
               script {
                   docker.withRegistry('https://registry.hub.docker.com', ${DOCKER_CREDENTIALS_ID}) {
                       docker.image("${DOCKER_USERNAME}/demo-app:latest").push()
                   }
               }
           }
       }
       
       stage('Deploy') {
           steps {
               sh 'docker compose up -d'
           }
       }
   }
   
   
}
