node{
    stage('Git Checkout'){
        git 'https://github.com/shubham25banodha/Nagp_Devops_Git.git'
    }
    stage('Build'){
        bat 'mvn clean verify sonar:sonar  -Dsonar.projectKey=NAGP_Devops_Pipeline -Dsonar.host.url=http://localhost:9000 -Dsonar.login=2eda0fff7332e8d5fdb5d5efc16c33f63f2ca8cf'
    }
}