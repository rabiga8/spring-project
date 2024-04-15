pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS_ID = '5aec70f1-576f-4bbf-8388-65b31ae0113c'
        DOCKER_IMAGE_NAME = 'rabiga8/rabiga_r_image'
    }
    stages {
        stage('1. Checkout') {
            steps {
                // Check out the source code from GitHub
                git 'https://github.com/rabiga8/devops-lab3.git'
                sh "git checkout jenkins"
            }
        }
        
        stage('2. Build Maven Project') {
            steps {
               withMaven(globalMavenSettingsConfig: '', jdk: '', maven: 'maven', mavenSettingsConfig: '', traceability: true) {
               sh 'mvn clean package'
              }
            }
        }
        
        stage('3. Docker Build') {
            steps {
                // Build Docker image
                sh 'docker build  -t ${DOCKER_IMAGE_NAME} .'
            }
        }
        
        stage('4. Docker Login') {
            steps {
                // Authenticate with Docker Hub using credentials
                withCredentials([
                    usernamePassword(
                        credentialsId: DOCKER_CREDENTIALS_ID, 
                        passwordVariable: 'DOCKER_PASSWORD', 
                        usernameVariable: 'DOCKER_USERNAME')]) {
                    sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                }
                
                // Build Docker image
                sh 'docker build  -t ${DOCKER_IMAGE_NAME} .'
                
                // Tag the Docker image with Docker Hub repository name
                sh 'docker tag rabiga8/rabiga_r_image rabiga8/rabiga_r_image:latest'
            }
        }
        
        stage('5. Docker Push') {
            steps {
                // Push Docker image to Docker Hub
                sh 'docker push rabiga8/rabiga_r_image:latest'
            }
        }
    }
}
