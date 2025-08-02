pipeline {
    agent any
    environment {
        AWS_DEFAULT_REGION = 'ap-south-1'
        ECR_REPO = 'your-ecr-repo-id.in.dkr.ecr.ap-south-1.amazonaws.com/java-microservice-user'
        IMAGE_TAG = "latest"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t $ECR_REPO:$IMAGE_TAG .'
            }
        }
        stage('ECR Login') {
            steps {
                sh 'aws ecr get-login-password | docker login --username AWS --password-stdin $ECR_REPO'
            }
        }
        stage('Push Image') {
            steps {
                sh 'docker push $ECR_REPO:$IMAGE_TAG'
            }
        }
    }
}
