@echo off
 echo ================================================================================
 echo �鿴�������� ��
 echo 	JAVA_HOME=%JAVA_HOME%
 echo 	M2_HOME/MAVEN_HOME=%M2_HOME%%MAVEN_HOME%
 echo/
 echo ------------- 
 echo ��ǰ·�� ��
 echo 	%CD%
 echo/
 echo ================================================================================


echo ������������ע���뷢�������Ĭ�϶˿ڣ�8761

start start-eureka.bat

echo --
TIMEOUT /T 10

start start-crawler.bat

start start-getway.bat

pause