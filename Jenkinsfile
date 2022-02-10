node{
    stage('Git Checkout'){
        git 'https://github.com/shubham25banodha/Nagp_Devops_Git.git'
    }
    stage('Execute'){
        bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=NAGP_Pipeline -Dsonar.host.url=http://localhost:9000 -Dsonar.login=2445359b5b4dfcb6f990d3778bcbb336cc8a7a01'
    }
}