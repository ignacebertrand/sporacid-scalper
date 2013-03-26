
set SP = "C:\Program Files\SQLPlus\SQLPlus.exe"
set JM = "C:\Program Files\Java\java.exe"

rem -- Starting Script --

%SP% -L equipe3/7N6Pvkha@oracle-11.logti.etsmtl.ca @{create_tables.sql}

%SP% -L equipe3/7N6Pvkha@oracle-11.logti.etsmtl.ca @{create_sequences.sql}

%JM% -jar LectureBD.jar

%SP% -L equipe3/7N6Pvkha@oracle-11.logti.etsmtl.ca @{create_triggers.sql}

%SP% -L equipe3/7N6Pvkha@oracle-11.logti.etsmtl.ca @{create_constraints.sql}

PAUSE
rem -- End --
