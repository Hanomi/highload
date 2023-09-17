# highload study project

для запуска отладки приложения потребуется docker

выполняем все команды из корня проекта

запускаем бд
```shell
docker run --name vera-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres
```
добавляем таблицы в бд
```shell
docker exec -it vera-postgres mkdir /sql
docker cp ./docs/init/init.sql vera-postgres:/sql/
docker exec -u postgres vera-postgres psql postgres postgres -f /sql/init.sql
```
собираем образ, если вносили изменения (опционально, занимает 1-2 минуты, доступен в докерхаб)
```shell
docker build --tag hanomi/vera-otus-highload-d1 .
```
запускаем
```shell
docker run --name vera-backend --add-host=host.docker.internal:host-gateway -e spring_datasource_url=jdbc:postgresql://host.docker.internal:5432/postgres -p 8080:8080 -d hanomi/vera-otus-highload-d1
```

## Postman Collection
docs/requests/vera-highload-d1.postman_collection.json

## build.sh
build.sh - содержит выше указаный скрипт единым файлом