node(label: 'master') {
    try {

   /* stage('Compile') {
     bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -f E:\\Users\\SARAN\\workspace\\Inventory\\pom.xml clean compile'
     echo 'Compile Completed'
    }*/
    
     stage('Compile and Unit Testing') {
        //bat 'xcopy C:\\Users\\SARAN\\Code\\mongoconndev\\Inventory.json  E:\\Users\\SARAN\\workspace\\Inventory\\target\\Inventory.json /s /y'
        bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -f E:\\Users\\SARAN\\workspace\\Inventory\\pom.xml clean test'
        echo 'Compile and Unit Test Completed'
    }

  /*  
    stage('Static Analysis') {
   bat 'xcopy E:\\Users\\SARAN\\workspace\\Inventory %WORKSPACE%\\ /s /y'
             withSonarQubeEnv('SonarQube_Home') {
             //bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -f E:\\Users\\SARAN\\workspace\\Inventory\\pom.xml sonar:sonar \
             bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -f ./pom.xml sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=94a5afcdac3bcf731bfa5467a0169fe806b31601' 
  
 // -Dsonar.cobol.copy.directories=/copy
  
  //bat 'xcopy E:\\Users\\SARAN\\workspace\\Inventory %WORKSPACE%\\ /s /y'
  //sleep(100)

     echo 'Static Analysis Completed'
        
             }
   }
    stage("Quality Gate"){
  
        timeout(time: 1, unit: 'HOURS') {
  //              waitForQualityGate abortPipeline: true
            def qg= waitForQualityGate()
            if (qg.status!= 'OK'){
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }         
              echo 'Quality Gate Passed'
  
    }
    */
 
    stage('Package') {
        bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -U -DskipTests -f E:\\Users\\SARAN\\workspace\\Inventory\\pom.xml clean package'
        echo 'Package Completed'
    }
   stage(' Preprod Deploy') {
        bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -U -DskipTests -f E:\\Users\\SARAN\\workspace\\Inventory\\pom.xml tomcat7:deploy -Dtomcat.username=tomcat1 -Dtomcat.password=s3cret'
        echo 'Deploy Completed'
    }
     stage('Integration Testing') {
        bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -f E:\\Users\\SARAN\\workspace\\Verify\\pom.xml clean integration-test'
        echo 'Integration Test Completed'
     }
    
    
    } catch(err) 
    {
        currentBuild.result = "FAILURE"
       step([$class: 'Mailer', notifyUnstableEveryBuild: true, recipients: 'saranitact@gmail.com', sendToIndividuals: true])
        throw err
     }
    } 