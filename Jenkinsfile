pipeline {
    agent any
    
    stages{
        stage('Build Frontend'){
            steps{
                sh "echo Building frontend"
                sh "cd frontend && npm install && npm run build"
                sh "pwd"
                withSonarQubeEnv('SonarCloud') {
                    sh ''' 
                    cd frontend &&
                    npx sonar-scanner \
                    -Dsonar.projectKey=andyzheng430_warehouse-frontend \
                    -Dsonar.projectName=warehouse-frontend \
                    -Dsonar.sources=src \
                    -Dsonar.exclusions=**/__tests__/**\
                    -Dsonar.javascript.lcov.reportPaths=coverage/lcov.info
                    '''
                }
            }
        }
        stage('Test Frontend'){
            steps{
                sh "echo Building frontend"
                sh "cd frontend && npm run test:coverage"
                sh "pwd"
                withSonarQubeEnv('SonarCloud') {
                    sh ''' 
                    cd frontend &&
                    npx sonar-scanner \
                    -Dsonar.projectKey=andyzheng430_warehouse-frontend \
                    -Dsonar.projectName=warehouse-frontend \
                    -Dsonar.sources=src \
                    -Dsonar.exclusions=**/__tests__/**\
                    -Dsonar.javascript.lcov.reportPaths=coverage/lcov.info
                    '''
                }
            }
        }
        stage('Deploy Frontend'){
            steps{
                script{
                    try {
                      withAWS(region: 'us-east-1', credentials: 'AWS_CREDENTIALS'){
                        sh "aws s3 sync frontend/dist s3://team8-frontend" 
                        }
                    }catch (Exception e) {
                            echo "${e}"
                            throw e
                    }   
                }
            }
        }
        stage('Build Backend'){
            steps{
                 script{
                    withCredentials([
                    string(credentialsId: 'DB_USER', variable: 'DB_USER'),
                    string(credentialsId: 'DB_PASS', variable: 'DB_PASS'), 
                    string(credentialsId: 'DB_URL', variable: 'DB_URL')]){
                        //    dir('backend') {
                        //         sh(script: '''  
                        //     mvn spring-boot:run -Dspring-boot.run.arguments="--DB_URL=${DB_URL} --DB_USER=${DB_USER} --DB_PASS=${DB_PASS}" &
                        //     echo \$!
                        //         ''', returnStdout: true).trim()
                        //     }
                        
                  
                        sh "cd backend && mvn clean install && ls target/"
                    }
                 }
                withSonarQubeEnv('SonarCloud') {
                sh '''
                    cd backend &&
                     mvn sonar:sonar \
                     -Dsonar.projectKey=AndyZheng430_Warehouse \
                     -Dsonar.projectName=Warehouse_Backend \
                     -Dsonar.java.binaries=target/classes \
                     -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                     '''
                }
                 
            }
        }
        stage('Test Backend'){
            steps{
                script{
                    withCredentials([
                    string(credentialsId: 'DB_USER', variable: 'DB_USER'),
                    string(credentialsId: 'DB_PASS', variable: 'DB_PASS'), 
                    string(credentialsId: 'DB_URL', variable: 'DB_URL')]){
                        sh "cd backend && mvn test"
                    }
                }
            }
        }
        stage('Deploy Backend'){
            steps{
                script{
                    withCredentials([
                    string(credentialsId: 'DB_USER', variable: 'DB_USER'),
                    string(credentialsId: 'DB_PASS', variable: 'DB_PASS'), 
                    string(credentialsId: 'DB_URL', variable: 'DB_URL')]){
                        def build = env.BUILD_NUMBER.toInteger()
                        echo "version: ${build}"
                        withAWS(region: 'us-east-1', credentials: 'AWS_CREDENTIALS'){
                            sh 'pwd'
                            sh "cd backend && mvn clean package"
                            sh "aws s3 cp backend/target/backend-0.0.2-SNAPSHOT.jar s3://team8-backend"
                            sh """aws elasticbeanstalk create-application-version --application-name team8-backend --version-label 0.0.${build} --source-bundle S3Bucket=\"team8-backend\",S3Key=\"backend-0.0.2-SNAPSHOT.jar\""""
                            sh 'aws elasticbeanstalk update-environment --environment-name Team8-backend-env --version-label 1.0.4'
                        }
                    }  
                }   
            }
        }
        stage('Run JMeter Tests') {
            steps {
                sh '/opt/jmeter/bin/jmeter -n -t /opt/TestPlans/Test_Plan.jmx -l /opt/TestPlansTest.report.jtl'
            }
        }
    }
        post {
        always {
            performance publisher {
                sourceDataFiles('/opt/TestPlansTest.report.jtl')
            }
        }
        stage('Run JMeter Tests') {
            steps {
                sh '/opt/jmeter/bin/jmeter -n -t /opt/TestPlans/Test_Plan.jmx -l /opt/TestPlans/Test.report.jtl'
            }
        }
    }
        post {
            always {
                script {
                    perfReport sourceDataFiles('/opt/TestPlans/Test.report.jtl')
                }
            }
        }
}