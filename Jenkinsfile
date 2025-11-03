pipeline {
    agent any
    // triggers{
    //     cron('* * * * *')
    // }
    parameters{
        string(defaultValue: "Scheduled send", description: "Enter subject", name: "enterSubject")
        string(defaultValue: "Pre-made text", description: "Enter message", name: "enterMessage")
        string(defaultValue: "sombranojosh@gmail.com", description: "Enter email receiver", name: "enterEmail")
    }
    environment{
        subject = "${params.enterSubject}"
        message = "${params.enterMessage}"
        email = "${params.enterEmail}"
    }
    stages {
        stage('Mail Sender') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'gmail-smtp', usernameVariable: 'SMTP_USER', passwordVariable: 'SMTP_PASS')]) {
                    sh '''
                        cat > ~/.msmtprc <<EOF
defaults
auth on
tls on
tls_trust_file /etc/ssl/certs/ca-certificates.crt

account gmail
host smtp.gmail.com
port 587
from ${SMTP_USER}
user ${SMTP_USER}
password ${SMTP_PASS}

account default : gmail
EOF

                        chmod 600 ~/.msmtprc

                        echo "Subject: $subject" > mail.txt
                        echo "$message" >> mail.txt
                        /usr/bin/msmtp -a gmail $email < mail.txt
                    '''
                }
            }
        }
    }
}














