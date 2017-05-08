# chat
Chat web app

Tecnologias:
Backend: Java 8 / JEE7
Servidor aplicação: WildFly 10.1.0.Final
Ferramentas: Swagger/Maven/WebSockets
Front-end: Angular


# Instalação/build/execução

Primeiro deve ser clonado o repositório:

git clone https://github.com/fernandops/chat.git
cd chat

Em seguida executa-se o script 'build.sh'. Este script baixa e instala o Wildfly, compila os módulos do maven, faz deploy e starta tanto o npm com o front-end quanto o wildfly com o serviço rest.

sh build.sh


## Pode ser necessário (caso ocorram erros no script)

sudo apt-get install nodejs

Caso não exista o comando 'node' ('/usr/bin/node'), executar:
sudo ln -s /usr/bin/nodejs /usr/bin/node

sudo npm install -g bower
bower install angular-websocket --save

# Instalação Wildfly (caso não seja usado o script)

wget http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.tar.gz

tar zxf wildfly-10.1.0.Final.tar.gz


# Swagger

https://app.swaggerhub.com/apis/fernandops/ChatApp/1.0.0

As definições yaml foram incluídas no repositório, no arquivo fernandops-ChatApp-1.0.0-swagger.yaml.

