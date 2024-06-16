pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
    }
    environment {
        AWS_S3_BUCKET = "${AWS_S3_BUCKET}"
        AWS_STACK_AUTO = "${AWS_STACK_AUTO}"
        AWS_REGION = "${AWS_REGION}"
        AWS_ACCESS_KEY = "${AWS_ACCESS_KEY}"
        AWS_SECRET_KEY = "${AWS_SECRET_KEY}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Set Permissions') {
            steps {
                script {
                    sh 'chmod +x ./gradlew'
                }
            }
        }
        stage('Install Dependencies') {
            steps {
                script {
                    sh './gradlew build'
                }
            }
        }
        stage('Build And Deploy') {
            steps {
                script {
                    def jarPath = sh(returnStdout: true, script: 'echo `pwd`').trim() + '/build/libs/ios_project_final-0.0.1-SNAPSHOT.jar'
                    sh """
                    java -jar \\
                    -DAWS_ACCESS_KEY=\${AWS_ACCESS_KEY} \\
                    -DAWS_SECRET_KEY=\${AWS_SECRET_KEY} \\
                    -DAWS_REGION=\${AWS_REGION} \\
                    -DAWS_STACK_AUTO=\${AWS_STACK_AUTO} \\
                    -DAWS_S3_BUCKET=\${AWS_S3_BUCKET} \\
                    ${jarPath}
                    """
                }
            }
        }
    }
}
