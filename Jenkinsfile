pipeline{
    agent none
    
    stages{
        stage("Build")
        {
            steps
            {
                echo("build the project")
            }
        }
        stage("UnitTesting")
        {
            steps
            {
                echo("Do the unit testing")
            }
        }
        stage("SIT")
        {
            steps
            {
                echo("Perform SIT")
            }
        }
        
         stage("UAT")
        {
            steps
            {
                echo("Perform UAT")
            }
        }
        
         stage("Prod Release")
        {
            steps
            {
                echo("Release the build on production")
            }
        }
         stage("Prod1 Release")
        {
            steps
            {
                echo("Release the build on production")
            }
        }
    }
}