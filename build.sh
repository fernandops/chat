#!/bin/sh

REPDIR=`pwd`

# download e instalação Wildfly
mkdir tmp
wget -P tmp http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.tar.gz
tar zxf tmp/wildfly-10.1.0.Final.tar.gz

# build módulo servidor
cd $REPDIR/chat-backend
mvn clean install
cd $REPDIR/chat-api
mvn clean install
cd $REPDIR/api-war
mvn clean install

# execução frontend angular em Background
cd $REPDIR/chat-gui
npm start &

# deploy e start wildfly
cp $REPDIR/api-war/target/api-war-1.0.war $REPDIR/wildfly-10.1.0.Final/standalone/deployments/
$REPDIR/wildfly-10.1.0.Final/bin/standalone.sh
