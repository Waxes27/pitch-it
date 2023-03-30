docker-compose down
docker system prune -a --volumes -f
docker-compose up -d
docker exec -it backend_postgres_1 bash

