pipeline {
    agent any
    stages {
        stage('Send Gmail') {
            steps {
                sh '''
                    echo "Subject: Jenkins Test Email" > mail.txt
                    echo "Hello from Jenkins Pipeline using msmtp!" >> mail.txt
                    msmtp -a gmail sombranojosh@gmail.com < mail.txt
                '''
            }
        }
    }
}
