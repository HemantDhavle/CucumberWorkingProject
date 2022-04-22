pipeline{
    agent any
    tools
    {
    	maven 'maven'
    }
    
    stages{
        stage("Regression Automation Tests")
        {
            steps
            {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
                {
    				git 'https://github.com/HemantDhavle/CucumberWorkingProject.git'
    				sh "mvn clean install"	
    
				}
            }
        }
       }
     }