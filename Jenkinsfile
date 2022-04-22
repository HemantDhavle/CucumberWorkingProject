pipeline 
{
    agent any
    
    tools{
    	maven 'maven'
        }

    stages 
    {
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/HemantDhavle/CucumberWorkingProject.git'
                    bat "mvn clean install"
                }
            }
        }
        
        stage('Gmail'){
			steps
					{
	emailext body: "*${currentBuild.currentResult}:* Job Name: 
                ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More 
                information at: ${env.BUILD_URL}",
		subject: 'Declarative Pipeline Build Status',
		to: 'Pavankrishnan1993@gmail.com'
	}
}
    }
    }