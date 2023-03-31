docker-build-run:
	git pull --rebase && make
	mvn install package -DskipTests
	chmod +x scripts/*
	./scripts/docker_build.sh
	chmod -x scripts/*
	docker-compose up -d --remove-orphans
	#mvn test