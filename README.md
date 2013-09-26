NoSQL_ORM_Framework
===================

ORM framework for NoSQL Database, like OGM(Object Grid Mapper), to manage sessions and object to java entity mapping

Here are some configuration need to done before implmentation, create a .bat file under project repo and

ECHO OFF
 
REM =============================
REM Set the env. variables.
REM =============================

SET PATH=%PATH%;C:\apache-maven-3.1.0\bin;

SET JAVA_HOME=C:\Program Files\Java\jdk1.6.0_01

REM =============================
REM Create a simple java application.
REM =============================
call mvn archetype:create ^
-DarchetypeGroupId=org.apache.maven.archetypes ^
-DgroupId=org.academy ^
-DartifactId=dbLayer002

pause


use command

mvn clean install

to build the project.

Thanks,
Amol
