pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'maven-docker-demo'
        GIT_REPO_URL = 'https://github.com/SathishKumar5115/DevOpsLabFinal.git'
    }

    triggers {
        pollSCM('*/5 * * * *') // Poll Git every 5 minutes
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: env.GIT_REPO_URL
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build(env.DOCKER_IMAGE)
                }
            }
        }

        stage('Run Maven Build') {
            steps {
                script {
                    docker.image(env.DOCKER_IMAGE).inside {
                        sh 'mvn clean compile test package'
                    }
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            // Clean up Docker images
            script {
                sh "docker rmi ${env.DOCKER_IMAGE} || true"
            }

            // Publish test results
            junit '**/target/surefire-reports/*.xml'
        }
    }
}