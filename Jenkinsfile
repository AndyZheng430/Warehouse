pipeline {
    agent any

    stages{
        stage('Build Frontend'){
            steps{
                sh "echo Building frontend"
                sh "cd frontend && npm install && npm run build"
                withSonarQubeEnv('SonarCloud') {
                    ...
                    npx sonar-scanner \
                    -Dsonar.projectKey=andyzheng430_warehouse-frontend \
                    -Dsonar.projectName=warehouse-frontend \
                    -Dsonar.sources=src \
                    -Dsonar.exclusions=**/__tests__/**,src/test/** \
                    -Dsonar.javascript.lcov.reportPaths=coverage/lcov.info
                    ...
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
                sh "cd backend && mvn clean install && ls target/"
                withSonarQubeEnv('SonarCloud') {
                sh '''
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
                sh "cd backend && mvn test"
            }
        }
        stage('Deploy Backend'){
            steps{
                script{
                  withAWS(region: 'us-east-1', credentials: 'AWS_CREDENTIALS'){
                        sh 'pwd'
                        sh "aws s3 cp backend/target/backend-0.0.1-SNAPSHOT.jar s3://team8-backend "
                        sh  'aws elasticbeanstalk create-application-version --application-name team8-backend --version-label 0.0.6 --source-bundle S3Bucket=\"team8-backend\",S3Key=\"backend-0.0.1-SNAPSHOT.jar\"'
                        sh  'aws elasticbeanstalk update-environment --environment-name Team8-backend-env --version-label 1.0.4'
                    }  
                }   
            }
        }
    }
}