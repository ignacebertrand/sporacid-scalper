@ECHO OFF
SET dbname="SPORACID"
SET host="localhost"
SET username="postgres"
SET password="Tabarnak!"
SET port=5432
SET pgShell="C:\Program Files\PostgreSQL\9.2\bin\psql.exe"

:WhileInvalidDecision
REM  // Clear screen and read user input
CLS
ECHO -- Database Manager (Sporacid studios 2013) --
ECHO.
ECHO    	1- Build Sporacid Database
ECHO    	2- Teardown Sporacid Database
ECHO    	3- Cleanup Sporacid Database
ECHO    	0- Quit
ECHO.
ECHO.
SET /p decision="Choose an option: "
ECHO. 

REM	 // User input validation
IF %decision%==1 GOTO :Build
IF %decision%==2 GOTO :Destroy
IF %decision%==3 GOTO :Cleanup
IF %decision%==0 (
	GOTO :Finally
) ELSE (
	GOTO :WhileInvalidDecision
)

:Build
ECHO Building the database
%pgShell% -q -h %host% -U %username% -d %dbname% -p %port% -f ./DDL_create_sequences.sql
%pgShell% -q -h %host% -U %username% -d %dbname% -p %port% -f ./DDL_create_tables.sql
ECHO Database built
GOTO :Finally

:Destroy
ECHO Destroying the database
%pgShell% -q -h %host% -U %username% -d %dbname% -p %port% -f ./DDL_drop_tables.sql
%pgShell% -q -h %host% -U %username% -d %dbname% -p %port% -f ./DDL_drop_sequences.sql
ECHO Database destroyed
GOTO :Finally

:Cleanup
ECHO Cleaning the database tables
%pgShell% -q -h %host% -U %username% -d %dbname% -p %port% -f ".\DML_cleanup_db.sql"
ECHO Database tables cleaned
GOTO :Finally

:Finally
ECHO.
PAUSE