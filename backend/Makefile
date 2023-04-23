docker-build-run:
	#git commit -am "Commit from Makefile"
	git pull --rebase
	mvn clean install package -DskipTests
	chmod +x scripts/*
	./scripts/docker_build.sh
	./scripts/build-chat.sh
	chmod -x scripts/*
	docker build modules/chat-application/
	docker build modules/chat-application/ -t modules/chat-application
	#docker build . -t pitchit/frontend
	#cd ../backend/
	docker-compose -f modules/chat-application/docker-compose.yml up -d
	docker-compose up --remove-orphans -d

port:
	xterm -e ssh -R 3000:127.0.0.1:3000 root@pitchitltd.co.uk &
	xterm -e ssh -R 8017:127.0.0.1:8017 root@pitchitltd.co.uk &
	xterm -e ssh -R 8018:127.0.0.1:8018 root@pitchitltd.co.uk &
	xterm -e ssh -R 8081:127.0.0.1:8081 root@pitchitltd.co.uk &
	xterm -e ssh -R 80:127.0.0.1:80 root@pitchitltd.co.uk &

kill: 
	lsof -ti tcp:80 | xargs kill
	lsof -ti tcp:8081 | xargs kill
	lsof -ti tcp:8017 | xargs kill
	lsof -ti tcp:8018 | xargs kill
	lsof -ti tcp:3000 | xargs kill