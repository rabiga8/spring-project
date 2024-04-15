pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS_ID = '5aec70f1-576f-4bbf-8388-65b31ae0113c'
        DOCKER_IMAGE_NAME = 'rabiga8/group-image'
    }
    stages {
        stage('1. Checkout') {
            steps {
                // Check out the source code from GitHub
                sh "git clone https://github.com/rabiga8/spring-project.git"
                sh "git checkout main"
            }
        }

        stage('2. Test') {
            steps {
                withMaven(globalMavenSettingsConfig: '', 
                         jdk: '', maven: 'maven', 
                         mavenSettingsConfig: '', 
                         traceability: true) {
                // Add a step for your project's build tool (e.g., Maven)
                sh 'mvn test'
                }
            }
        }

        stage('Verify') {
            steps {
                withMaven(globalMavenSettingsConfig: '', 
                         jdk: '', maven: 'maven', 
                         mavenSettingsConfig: '', 
                         traceability: true) {
                    
                // Add a step for your project's build tool (e.g., Maven)
                // Run tests with JaCoCo code coverage
                sh 'mvn clean verify'
                }
            }
        }

        stage('Static Analysis Checkstyle') {
            steps {
                withMaven(globalMavenSettingsConfig: '', 
                         jdk: '', maven: 'maven', 
                         mavenSettingsConfig: '', 
                         traceability: true) {
                    
                // Run Checkstyle
                sh 'mvn checkstyle:checkstyle'
                }
            }
        }
        
        stage('3. Build Maven Project') {
            steps {
               withMaven(globalMavenSettingsConfig: '', 
                         jdk: '', maven: 'maven', 
                         mavenSettingsConfig: '', 
                         traceability: true) {
               sh 'mvn clean package'
              }
            }
        }
        
        stage('4. Build Docker Image') {
            steps {
                // Build Docker image
                sh 'docker build  -t ${DOCKER_IMAGE_NAME} .'
            }
        }
        
        stage('5. Dockerhub Login') {
            steps {
                // Authenticate with Docker Hub using credentials
                withCredentials([
                    usernamePassword(
                        credentialsId: DOCKER_CREDENTIALS_ID, 
                        passwordVariable: 'DOCKER_PASSWORD', 
                        usernameVariable: 'DOCKER_USERNAME')]) {
                    sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                }
                
                // Build Docker image again
                sh 'docker build  -t ${DOCKER_IMAGE_NAME} .'
                
                // Tag the Docker image with Docker Hub repository name
                sh 'docker tag rabiga8/group-image rabiga8/group-image:latest'
            }
        }
        
        stage('6. Dockerhub Push') {
            steps {
                // Push Docker image to Docker Hub
                sh 'docker push rabiga8/group-image:latest'
            }
        }
    }
}
