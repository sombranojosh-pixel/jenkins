pipeline {
    agent any
    triggers{
        cron('* * * * *')
    }
    stages {
        stage('Send Gmail via msmtp') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'gmail-smtp', usernameVariable: 'SMTP_USER', passwordVariable: 'SMTP_PASS')]) {
                    sh '''
                        # Create a temporary msmtp config file
                        cat > ~/.msmtprc <<EOF
defaults
auth on
tls on
tls_trust_file /etc/ssl/certs/ca-certificates.crt

account gmail
host smtp.gmail.com
port 587
from grapejuiceblues2@gmail.com
user grapejuiceblues2@gmail.com
password uump dnyt daiv hbjw

account default : gmail
EOF

                        chmod 600 ~/.msmtprc

                        # Send the email
                        echo "Subject: Jenkins Test Email" > mail.txt
                        echo "This is a test email from Jenkins Pipeline using msmtp credentials." >> mail.txt
                        /usr/bin/msmtp -a gmail sombranojosh@gmail.com < mail.txt
                    '''
                }
            }
        }
    }
}



