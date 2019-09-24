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
    stage('Package') {
        bat 'E:\\Users\\SARAN\\Downloads\\apache-maven-3.5.3-bin\\apache-maven-3.5.3\\bin\\mvn -U -DskipTests -f E:\\Users\\SARAN\\workspace\\Inventory\\pom.xml clean package'
        echo 'Package Completed'
        input message: "Do you want to move forward with Integration testing?"
        echo 'Approval has been done. Moving to the next stage.'
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
