set APP_NAME=ETU003180
set SRC_DIR=src\main\java\com\itu\Servlet
set BUILD=build
set LIB=src\main\webapp\WEB-INF\lib
set TOMCAT_WEBAPP=c:\Users\fenohasina\Desktop\tomcat\webappS
set WEBAPP=src\main\webapp
@REM verifier si build existe deja 
if exist "%BUILD%" (
    rmdir /S /Q "%BUILD%"
)
@REM apres check cree build
mkdir "%BUILD%"
@REM compilation
javac -d "%WEBAPP%"\WEB-INF\classes -cp .:src\main\webapp\WEB-INF\lib\postgresql-42.7.4.jar;src\main\webapp\WEB-INF\lib\jakarta.servlet-api-5.0.0.jar;src\main\webapp\WEB-INF\lib\mysql-connector-j-9.0.0.jar %SRC_DIR%\*.java
@REM copier tout les dossiers et fichiers de webapp dans buld.WEB-INF
xcopy /S "%WEBAPP%"\*  "%BUILD%"
@REM JAR
jar -cvf  %APP_NAME%.war -C build . 
@REM cpie dans tomcat
xcopy /S %APP_NAME%.war "%TOMCAT_WEBAPP%"