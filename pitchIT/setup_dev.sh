sudo lsof -ti tcp:5432 | xargs kill
sudo chown $USER /var/run/docker.sock
sudo systemctl enable docker
sudo systemctl restart docker
sudo docker ps -aq | sudo xargs docker stop | xargs docker rm
sudo docker system prune -a
sudo docker images -a | grep "pattern" | awk '{print $3}' | xargs docker rmi


# psql template1
#postgres=# CREATE DATABASE pitchIt;
#postgres=# CREATE USER dev;
#alter user dev with encrypted password 'dev';
#postgres=# GRANT ALL PRIVILEGES ON DATABASE pitchIt TO dev;

