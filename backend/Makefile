docker-build:
	chmod +x scripts/*
	./scripts/docker_build.sh
	chmod -x scripts/*
	mvn clean install package -DskipTests
	docker-compose up

clean:
	chmod +x scripts/*
	./scripts/reinit-db.sh
	chmod -x scripts/*