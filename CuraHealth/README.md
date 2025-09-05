# Run Project : mvn clean test

## 🧪 How To Run Automation test Locally :

1. Clone Repository from github : 
- git clone : https://github.com/backupnow/SQA_JAVA_PROGRAMMING/tree/master/CuraHealth

2. Local Environment Preparation
- Java JDK11+
- Maven
- FireFox Browser
- IDE (VSCode / IntelliJ)
- Internet Aktif

3. Konfiguration Project (tersedia)
- pom.xml
- Selenium WebDriver
- Cucumber Java & TestNG
- Extent Report Adapter

4. Run The Test :  
- mvn clean test

5. Check The Report Results : 
- HTML Modern
- HTML Legacy
- PDF
- Screenshot

### Cara Konfigurasi Jenkins :
1. Preparation
- Install jenkins
- Open in browser with > http://localhost:8080/
- Go to Manage > Tools to set up Installation & Configuration: JDK & Maven
- Go to Manage > Plugins & Install: Cucumber reports, HTML Publisher, Maven Integration.

2. Create New Item
- set Name item : Cura_Healthcare
- Choose : Maven Project
- Click OK

3. Configure
- Description (Optional)

- set the build according to your project path, example : 
    Root POM : C:\Users\HP\Juara Coding\VSCODE\CuraHealth\pom.xml
    Goals & Option : clean test
    checklis use custom workspace : C:\Users\HP\Juara Coding\VSCODE\CuraHealth

- set Post-buil Actions according to your project path :
    Cucumber reports├── JSON Reports Path : target/cucumber-reporting
                    ├── File Include Pattern : **/*.json

    Publish HTML reports├── HTML directory to archive : target/ExtentReports
                        ├── Index page[s] : Spark.html

- Click Save, Run > Build Now

4. Continuous Integration (CI) dengan Jenkins untuk menjalankan build.
- jenkinsfile (done) 
-----------------------------------

#### 🛠️ Technologies Used :

- Java: Main programming language

- Selenium WebDriver: Browser automation

- Cucumber: BDD (Behavior Driven Development) framework

- TestNG: Test runner

- Jenkins : CI tool to automate test execution and generate HTML reports

- Extent Report: Test results report in HTML, PDFReport & Screenshot format.