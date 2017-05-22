```
aptitude install graphite-web graphite-carbon 
/etc/init.d/carbon-cache status
netstat -tlnp | grep 2003
```




# Установка и настройка Graphite

Graphite состоит из 3 компонентов:

graphite - приложение и web-интерфейс

carbon - демон, в который пишутся метрики

whisper - движок баз данных, используется carbon

## Устанавливаем пакет graphite-web:
```
sudo apt-get install graphite-web
```
## Устанавливаем пакет graphite-carbon:
```
sudo apt-get install graphite-carbon
```
Whisper установится как зависимость.

## Редактируем:
```
sudo vim /etc/graphite/local_settings.py
```
```
SECRET_KEY = 'ranDomvALuE' - вводим случайное значение 
TIME_ZONE = 'Europe/Moscow' - вводим свой часовой пояс
```
## Создаем базу Graphite:
```
sudo -u _graphite graphite-manage syncdb --noinput
```
## Включаем автозагрузку carbon:
```
sudo vim /etc/default/graphite-carbon
```
```
CARBON_CACHE_ENABLED=true
```
## Запускаем carbon:
```
sudo service carbon-cache start
```
## Устанавливаем nginx:
```
sudo apt-get install nginx
```
## Приводим файл default к данному виду:
```
sudo vim /etc/nginx/sites-enabled/default
```
```
server {
           listen 80;
           root /usr/share/graphite-web/;
           error_log  /var/log/nginx/error.log;

           location / {
                uwsgi_pass  127.0.0.1:3031;
                include uwsgi_params;
   }
}
```
## Устанавливаем uwsgi:
```
sudo apt-get install uwsgi uwsgi-plugin-python
```
## Создаем файл с таким содержанием:
```
sudo vim /etc/uwsgi/apps-enabled/grafite.ini
```
```
[uwsgi]
processes = 2
socket = 127.0.0.1:3031
gid = _graphite
uid = _graphite
wsgi-file = /usr/share/graphite-web/graphite.wsgi
```
## Перезапускаем приложения:
```
sudo service nginx restart
sudo service uwsgi restart
```
