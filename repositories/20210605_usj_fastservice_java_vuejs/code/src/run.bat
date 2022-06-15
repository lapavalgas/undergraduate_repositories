SET BASEDIR=%~dp0
CD BASEDIR
START /min docker-compose up   
TIMEOUT 120 
PAUSE
START http://localhost:8082/