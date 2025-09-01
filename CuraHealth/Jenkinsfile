pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/backupnow/SQA_JAVA_PROGRAMMING.git'
            }
        }

        stage('Build & Test') {
            steps {
                dir('CuraHealth') {
                    bat 'mvn clean test'
                }
            }
        }

        stage('Publish Reports') {
            steps {
                dir('CuraHealth') {
                    publishHTML(target: [
                        reportDir: 'target/ExtentReports',
                        reportFiles: 'Spark.html',
                        reportName: 'Extent Report'
                    ])
                }
            }
        }
    }

    post {
        always {
            dir('CuraHealth') {
                archiveArtifacts artifacts: 'target/ExtentReports/**', fingerprint: true
            }
        }
    }
}
