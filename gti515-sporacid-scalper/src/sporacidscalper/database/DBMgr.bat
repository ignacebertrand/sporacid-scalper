@ECHO OFF
SET host="142.137.247.24"
SET username="postgres"
SET password="Tabarnak!"
SET port=5432
SET pgShell="\\evolution.etsmtl.ca\C$\Program Files\PostgreSQL\9.2\bin\psql.exe"

:DisplayMenu
REM  // Clear screen and read user input
CLS
ECHO -- Database Manager (Sporacid studios 2013) --
ECHO.
ECHO  1- Build Tables
ECHO  2- Teardown Tables
ECHO  3- Cleanup Database
ECHO  4- Dataload Database
ECHO  5- Create Database
ECHO  6- Drop Database  
ECHO  0- Quit
ECHO.
ECHO.
SET /p decision="Choose an option: "
IF NOT %decision%==0 SET /p dbname="Enter the database name: "
ECHO. 

REM	 // User input validation
IF %decision%==1 GOTO :Build
IF %decision%==2 GOTO :Destroy
IF %decision%==3 GOTO :Cleanup
IF %decision%==4 GOTO :Dataload
IF %decision%==5 GOTO :Create
IF %decision%==6 GOTO :Drop
IF %decision%==0 (
	GOTO :Finally
) ELSE (
	GOTO :DisplayMenu
)

:Build
ECHO Building %dbname% ...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -f ./build_database.sql
ECHO.
ECHO Database built!
PAUSE
GOTO :DisplayMenu

:Destroy
ECHO Destroying %dbname%...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -f ./destroy_database.sql
ECHO.
ECHO Database destroyed!
PAUSE
GOTO :DisplayMenu

:Cleanup
ECHO Cleaning %dbname% tables...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -P %password% -f ./DML/DML_cleanup_db.sql
ECHO.
ECHO Database tables cleaned!
PAUSE
GOTO :DisplayMenu

:Dataload
ECHO Dataloading %dbname% tables...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -f ./DML/DML_inserts.sql
ECHO.
ECHO Database tables dataloaded!
PAUSE
GOTO :DisplayMenu

:Create
ECHO Creating %dbname%...
ECHO CREATE DATABASE %dbname%; > temp_create_database.sql
%pgShell% -h %host% -U %username% -d "postgres" -p %port%  -f ./temp_create_database.sql
DEL .\temp_create_database.sql
ECHO.
ECHO %dbname% created!
PAUSE
GOTO :DisplayMenu

:Drop
ECHO Dropping %dbname%...
ECHO DROP DATABASE %dbname%; > temp_drop_database.sql
%pgShell% -h %host% -U %username% -d "postgres" -p %port% -f ./temp_drop_database.sql
DEL .\temp_drop_database.sql
ECHO.
ECHO %dbname% dropped!
PAUSE
GOTO :DisplayMenu

:Finally
ECHO Application will terminate
PAUSE