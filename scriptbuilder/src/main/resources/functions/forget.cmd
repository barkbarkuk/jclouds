:forget
   SETLOCAL
   set FOUND_PID=
   set NEXT_MINUTE=
   set INSTANCE_NAME=%1
   shift
   set SCRIPT=%1
   shift
   set LOG_DIR=%1
   shift
   CALL :findProcess %INSTANCE_NAME%
   if defined FOUND_PID (
      echo %INSTANCE_NAME% already running pid [%FOUND_PID%]
   ) else (
      CALL :nextMinute
      set _DATE=%DATE:~4%
      set CMD=schtasks /create /sd %_DATE% /tn %INSTANCE_NAME% /ru System /tr "cmd /c title %INSTANCE_NAME%&%SCRIPT% >%LOG_DIR%\stdout.log 2>%LOG_DIR%\stderr.log" /sc:once /st %NEXT_MINUTE%
      echo %INSTANCE_NAME% will start at %NEXT_MINUTE%
      set SECONDS=%TIME:~6,2%
      set /a SECOND=60-SECONDS
      %CMD% >NUL
      ping -n %SECONDS% 127.0.0.1 > NUL 2>&1
      CALL :findProcess %INSTANCE_NAME%
      if not defined FOUND_PID (
         set EXCEPTION=%INSTANCE_NAME% did not start
         abort
      )
   ) 
   exit /b 0
