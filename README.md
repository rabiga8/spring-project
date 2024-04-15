# Group-11 Project: DevOps Toolchain Integration

## Description
This project integrates various DevOps tools such as Git, GitHub, Docker Hub, Jenkins, and Azure DevOps to manage code, demonstrate teamwork using Agile Methodology, and deliver software through CI/CD pipelines.

## Group-11 Members
- [Rabiga Abdikerimova]

## Technologies Used
- Git
- GitHub
- Docker Hub
- Jenkins
- Azure DevOps

## Setup Instructions
1. Clone the repository: `https://github.com/rabiga8/spring-project.git`
2. Navigate to the project directory: `cd spring-project`

## Usage
1. Ensure all dependencies are installed and configured.
2. Run the necessary commands/scripts to initiate CI/CD pipelines.
3. Monitor pipeline statuses and project progress.
4. Refer to documentation for troubleshooting or additional features.

## CI/CD Pipelines
### Jenkins Pipeline
- Jenkins CI/CD pipeline is defined in the `Jenkinsfile` located in the root of the repository.
- The pipeline is triggered by changes in the GitHub repository.
- Stages include:
  - Checkout
  - Test
  - Code coverage analysis
  - Code static analysis
  - Build Maven Project
  - Build Docker Image
  - Dockerhub Login
  - Dockerhub Push

- View the pipeline status and history in Jenkins Blue Ocean UI.

### Azure DevOps Pipeline
- Azure DevOps CI/CD pipeline is defined in the `azure-pipeline.yaml` located in the GitHub repository.
- The pipeline is triggered by changes in the GitHub repository.
- Stages include:
  - Build
  - Test
  - Code coverage analysis
  - Code static analysis
  - Deliver (for Continuous Delivery)
  - Deployment to Development, QA, Staging, and Production environments (if applicable).
- View the pipeline status and history in Azure DevOps UI.

## Issues and Tasks
- GitHub Issues and Azure DevOps Boards are utilized for issue and task management.
- Work items are documented in Azure DevOps Board with assignments and progress tracking.
- Each work item goes through stages of ToDo, Doing, and Done.

  
