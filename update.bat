@echo off
timeout /t 2 /nobreak > nul
del "proyecto_gm.jar"
ren "proyecto_gm_update.jar" "proyecto_gm.jar"
start proyecto_gm.exe
exit