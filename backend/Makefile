docker-build-run:
	git pull --rebase
	# mvn clean install package -DskipTests
	# chmod +x scripts/*
	# ./scripts/docker_build.sh
	# chmod -x scripts/*
	cd ./modules/chat-application
	pwd
	docker build . -t modules/chat-application
	docker-compose up
	cd ../../
	docker-compose up --remove-orphans
	#mvn test
