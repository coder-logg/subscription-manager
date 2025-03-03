# Subscription Manager

------

## API

* POST /users - создать пользователя
* GET /users/{id} - получить информацию о пользователе
* PUT /users/{id} - обновить пользователя
* DELETE /users/{id} - удалить пользователя
* POST /users/{id}/subscriptions - добавить подписку
* GET /users/{id}/subscriptions - получить подписки пользователя
* DELETE /users/{id}/subscriptions/{sub_id} - удалить подписку
* GET /subscriptions/top - получить ТОП-3 популярных подписок

## Запуск

```shell
mvn clean package
docker-compose up
```