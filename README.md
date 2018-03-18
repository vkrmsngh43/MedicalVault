# PEMedicalApp
This is a service which manages (Keeps and Secures) the medical and prescription records of a patient. A doctor or a pharmacist has to request access to view a medical record or prescription of a patient.

## Working Flow 
There are three types of application users i.e. PATIENT, DOCTOR and PHARMACIST. A doctor can access the medical records of a patient iff the patient approves the access request. A pharmacist can access the prescription records of a patient iff the patient approves the access request. A doctor and a pharmacist can place an access request via a secured API (accessible to the user with pre-determined roles) to view prescription records and medcial records respectively. The same API would send a TAC to the concerned patient's registered phone number. The patient has to share the same TAC with the doctor or the pharmacist to grant access to his/her private records. The TAC would only live for 10 Minutes.

## Technology Used
Java and spring boot framework.

## Setting up the application
```
1. Java 1.7 or higher, Maven as build tool.
2. Install Mysql. Create a DB named PE_Medical. Create a user root with pwd root
3. Import the schema from src/main/jave/com/pe/medical/docs/PE_Medical.sql to the DB created in previous step.
```
## To Build
```
. mvn clean install 
. to skip tests :  mvn -DskipTests=true clean install
```
## To Deploy
```
. java -jar -Dserver.port={#port} -Dspring.profiles.active={default/prod} PEMedicalApp-0.0.1-SNAPSHOT.jar
NOTE : in absence of run time parameters default profile which is 'default' and default port number which is '8080'
would be used.
```
