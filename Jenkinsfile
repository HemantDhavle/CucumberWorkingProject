pipeline{
    agent any
    tools
    {
    	maven 'MAVEN_HOME'
    }
    
    stages{
        stage("Regression Automation Tests")
        {
            steps
            {
                
    				git 'https://github.com/HemantDhavle/CucumberWorkingProject.git'
    				sh "mvn clean install"	
    
				}
            
        }
       }
     }