pipeline {
    agent any

    stages{
        stage('Build Frontend'){
            steps{
                sh "echo Building frontend"
                sh "cd frontend && npm install && npm run build"
                
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
                        sh "aws s3 cp backend/target/backend-1.0-SNAPSHOT.jar s3://team8-backend "
                        sh  'aws elasticbeanstalk create-application-version --application-name team8-backend --version-label 0.0.1 --source-bundle S3Bucket=\"team8-backend\",S3Key=\"backend-1.0-SNAPSHOT.jar\"'
                        sh  'aws elasticbeanstalk update-environment --environment-name Team8-backend-env --version-label 0.0.5'
                    }  
                }   
            }
        }
    }
}