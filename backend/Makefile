docker-build-run:
	git pull --rebase
	# mvn clean install package -DskipTests
	chmod +x scripts/*
	# ./scripts/docker_build.sh
	./scripts/build-chat.sh
	chmod -x scripts/*
	docker-compose -f modules/chat-application/docker-compose.yml up

	

	# docker-compose up --remove-orphans
	#mvn test
