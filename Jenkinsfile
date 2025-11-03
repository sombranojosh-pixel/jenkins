pipeline {
    agent any
    // triggers{
    //     cron('* * * * *')
    // }
    parameters{
        string(defaultValue: "Scheduled send", description: "Enter subject", name: "enterSubject")
        string(defaultValue: "Pre-made text", description: "Enter message", name: "enterMessage")
    }
    environment{
        subject = "${params.enterSubject}"
        message = "${params.enterMessage}"
    }
    stages {
        stage('Mail Sender') {
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
                        echo "Subject: $subject" > mail.txt
                        echo "$message" >> mail.txt
                        /usr/bin/msmtp -a gmail sombranojosh@gmail.com < mail.txt
                    '''
                }
            }
        }
    }
}











