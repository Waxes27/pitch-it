docker-build-run:
	mvn install package -DskipTests
	chmod +x scripts/*
	./scripts/docker_build.sh
	chmod -x scripts/*
	docker-compose up -d
	mvn test