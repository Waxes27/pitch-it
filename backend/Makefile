docker-build-run:
	git pull --rebase
	mvn clean install package -DskipTests
	chmod +x scripts/*
	./scripts/docker_build.sh
	./scripts/build-chat.sh
	chmod -x scripts/*
	docker-compose -f modules/chat-application/docker-compose.yml up -d
	docker-compose up --remove-orphans -d
	xterm -e ssh -R 3000:127.0.0.1:3000 root@pitchitltd.co.uk &
	xterm -e ssh -R 8017:127.0.0.1:8017 root@pitchitltd.co.uk &
	xterm -e ssh -R 8018:127.0.0.1:8018 root@pitchitltd.co.uk &
	xterm -e ssh -R 8081:127.0.0.1:8081 root@pitchitltd.co.uk &
	# xterm -e ssh -R 10001:127.0.0.1:10001 root@pitchitltd.co.uk &
	#mvn test
