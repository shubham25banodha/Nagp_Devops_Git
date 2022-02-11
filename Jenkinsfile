node{
    stage('Git Checkout'){
        git 'https://github.com/shubham25banodha/Nagp_Devops_Git.git'
    }
    stage('Build'){
        bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=NAGP_Devops_Pipeline_Assignment -Dsonar.host.url=http://localhost:9000 -Dsonar.login=ce3780bb3251d9f904e11387713b6b53a5cdbea1'
    }
}