docker-compose down
echo "y" | docker system prune -a
docker-compose up -d
docker exec -it backend_postgres_1 bash

