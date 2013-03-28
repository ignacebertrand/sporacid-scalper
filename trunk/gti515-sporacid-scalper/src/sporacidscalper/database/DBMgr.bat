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
ECHO    	1- Build Database
ECHO    	2- Teardown Database
ECHO    	3- Cleanup Database
ECHO    	4- Dataload Database
ECHO    	0- Quit
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
IF %decision%==0 (
	GOTO :Finally
) ELSE (
	GOTO :DisplayMenu
)

:Build
ECHO Building the database...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -f ./build_database.sql
ECHO Database built!
PAUSE
GOTO :DisplayMenu

:Destroy
ECHO Destroying the database...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -f ./destroy_database.sql
ECHO Database destroyed!
PAUSE
GOTO :DisplayMenu

:Cleanup
ECHO Cleaning the database tables...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -P %password% -f ./DML/DML_cleanup_db.sql
ECHO Database tables cleaned!
PAUSE
GOTO :DisplayMenu

:Dataload
ECHO Dataloading the database tables...
%pgShell% -h %host% -U %username% -d %dbname% -p %port% -f ./DML/DML_inserts.sql
ECHO Database tables dataloaded!
PAUSE
GOTO :DisplayMenu

:Finally
ECHO Application will terminate
PAUSE