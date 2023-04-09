docker-build-run:
#	git pull --rebase
	mvn clean install package -DskipTests
	chmod +x scripts/*
	./scripts/docker_build.sh
	chmod -x scripts/*
	docker-compose up --remove-orphans
	#mvn test
